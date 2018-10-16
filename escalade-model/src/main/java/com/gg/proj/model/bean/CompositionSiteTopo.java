package com.gg.proj.model.bean;

public class CompositionSiteTopo {
    private Integer topoId;
    private Integer siteId;

    public CompositionSiteTopo(){}

    public CompositionSiteTopo(Integer topoId, Integer siteId){
        this.topoId = topoId;
        this.siteId = siteId;
    }

    public Integer getTopoId() {
        return topoId;
    }

    public void setTopoId(Integer topoId) {
        this.topoId = topoId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}
