package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.SiteManager;
import com.gg.proj.consumer.contract.dao.SecteurDao;
import com.gg.proj.consumer.contract.dao.SiteDao;
import com.gg.proj.model.bean.Site;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.geometric.PGpoint;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.awt.*;
import java.util.List;

@Named
public class SiteManagerImpl implements SiteManager {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    SiteDao siteDao;


//    @Inject
//    private PlatformTransactionManager platformTransactionManager;
    @Override
    @Transactional
    public void create(Site model) {
        logger.debug("Entrée dans la méthode create");
        if (!model.getNom().isEmpty()) {
            // todo retirer ce fix de coordonnéesGPS
            model.setCoordonneesGPS(new PGpoint(1,1));
            siteDao.create(model);
        }
        else
            logger.warn("Le champ nom doit être renseigné");
    }

    @Override
    public Site get(int id) {
        logger.debug("Entrée dans la méthode get");
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
        model.setCoordonneesGPS(new PGpoint(1,1));
        siteDao.update(model);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete");
        siteDao.delete(id);
    }
}
