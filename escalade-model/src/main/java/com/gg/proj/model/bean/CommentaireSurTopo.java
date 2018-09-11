package com.gg.proj.model.bean;

public class CommentaireSurTopo {

    private Integer topoId;
    private Integer commentaireId;

    public CommentaireSurTopo(){}
    public CommentaireSurTopo(Integer topoId) {
        this.topoId = topoId;
    }

    public Integer getTopoId() {
        return topoId;
    }
    public void setTopoId(Integer topoId) {
        this.topoId = topoId;
    }
    public Integer getCommentaireId() {
        return commentaireId;
    }
    public void setCommentaireId(Integer commentaireId) {
        this.commentaireId = commentaireId;
    }

 }
