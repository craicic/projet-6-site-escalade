package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.CommentaireManager;
import com.gg.proj.consumer.contract.dao.CommentaireDao;
import com.gg.proj.model.bean.Commentaire;
import com.gg.proj.model.bean.ProprieteTopo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Named
public class CommentaireManagerImpl implements CommentaireManager {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    CommentaireDao commentaireDao;

    @Override
    @Transactional
    public void create(Commentaire model) {
        logger.debug("Entrée dans la méthode create");
        if (!model.getContenuTexte().isEmpty() && model.getUtilisateurId() != null){
            // Ajout d'une date de création
            model.setDateCreation(Timestamp.from(Instant.now()));
        } else logger.warn("Erreur : contenu ou utilisateur vide");
    }

    @Override
    public Commentaire get(int id) {
        logger.debug("Entrée dans la méthode get avec l'id " + id);
        return commentaireDao.get(id);
    }

    @Override
    public List<Commentaire> list() {
        logger.debug("Entrée dans la méthode list");
        return commentaireDao.list();
    }

    @Override
    @Transactional
    public void update(Commentaire model) {
        logger.debug("Entrée dans la méthode update");
        commentaireDao.update(model);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete avec l'id " + id);
        commentaireDao.delete(id);
    }
}
