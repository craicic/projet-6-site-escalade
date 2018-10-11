package com.gg.proj.business.contract.manager;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Secteur;
import com.gg.proj.model.bean.Topo;

import java.util.List;

public interface SecteurManager extends CrudDao<Secteur> {
    List<Secteur> search(String termeDeLaRecherche);
}
