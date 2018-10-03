package com.gg.proj.model.bean;

public class CommentaireSurVoie {
    private Integer voieId;
    private Integer commentaireId;

    public CommentaireSurVoie(){}
    public CommentaireSurVoie(Integer voieId) {
        this.voieId = voieId;
    }

    public Integer getVoieId() {
        return voieId;
    }
    public void setVoieId(Integer voieId) {
        this.voieId = voieId;
    }
    public Integer getCommentaireId() {
        return commentaireId;
    }
    public void setCommentaireId(Integer commentaireId) {
        this.commentaireId = commentaireId;
    }

}
