package com.costtrip.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TravelProfile {
    ECONOMICO,
    CONFORTO,
    LUXO;

    @JsonCreator
    public static TravelProfile from(String value) {
        return TravelProfile.valueOf(value.toUpperCase());
    }
}