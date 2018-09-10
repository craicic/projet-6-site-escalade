package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.SecteurManager;
import com.gg.proj.consumer.contract.dao.SecteurDao;
import com.gg.proj.model.bean.Secteur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.geometric.PGpoint;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SecteurManagerImpl implements SecteurManager {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    SecteurDao secteurDao;

    @Override
    @Transactional
    public void create(Secteur model) {
        logger.debug("Entrée dans la méthode create");
        // On vérifie que le model contienne bien l'id d'un site
        if(model.getSiteId() != null){
            // puis on vérifie que getNom soit non null
            if(model.getNom() != null){
                // todo retirer ce fix de coordonnéesGPS
                model.setCoordonneesGPS(new PGpoint(1,1));
                secteurDao.create(model);
            } else
                logger.warn("Secteur doit posséder un nom");
        } else
            logger.warn("Secteur doit être lié à un site par siteId");
    }

    @Override
    public Secteur get(int id) {
        logger.debug("Entrée dans la méthode get avec l'id " + id);
        return secteurDao.get(id);
    }

    @Override
    public List<Secteur> list() {
        logger.debug("Entrée dans la méthode list");
        return secteurDao.list();
    }

    @Override
    @Transactional
    public void update(Secteur model) {
        logger.debug("Entrée dans la méthode update");
        model.setCoordonneesGPS(new PGpoint(1,1));
        secteurDao.update(model);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete avec l'id " + id);
        secteurDao.delete(id);
    }
}
