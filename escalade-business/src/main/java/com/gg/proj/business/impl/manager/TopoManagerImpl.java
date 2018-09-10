package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.TopoManager;
import com.gg.proj.consumer.contract.dao.TopoDao;
import com.gg.proj.model.bean.Topo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TopoManagerImpl implements TopoManager {

    private static final Logger logger = LogManager.getLogger();


    @Inject
    TopoDao topoDao;

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
}
