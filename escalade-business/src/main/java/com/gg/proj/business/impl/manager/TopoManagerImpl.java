package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.TopoManager;
import com.gg.proj.consumer.contract.dao.CommentaireDao;
import com.gg.proj.consumer.contract.dao.CommentaireSurTopoDao;
import com.gg.proj.consumer.contract.dao.TopoDao;
import com.gg.proj.model.bean.Commentaire;
import com.gg.proj.model.bean.CommentaireSurTopo;
import com.gg.proj.model.bean.Topo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Named
public class TopoManagerImpl implements TopoManager {

    private static final Logger logger = LogManager.getLogger();


    @Inject
    TopoDao topoDao;

    @Inject
    CommentaireDao commentaireDao;

    @Inject
    CommentaireSurTopoDao commentaireSurTopoDao;

    @Inject
    private PlatformTransactionManager platformTransactionManager;

    // todo implémenter des vérification de saisie aux updates de tout les models
    @Override
    @Transactional
    public void create(Topo model) {
//                 Si le titre à été rempli, la transaction est effectuée
        logger.debug("Entrée dans la méthode create");
        if (!model.getTitre().isEmpty()) {
            topoDao.create(model);
        } else {
            logger.warn("Le titre doit être non null.");
        }

    }

    @Override
    public Topo get(int id) {
        logger.debug("Entrée dans la méthode get avec l'id " + id);
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
     * @param commentaire un objet commentaire dont la propriété contenuTexte est non null
     * @param topoId l'id du topo associé?
     */
    @Override
    @Transactional
    public void addComment(Commentaire commentaire, Integer topoId){
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
    public List<Commentaire> listComments (Integer topoId){
        return commentaireDao.getCommentsByTopoId(topoId);
    }

    @Override
    @Transactional
    public Integer getId(Topo topo){
        return topoDao.getId(topo);
    }
}
