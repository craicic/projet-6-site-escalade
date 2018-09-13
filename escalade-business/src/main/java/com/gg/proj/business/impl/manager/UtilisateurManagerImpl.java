package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.UtilisateurManager;
import com.gg.proj.consumer.contract.dao.UtilisateurDao;
import com.gg.proj.model.bean.Utilisateur;
import com.gg.proj.technical.GenerateurUUID;
import com.gg.proj.technical.ManagerDeMotDePasse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Named
public class UtilisateurManagerImpl implements UtilisateurManager {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    UtilisateurDao utilisateurDao;

//    @Inject
//    PlatformTransactionManager platformTransactionManager;

    @Override
    @Transactional
    public void create(Utilisateur model) {
        // todo amélioration de la création de compte
        logger.debug("Entrée dans la méthode create");
        // Génération de l'UUID via le module technical
        GenerateurUUID generateurUUID = new GenerateurUUID();
        String uuid = generateurUUID.getUuid().toString();
        model.setUuid(uuid);

        // Gestion de la date
        Date dateDuJour = Date.from(Instant.now());
        model.setDateInscription(dateDuJour);

        // Create d'un hash a partir d'un mot de passe
        model.setHashMotDePasse(ManagerDeMotDePasse.hashPassword(model.getHashMotDePasse()));

        utilisateurDao.create(model);
    }

    @Override
    public Utilisateur get(int id) {
        logger.debug("Entrée dans la méthode get");
        return utilisateurDao.get(id);
    }

    @Override
    public List<Utilisateur> list() {
        logger.debug("Entrée dans la méthode list");
        return utilisateurDao.list();
    }

    @Override
    @Transactional
    public void update(Utilisateur model) {
        logger.debug("Entrée dans la méthode update");
        utilisateurDao.update(model);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete");
        utilisateurDao.delete(id);
    }

    @Override
    @Transactional
    public Utilisateur get(String identifiant, String motDePasse) throws Exception{
        // todo affiner l'exception
        String hashDuMotDePasse = utilisateurDao.getHash(identifiant);
        if (ManagerDeMotDePasse.checkPassword(motDePasse,hashDuMotDePasse)) {
            return utilisateurDao.get(identifiant);
        } else throw new Exception("Mot de passe invalide");
    }

}
