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
import java.time.LocalDate;
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
    public void create(Emprunt emprunt) {
        logger.debug("Entrée dans la méthode create");
        if (emprunt.getUtilisateurId() != null) {
            LocalDate date = LocalDate.now();
            emprunt.setDateEmprunt(date);
            emprunt.setDateRetour(date.plusWeeks(3));
            empruntDao.create(emprunt);
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

    /**
     * Cette méthode solicite la dao pour récupérer la liste des topos disponibles à l'emprunt
     *
     * @return la liste de topo disponible
     */
    @Override
    @Transactional
    public List<Topo> listAvailableTopo() {
        logger.debug("Entrée dans la méthode listAvailableTopo");
        List<Topo> listTopo = topoDao.listAvailableTopo();
        for (Topo topo : listTopo) {
            // On raccourci la description à 50 caractère.
            topo.setDescription(shortenDescription(topo.getDescription()));
        }
        return listTopo;
    }

    //todo javadoc
    @Override
    @Transactional
    public List<Topo> listBorrowedTopo(Integer borrowerId) {
        logger.debug("Entrée dans la méthode listBorrowedTopo avec le borrowerId" + borrowerId);
        return topoDao.listTopoByBorrowerId(borrowerId);
    }

    // todo javadoc
    @Override
    @Transactional
    public List<Topo> listLoanedTopo(Integer loanerId) {
        logger.debug("Entrée dans la méthode listLoanedTopo avec le loanerId" + loanerId);
        return topoDao.listTopoByLoanerId(loanerId);
    }

    // todo javadoc
    @Override
    @Transactional
    public boolean isReserved(Integer topoId) {
        logger.debug("Entrée dans la méthode isReserved avec le topoId" + topoId);
        List<Emprunt> listEmprunt = empruntDao.getEmpruntByTopoId(topoId);
        for (Emprunt e : listEmprunt) {
            if (e.getDateRetour().isAfter(LocalDate.now()))
                return true;
        }
        return false;
    }

    @Override
    @Transactional
    public List<Emprunt> listEmpruntByTopoId(Integer topoId) {
        return empruntDao.getFullEmpruntByTopoId(topoId);
    }

    // todo javadoc
    private String shortenDescription(String description) {
        if (description.length() > 50) {
            description = description.substring(0, 46) + "...";
        }
        return description;
    }

}
