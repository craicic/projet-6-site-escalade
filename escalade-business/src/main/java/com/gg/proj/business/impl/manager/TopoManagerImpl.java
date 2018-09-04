package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.TopoManager;
import com.gg.proj.consumer.contract.dao.TopoDao;
import com.gg.proj.model.bean.Topo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TopoManagerImpl implements TopoManager {

    private static final Logger logger = LogManager.getLogger();


    @Inject
    TopoDao TopoDao;

    @Inject
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void create(Topo model) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                // Si le titre à été rempli, la transaction est effectuée
//                Topo topo = (Topo)model;
                if (!model.getTitre().isEmpty()) {
                    TopoDao.create(model);
                } else {
                    logger.warn("Le titre doit être non null.");
                    status.setRollbackOnly();
                }
            }
        });
    }

    @Override
    public Topo get(int id) {
        logger.debug("Entrée dans TopoManagerImpl.get avec l'id " + id);
        return (Topo) TopoDao.get(id);
    }

    @Override
    public List<Topo> list() {
        return TopoDao.list();
    }

    @Override
    public void update(Topo model) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                TopoDao.update(model);
            }
        });
    }

    @Override
    public void delete(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                TopoDao.delete(id);
            }
        });

    }
}
