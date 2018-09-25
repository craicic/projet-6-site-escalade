package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.VoieManager;
import com.gg.proj.consumer.contract.dao.VoieDao;
import com.gg.proj.model.bean.Voie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class VoieManagerImpl implements VoieManager {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    VoieDao voieDao;

    @Override
    @Transactional
    public void create(Voie model) {
        logger.debug("Entrée dans la méthode create");
        // On vérifie que le model contienne bien l'id d'un site
        if(model.getSecteurId() != null){
            // puis on vérifie que getNom soit non null
            if(model.getNom() != null){
                voieDao.create(model);
            } else
                logger.warn("Voie doit posséder un nom");
        } else
            logger.warn("Voie doit être lié à un secteur par secteurId");
    }

    @Override
    public Voie get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + id);
        return voieDao.get(id);
    }

    @Override
    public List<Voie> list() {
        logger.debug("Entrée dans la méthode list");
        return voieDao.list();
    }

    @Override
    @Transactional
    public void update(Voie model) {
        logger.debug("Entrée dans la méthode update");
        voieDao.update(model);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete avec l'id " + id);
        voieDao.delete(id);
    }
}
