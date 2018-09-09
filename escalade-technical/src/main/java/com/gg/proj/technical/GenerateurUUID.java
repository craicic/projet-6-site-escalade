package com.gg.proj.technical;

import java.util.UUID;

public class GenerateurUUID {

    private UUID uuid;

    public UUID getUuid() {
        uuid = UUID.randomUUID();
        return uuid;
    }
}
