package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.UtilisateurManager;
import com.gg.proj.consumer.contract.dao.UtilisateurDao;
import com.gg.proj.model.bean.Utilisateur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UtilisateurManagerImpl implements UtilisateurManager {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    private UtilisateurDao utilisateurDao;

    // todo
    @Override
    public void create(Utilisateur model) {

    }
    // todo
    @Override
    public Utilisateur get(int id) {
        return null;
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
    // todo
    @Override
    public void delete(Integer id) {

    }
}
