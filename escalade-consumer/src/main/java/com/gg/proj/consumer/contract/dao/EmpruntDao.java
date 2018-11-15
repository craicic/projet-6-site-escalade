package com.gg.proj.consumer.contract.dao;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Emprunt;
import com.gg.proj.model.bean.Topo;

import java.util.List;

public interface EmpruntDao extends CrudDao<Emprunt> {

    List<Emprunt> getEmpruntByTopoId(Integer topoId);

    List<Emprunt> getFullEmpruntByTopoId(Integer topoId);


}
