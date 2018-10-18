package com.gg.proj.consumer.contract.dao;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Secteur;
import com.gg.proj.model.bean.Site;

import java.util.List;

public interface SecteurDao extends CrudDao<Secteur> {

    public List<Secteur> getBySiteId(Integer siteId);

    List<Secteur> search(String termeDeLaRecherche);

    Secteur getSecteurByVoieId(Integer voieId);
}
