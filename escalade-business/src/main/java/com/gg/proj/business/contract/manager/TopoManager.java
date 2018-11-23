package com.gg.proj.business.contract.manager;

import com.gg.proj.business.contract.CrudManager;
import com.gg.proj.consumer.contract.dao.TopoDao;
import com.gg.proj.model.bean.Commentaire;
import com.gg.proj.model.bean.CompositionSiteTopo;
import com.gg.proj.model.bean.Site;
import com.gg.proj.model.bean.Topo;

import java.util.List;

public interface TopoManager extends CrudManager<Topo> {
    public void addComment(Commentaire commentaire, Integer topoId);

    public List<Commentaire> listComments (Integer topoId);

    public Integer getId(Topo topo);

    List<Topo> search(String termeDeLaRecherche);

    List<Site> listLinkedSite(Integer topoId);

    void setLink(CompositionSiteTopo compositionSiteTopo);

    void deleteLink(Integer topoId, Integer siteId);


    List<Topo> listTopoBySiteId(Integer siteId);
}