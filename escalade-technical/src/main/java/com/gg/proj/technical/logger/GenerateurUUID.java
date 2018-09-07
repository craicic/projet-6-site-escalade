package com.gg.proj.technical.logger;

import java.util.UUID;

public class GenerateurUUID {

    private UUID uuid;

    public GenerateurUUID(){
        uuid = new UUID(2,10);
    }

    public UUID getUuid() {
        return uuid;
    }
}
