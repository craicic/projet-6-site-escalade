package com.gg.proj.model.bean;

public class ProprieteTopo {
    private Integer topoId;
    private Integer utilisateurId;
    private String status;
    private EnumStatus enumStatus;

    public ProprieteTopo(){}

    public Integer getTopoId() {
        return topoId;
    }

    public void setTopoId(Integer topoId) {
        this.topoId = topoId;
    }

    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Integer utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EnumStatus getEnumStatus() {
        return enumStatus;
    }

    public void setEnumStatus(EnumStatus enumStatus) {
        this.enumStatus = enumStatus;
    }
}
