package com.gg.proj.business.contract.manager;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Secteur;

import java.util.List;

public interface SecteurManager extends CrudDao<Secteur> {
    List<Secteur> search(String termeDeLaRecherche);

    Secteur getLinkedSecteurByVoieId(Integer voieId);

    void create(Secteur secteur, Integer siteId);

    List<Secteur> listLinkedSecteurBySiteId(Integer siteId);

    List<Secteur> advancedSearchByDifficulty(String minDiff, String maxDiff, String termeDeLaRecherche);

    Integer getId(Secteur secteur);
}
