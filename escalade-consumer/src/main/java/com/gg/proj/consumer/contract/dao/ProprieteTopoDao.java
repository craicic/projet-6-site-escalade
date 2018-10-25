package com.gg.proj.consumer.contract.dao;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.ProprieteTopo;
import com.gg.proj.model.bean.Utilisateur;

import java.util.List;

public interface ProprieteTopoDao extends CrudDao<ProprieteTopo> {

    List<Utilisateur> listAllOnwersByTopoId(Integer topoId);
}
