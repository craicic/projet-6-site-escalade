package com.gg.proj.business.contract.manager;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Emprunt;
import com.gg.proj.model.bean.Topo;
import com.gg.proj.model.bean.Utilisateur;
import com.gg.proj.technical.exceptions.DateInputException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface EmpruntManager extends CrudDao<Emprunt> {

    @Transactional
    void create(Emprunt emprunt, Date date) throws DateInputException;

    List<Utilisateur> listAllOnwersByTopoId(Integer topoId);

    List<Topo> listAvailableTopo(Integer utilisateurId);

    List<Topo> listBorrowedTopo(Integer borrowerId);

    List<Topo> listLoanedTopo(Integer loanerId);

    boolean isReserved(Integer topoId);

    List<Emprunt> listEmpruntByTopoId(Integer topoId);
}
