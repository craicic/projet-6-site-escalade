package com.gg.proj.consumer.contract.dao;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Commentaire;

import java.util.List;

public interface CommentaireDao extends CrudDao<Commentaire> {

    public List<Commentaire> getCommentsByTopoId(Integer topoId);

    public Integer getId(Commentaire model);
}
