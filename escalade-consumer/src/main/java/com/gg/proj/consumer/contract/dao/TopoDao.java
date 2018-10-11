package com.gg.proj.consumer.contract.dao;
import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Topo;

import java.util.List;

public interface TopoDao extends CrudDao<Topo> {
    public Integer getId(Topo topo);

    List<Topo> search(String termeDeLaRecherche);
}
