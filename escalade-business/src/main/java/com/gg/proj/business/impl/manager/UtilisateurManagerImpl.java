package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.UtilisateurManager;
import com.gg.proj.consumer.contract.dao.UtilisateurDao;
import com.gg.proj.model.bean.Utilisateur;
import com.gg.proj.technical.logger.GenerateurUUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Named
public class UtilisateurManagerImpl implements UtilisateurManager {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    private UtilisateurDao utilisateurDao;

    @Inject
    PlatformTransactionManager platformTransactionManager;

    @Override
    @Transactional
    public void create(Utilisateur model) {
        logger.debug("Entrée dans la méthode create");
        // Génération de l'UUID via le module technical
        GenerateurUUID generateurUUID = new GenerateurUUID();
        String uuid = generateurUUID.getUuid().toString();
        model.setUuid(uuid);

        // Gestion de la date
        Date dateDuJour = Date.from(Instant.now());
        model.setDateInscription(dateDuJour);

        utilisateurDao.create(model);
    }

    @Override
    public Utilisateur get(int id) {
        logger.debug("Entrée dans la méthode get");
        return (Utilisateur) utilisateurDao.get(id);
    }

    @Override
    public List<Utilisateur> list() {
        logger.debug("Entrée dans la méthode list");
        return utilisateurDao.list();
    }
    // todo
    @Override
    public void update(Utilisateur model) {

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete");
        utilisateurDao.delete(id);
    }
}
