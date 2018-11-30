package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.TopoManager;
import com.gg.proj.consumer.contract.dao.*;
import com.gg.proj.model.bean.*;
import com.gg.proj.technical.GenerateurDeDifficulte;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@Named
public class TopoManagerImpl implements TopoManager {

    private static final Logger logger = LogManager.getLogger();


    @Inject
    TopoDao topoDao;

    //   Injection de la siteDao pour la méthode listLinkedSite()
    @Inject
    SiteDao siteDao;

    @Inject
    CommentaireDao commentaireDao;

    @Inject
    CommentaireSurTopoDao commentaireSurTopoDao;

    @Inject
    CompositionSiteTopoDao compositionSiteTopoDao;

//    @Inject
//    private PlatformTransactionManager platformTransactionManager;

    // todo implémenter des vérification de saisie aux updates de tout les models
    @Override
    @Transactional
    public void create(Topo model) {
//                 Si le titre à été rempli, la transaction est effectuée
        logger.debug("Entrée dans la méthode create");
        if (!model.getTitre().isEmpty()) {
            // todo fix en attendant de retirer empreintable du mpd
            model.setEmpreintable(true);
            topoDao.create(model);
        } else {
            logger.warn("Le titre doit être non null.");
        }

    }

    @Override
    public Topo get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + id);
        return topoDao.get(id);
    }

    @Override
    public List<Topo> list() {
        logger.debug("Entrée dans la méthode list");
        return topoDao.list();
    }

    @Override
    @Transactional
    public void update(Topo model) {
        logger.debug("Entrée dans la méthode update");
        model.setEmpreintable(true);
        topoDao.update(model);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete avec l'id " + id);
        topoDao.delete(id);
    }

    /**
     * Cette méthode permet l'ajout d'un commentaire lié à un topo en BDD. Cette méthode se charger d'ajouté le timestamp sur l'objet commentaire.
     * Elle ajoute un commentaire en bdd et ajoute également une ligne dans la table commentaire_sur_topo.
     *
     * @param commentaire un objet commentaire dont la propriété contenuTexte est non null
     * @param topoId      l'id du topo associé
     */
    @Override
    @Transactional
    public void addComment(Commentaire commentaire, Integer topoId) {
        logger.debug("Entrée dans la méthode addComment avec le topoId : " + topoId);
        // Ajout du timestamp de la création du commentaire
        commentaire.setDateCreation(Timestamp.from(Instant.now()));
        // Solocitation de la Dao pour création du commentaire
        commentaireDao.create(commentaire);
        // On récupère l'id
        Integer commentaireId = commentaireDao.getId(commentaire);

        // Il reste a créer une entrée dans la table de composition commentaire_sur_topo
        // On créé un bean CommentaireSurTopo pour lui attribuer les valeurs.
        CommentaireSurTopo commentaireSurTopo = new CommentaireSurTopo();
        commentaireSurTopo.setCommentaireId(commentaireId);
        commentaireSurTopo.setTopoId(topoId);
        // Création de l'entrée
        commentaireSurTopoDao.create(commentaireSurTopo);
    }

    /**
     * @param topoId : l'id du topo lié au commentaire
     * @return la liste des commentaires lié au topo
     */
    @Override
    @Transactional
    public List<Commentaire> listComments(Integer topoId) {
        logger.debug("Entrée dans la méthode listComments avec l'id " + topoId);
        return commentaireDao.getCommentsByTopoId(topoId);
    }

    /**
     * Cette méthode solicite la Dao pour en récupéré l'id du topo associé au topo en paramètre
     *
     * @param topo
     * @return l'id d'un topo.
     */
    @Override
    @Transactional
    public Integer getId(Topo topo) {
        return topoDao.getId(topo);
    }

    /**
     * Solicite la Dao pour recherche de la liste des topos
     *
     * @param termeDeLaRecherche
     * @return une liste de topos correspondant.
     */
    @Override
    @Transactional
    public List<Topo> search(String termeDeLaRecherche) {
        logger.debug("Entrée dans la méthode search avec le terme de recherche : " + termeDeLaRecherche);
        List<Topo> listTopo = topoDao.search(termeDeLaRecherche);

        if (!listTopo.isEmpty()) {
            logger.debug("liste remplie");
            for (Topo topo : listTopo) {
                logger.debug(topo.getTitre());
            }
        } else {
            logger.debug("liste vide");
        }
        return listTopo;
    }

    /**
     * Cette fonction reçoit deux difficultés de grimpe, elle génère une liste des difficultés intermédiaires et envoit
     * la liste à la dao topoDao pour traitement.
     *
     * @param minDiff la difficulté minimale à rechercher
     * @param maxDiff la difficulté maximale à rechercher
     * @return un liste des topos.
     */
    @Override
    @Transactional
    public List<Topo> advancedSearchByDifficulty(String minDiff, String maxDiff, String termeDeLaRecherche) throws InputMismatchException {
        logger.debug("Entrée dans la méthode advancedSearchByDifficulty avec minDiff : " + minDiff + " et maxDiff : " + maxDiff);

        if (GenerateurDeDifficulte.isOrdinate(minDiff, maxDiff)) {
            List<Topo> listRetrievedTopo = topoDao.search(termeDeLaRecherche);
            if (!listRetrievedTopo.isEmpty()) {
                List<Integer> listTopoId = new ArrayList<>();
                for (Topo t : listRetrievedTopo) {
                    listTopoId.add(t.getId());
                }
                listRetrievedTopo = topoDao.listTopoByDifficulty(GenerateurDeDifficulte.Generateur(minDiff, maxDiff), listTopoId);
            }
            return listRetrievedTopo;
        } else {
            throw new InputMismatchException("La cotation max doit être supérieur à la cotation min");
        }
    }

    /**
     * Cette méthode renvoie la liste des site associées au topo
     *
     * @param topoId
     * @return list des site associés
     */
    @Override
    @Transactional
    public List<Site> listLinkedSite(Integer topoId) {
        logger.debug("Entrée dans la méthode listLinkedSite avec le topoId : " + topoId);
        List<Site> listSite = siteDao.getListByTopoId(topoId);
        return listSite;
    }

    /**
     * Cette méthode appel la dao pour création d'une entrée Composition_site_topo
     *
     * @param compositionSiteTopo
     */
    @Override
    @Transactional
    public void setLink(CompositionSiteTopo compositionSiteTopo) {
        logger.debug("Entrée dans la méthode setLink");

        try {
            // On va faire appelle a la daoCompositionSiteTopo
            compositionSiteTopoDao.create(compositionSiteTopo);
        } catch (DataIntegrityViolationException e) {
            logger.warn(e.getMessage());
        }
    }

    /**
     * Supprime l'entrée compositionSiteTopo associée en bdd
     *
     * @param topoId
     * @param siteId
     */
    @Override
    @Transactional
    public void deleteLink(Integer topoId, Integer siteId) {
        logger.debug("Entrée dans la méthode deleteLink avec topoId : " + topoId + " et siteId : " + siteId);
        CompositionSiteTopo compositionSiteTopo = new CompositionSiteTopo(topoId, siteId);
        compositionSiteTopoDao.deleteByModel(compositionSiteTopo);
    }

    /**
     * Solicite la dao et retourne les topos lié au site d'id siteId
     *
     * @param siteId
     * @return
     */
    @Override
    @Transactional
    public List<Topo> listTopoBySiteId(Integer siteId) {
        return topoDao.listTopoBySiteId(siteId);
    }

}
