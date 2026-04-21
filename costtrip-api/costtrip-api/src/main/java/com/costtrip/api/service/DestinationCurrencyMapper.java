package com.costtrip.api.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DestinationCurrencyMapper {

    private static final Map<String, String> DESTINATION_CURRENCY_MAP = new HashMap<>();

    static {
        DESTINATION_CURRENCY_MAP.put("japão", "JPY");
        DESTINATION_CURRENCY_MAP.put("japao", "JPY");
        DESTINATION_CURRENCY_MAP.put("estados unidos", "USD");
        DESTINATION_CURRENCY_MAP.put("eua", "USD");
        DESTINATION_CURRENCY_MAP.put("canadá", "CAD");
        DESTINATION_CURRENCY_MAP.put("canada", "CAD");
        DESTINATION_CURRENCY_MAP.put("frança", "EUR");
        DESTINATION_CURRENCY_MAP.put("franca", "EUR");
        DESTINATION_CURRENCY_MAP.put("alemanha", "EUR");
        DESTINATION_CURRENCY_MAP.put("italia", "EUR");
        DESTINATION_CURRENCY_MAP.put("itália", "EUR");
        DESTINATION_CURRENCY_MAP.put("espanha", "EUR");
        DESTINATION_CURRENCY_MAP.put("portugal", "EUR");
        DESTINATION_CURRENCY_MAP.put("argentina", "ARS");
        DESTINATION_CURRENCY_MAP.put("chile", "CLP");
        DESTINATION_CURRENCY_MAP.put("reino unido", "GBP");
    }

    public String getCurrencyByDestination(String destination) {
        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("Destino inválido para mapeamento de moeda.");
        }

        String normalizedDestination = destination.trim().toLowerCase();
        String currency = DESTINATION_CURRENCY_MAP.get(normalizedDestination);

        if (currency == null) {
            throw new IllegalArgumentException("Moeda não mapeada para o destino informado: " + destination);
        }

        return currency;
    }
}