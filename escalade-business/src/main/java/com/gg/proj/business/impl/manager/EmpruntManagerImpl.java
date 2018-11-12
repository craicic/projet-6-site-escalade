package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.EmpruntManager;
import com.gg.proj.consumer.contract.dao.EmpruntDao;
import com.gg.proj.consumer.contract.dao.TopoDao;
import com.gg.proj.model.bean.Emprunt;
import com.gg.proj.model.bean.Topo;
import com.gg.proj.model.bean.Utilisateur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class EmpruntManagerImpl implements EmpruntManager {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    EmpruntDao empruntDao;

    @Inject
    TopoDao topoDao;

    @Override
    @Transactional
    public void create(Emprunt model) {
        logger.debug("Entrée dans la méthode create");
        if (model.getUtilisateurId() != null) {
            if (model.getDateEmprunt() != null && model.getDateRetour() != null)
                empruntDao.create(model);
            else
                logger.warn("Les dates empreint et retour doivent être spécifiées");
        } else
            logger.warn("Un empreint doit être lié a un utilisateur par utilisateur_id");
    }

    @Override
    public Emprunt get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + id);
        return empruntDao.get(id);
    }

    @Override
    public List<Emprunt> list() {
        logger.debug("Entrée dans la méthode list");
        return empruntDao.list();
    }

    @Override
    @Transactional
    public void update(Emprunt model) {
        logger.debug("Entrée dans la méthode update");
        empruntDao.update(model);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete avec l'id " + id);
        empruntDao.delete(id);
    }

    // todo verifier la pertinance de cette méthode listAllOnwersByTopoId
    @Override
    @Transactional
    public List<Utilisateur> listAllOnwersByTopoId(Integer topoId) {
        logger.debug("Entrée dans la méthode listAllOnwersByTopoId avec le topoId : " + topoId);
        return null;
    }

    // todo verifier la pertinance de cette méthode setTopoOwner
    @Override
    @Transactional
    public void setTopoOwner(Integer topoId, Integer utilisateurId) {
        logger.debug("Entrée dans la méthode setTopoOwner avec le topoId : " + topoId + " et l'utilisateurId : " + utilisateurId);

    }

    /**
     * Cette méthode solicite la dao pour récupérer la liste des topos disponibles à l'emprunt
     *
     * @return la liste de topo disponible
     */
    @Override
    public List<Topo> listAvailableTopo() {
        logger.debug("Entrée dans la méthode listAvailableTopo");
        List<Topo> listTopo = topoDao.listAvailableTopo();
        for (Topo topo : listTopo) {
            // On raccourci la description à 50 caractère.
            topo.setDescription(shortenDescription(topo.getDescription()));
        }
        return listTopo;
    }

    private String shortenDescription(String descritpion) {
        if (descritpion.length() <= 50)
            return descritpion;
        else {
            return descritpion.substring(0, 49);
        }

    }
}
