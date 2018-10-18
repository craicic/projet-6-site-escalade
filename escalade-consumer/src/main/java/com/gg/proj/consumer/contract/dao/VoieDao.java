package com.gg.proj.consumer.contract.dao;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Voie;

import java.util.List;

public interface VoieDao extends CrudDao<Voie> {
    List<Voie> search(String termeDeLaRecherche);

    List<Voie> listBySecteurId(Integer secteurId);
}
