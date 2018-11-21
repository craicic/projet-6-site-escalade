package com.gg.proj.technical;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ConvertisseurDate {

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
