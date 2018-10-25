package com.gg.proj.model.bean;

public enum EnumStatus {
    AVAILABLE("available"),
    RESERVED("reserved"),
    WAITING_FOR_VALIDATION("waiting for validation"),
    AFK_OWNER("afk owner"),
    MISSING("missing");

    private String name;

    EnumStatus(String name){
        this.name = name;

    }

    public String toString(){
        return name;
    }


}
