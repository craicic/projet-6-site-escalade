package com.gg.proj.consumer.contract.dao;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Secteur;

import java.util.List;

public interface SecteurDao extends CrudDao<Secteur> {

    public List<Secteur> getBySiteId(Integer siteId);
}
