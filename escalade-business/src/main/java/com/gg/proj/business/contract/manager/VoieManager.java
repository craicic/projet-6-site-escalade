package com.gg.proj.business.contract.manager;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Commentaire;
import com.gg.proj.model.bean.Voie;

public interface VoieManager extends CrudDao<Voie> {
    public void addComment(Commentaire commentaire, Integer voieId);
}
