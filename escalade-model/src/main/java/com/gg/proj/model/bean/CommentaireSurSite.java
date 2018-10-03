package com.gg.proj.model.bean;

public class CommentaireSurSite {
    private Integer siteId;
    private Integer commentaireId;

    public CommentaireSurSite(){}
    public CommentaireSurSite(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getSiteId() {
        return siteId;
    }
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
    public Integer getCommentaireId() {
        return commentaireId;
    }
    public void setCommentaireId(Integer commentaireId) {
        this.commentaireId = commentaireId;
    }

}
