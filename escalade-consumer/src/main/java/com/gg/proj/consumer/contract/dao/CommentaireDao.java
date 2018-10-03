package com.gg.proj.consumer.contract.dao;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Commentaire;

import java.util.List;

public interface CommentaireDao extends CrudDao<Commentaire> {

    List<Commentaire> getCommentsByTopoId(Integer topoId);

    Integer getId(Commentaire commentaire);

    List<Commentaire> getCommentsByVoieId(Integer voieId);

    List<Commentaire> getCommentsBySiteId(Integer siteId);
}
