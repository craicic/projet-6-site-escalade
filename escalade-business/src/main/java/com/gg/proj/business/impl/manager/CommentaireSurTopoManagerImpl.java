package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.CommentaireSurTopoManager;
import com.gg.proj.consumer.contract.dao.CommentaireSurTopoDao;
import com.gg.proj.model.bean.CommentaireSurTopo;
import com.gg.proj.model.bean.ProprieteTopo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireSurTopoManagerImpl implements CommentaireSurTopoManager {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    CommentaireSurTopoDao commentaireSurTopoDaoDao;

    @Override
    public void create(CommentaireSurTopo model) {

        logger.debug("Entrée dans la méthode create");
        commentaireSurTopoDaoDao.create(model);
    }

    @Override
    public CommentaireSurTopo get(int commentaireId) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + commentaireId);
        return commentaireSurTopoDaoDao.get(commentaireId);
    }

    @Override
    public List<CommentaireSurTopo> list() {

        logger.debug("Entrée dans la méthode list");
        return commentaireSurTopoDaoDao.list();
    }

    @Override
    public void update(CommentaireSurTopo model) {
        logger.debug("Entrée dans la méthode update");
        commentaireSurTopoDaoDao.update(model);
    }

    @Override
    public void delete(Integer commentaireId) {
        logger.debug("Entrée dans la méthode delete avec l'id " + commentaireId);
        commentaireSurTopoDaoDao.delete(commentaireId);
    }
}
