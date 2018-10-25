package com.gg.proj.business.contract.manager;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Emprunt;
import com.gg.proj.model.bean.Utilisateur;

import java.util.List;

public interface EmpruntManager extends CrudDao<Emprunt> {

    List<Utilisateur> listAllOnwersByTopoId(Integer topoId);

    void setTopoOwner(Integer topoId, Integer utilisateurId);

}
