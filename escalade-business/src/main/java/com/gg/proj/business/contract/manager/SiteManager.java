package com.gg.proj.business.contract.manager;

import com.gg.proj.business.contract.CrudManager;
import com.gg.proj.model.bean.Commentaire;
import com.gg.proj.model.bean.Site;
import com.gg.proj.model.bean.Topo;

import java.util.List;

public interface SiteManager extends CrudManager<Site> {

    public void addComment(Commentaire commentaire, Integer id);

    public List<Commentaire> listComments(Integer id);

    List<Site> search(String termeDeLaRecherche);
}
