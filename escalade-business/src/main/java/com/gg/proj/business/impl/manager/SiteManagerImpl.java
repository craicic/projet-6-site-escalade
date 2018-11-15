package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.SiteManager;
import com.gg.proj.consumer.contract.dao.CommentaireDao;
import com.gg.proj.consumer.contract.dao.CommentaireSurSiteDao;
import com.gg.proj.consumer.contract.dao.SiteDao;
import com.gg.proj.model.bean.Commentaire;
import com.gg.proj.model.bean.CommentaireSurSite;
import com.gg.proj.model.bean.Coordonnees;
import com.gg.proj.model.bean.Site;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Named
public class SiteManagerImpl implements SiteManager {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    SiteDao siteDao;

    @Inject
    CommentaireDao commentaireDao;

    @Inject
    CommentaireSurSiteDao commentaireSurSiteDao;

    @Override
    @Transactional
    public void create(Site model) {
        logger.debug("Entrée dans la méthode create");
        if (!model.getNom().isEmpty()) {
            // todo retirer ce fix de coordonnéesGPS
            model.setCoordonneeX(1.0);
            model.setCoordonneeY(1.0);
            siteDao.create(model);
        } else
            logger.warn("Le champ nom doit être renseigné");
    }

    @Override
    public Site get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo");
        return siteDao.get(id);
    }

    @Override
    public List<Site> list() {
        logger.debug("Entrée dans la méthode list");
        return siteDao.list();
    }

    @Override
    @Transactional
    public void update(Site model) {
        logger.debug("Entrée dans la méthode update");
        // todo retirer ce fix de coordonnéesGPS
        model.setCoordonneeX(1.0);
        model.setCoordonneeY(1.0);
        siteDao.update(model);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete");
        // supprime les commentaire
        //
        siteDao.delete(id);
    }

    /**
     * Cette méthode permet l'ajout d'un commentaire lié à un site en BDD. Cette méthode se charger d'ajouté le timestamp sur l'objet commentaire.
     * Elle ajoute un commentaire en bdd et ajoute également une ligne dans la table commentaire_sur_site.
     *
     * @param commentaire un objet commentaire dont la propriété contenuTexte est non null
     * @param siteId      l'id du site associé
     */
    @Override
    @Transactional
    public void addComment(Commentaire commentaire, Integer siteId) {
        logger.debug("Entrée dans la méthode addComment avec l'id " + siteId);
        // Ajout du timestamp de la création du commentaire
        commentaire.setDateCreation(Timestamp.from(Instant.now()));
        // Solocitation de la Dao pour création du commentaire
        commentaireDao.create(commentaire);
        // On récupère l'id
        Integer commentaireId = commentaireDao.getId(commentaire);
        // Il reste a créer une entrée dans la table de composition commentaire_sur_site
        // On créé un bean CommentaireSurSite pour lui attribuer les valeurs.
        CommentaireSurSite commentaireSurSite = new CommentaireSurSite();
        commentaireSurSite.setCommentaireId(commentaireId);
        commentaireSurSite.setSiteId(siteId);
        // Création de l'entrée
        commentaireSurSiteDao.create(commentaireSurSite);
    }

    /**
     * Commentaire qui renvoyé la list des commentaire associés avec un site par son siteId
     *
     * @param siteId
     * @return liste de commentaire
     */
    @Override
    @Transactional
    public List<Commentaire> listComments(Integer siteId) {
        logger.debug("Entrée dans la méthode listComments avec l'id " + siteId);
        return commentaireDao.getCommentsBySiteId(siteId);
    }

    /**
     * Solicite la Dao pour recherche de la liste des sites
     *
     * @param termeDeLaRecherche
     * @return une liste de sites correspondant.
     */
    @Override
    @Transactional
    public List<Site> search(String termeDeLaRecherche) {
        logger.debug("Entrée dans la méthode search avec le terme de recherche :" +termeDeLaRecherche);
        return siteDao.search(termeDeLaRecherche);
    }

    /**
     * Liste les sites qui ne sont pas déjà lié au topo d'id topoId
     *
     * @param topoId
     * @return liste de sites
     */
    @Override
    @Transactional
    public List<Site> listSiteNotLinked(Integer topoId) {
        logger.debug("Entrée dans la méthode listSiteNotLinked avec le topoId :" +topoId);
        List<Site> listSite = siteDao.getListByTopoIdReverse(topoId);
        return listSite;
    }

    /**
     * Recupére un objet Site associé au secteurId
     *
     * @param secteurId
     * @return Site
     */
    @Override
    public Site getLinkedSiteBySecteurId(Integer secteurId) {
        logger.debug("Entrée dans la méthode getLinkedSiteBySecteurId() avec le secteurId " + secteurId );
        return siteDao.getSiteBySecteurId(secteurId);
    }
}
