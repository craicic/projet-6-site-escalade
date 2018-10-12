package com.gg.proj.consumer.contract.dao;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Site;

import java.util.List;

public interface SiteDao extends CrudDao<Site> {
    List<Site> search(String termeDeLaRecherche);
}
