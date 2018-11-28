package com.gg.proj.business.contract.manager;

import com.gg.proj.business.contract.CrudManager;
import com.gg.proj.model.bean.Commentaire;
import com.gg.proj.model.bean.Site;

import java.util.List;

public interface SiteManager extends CrudManager<Site> {

    public void addComment(Commentaire commentaire, Integer id);

    public List<Commentaire> listComments(Integer id);

    List<Site> search(String termeDeLaRecherche);

    List<Site> listSiteNotLinked(Integer topoId);

    Site getLinkedSiteBySecteurId(Integer secteurId);

    List<Site> advancedSearchByDifficulty(String minDiff, String maxDiff, String termeDeLaRecherche);
}
