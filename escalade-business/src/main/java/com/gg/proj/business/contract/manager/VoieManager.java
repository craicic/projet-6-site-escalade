package com.gg.proj.business.contract.manager;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Commentaire;
import com.gg.proj.model.bean.Voie;

import java.util.List;

public interface VoieManager extends CrudDao<Voie> {
    public void addComment(Commentaire commentaire, Integer voieId);

    public List<Commentaire> listComments(Integer id);

    List<Voie> search(String termeDeLaRecherche);

    List<Voie> listLinkedVoie(Integer secteurId);

    void create(Voie voie, Integer secteurId);

    List<Voie> advancedSearchByDifficulty(String minDiff, String maxDiff, String termeDeLaRecherche);
}
