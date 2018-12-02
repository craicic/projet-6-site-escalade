package com.gg.proj.consumer.contract.dao;
import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Topo;

import java.util.List;

public interface TopoDao extends CrudDao<Topo> {

    Integer getIdByTitre(String titreTopo);

    List<Topo> search(String termeDeLaRecherche);

    List<Topo> listAvailableTopo();

    List<Topo> listTopoByBorrowerId(Integer borrowerId);

    List<Topo> listTopoByLoanerId(Integer loanerId);


    List<Topo> listTopoBySiteId(Integer siteId);

    List<Topo> listTopoByDifficulty(List<String> listDifficultes, List<Integer> listTopoId);

    List<Topo> listAvailableTopoByUtilisateurId(Integer utilisateurId);
}
