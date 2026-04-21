package com.costtrip.api.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeRateService {

    private static final Map<String, BigDecimal> EXCHANGE_RATE_MAP = new HashMap<>();

    static {
        EXCHANGE_RATE_MAP.put("USD", new BigDecimal("5.20"));
        EXCHANGE_RATE_MAP.put("EUR", new BigDecimal("5.65"));
        EXCHANGE_RATE_MAP.put("JPY", new BigDecimal("0.035"));
        EXCHANGE_RATE_MAP.put("ARS", new BigDecimal("0.005"));
        EXCHANGE_RATE_MAP.put("CLP", new BigDecimal("0.0057"));
        EXCHANGE_RATE_MAP.put("CAD", new BigDecimal("3.85"));
        EXCHANGE_RATE_MAP.put("GBP", new BigDecimal("6.60"));
        EXCHANGE_RATE_MAP.put("BRL", BigDecimal.ONE);
    }

    public BigDecimal getExchangeRate(String currency) {
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Moeda inválida.");
        }

        BigDecimal rate = EXCHANGE_RATE_MAP.get(currency.toUpperCase());

        if (rate == null) {
            throw new IllegalArgumentException("Cotação não encontrada para a moeda: " + currency);
        }

        return rate;
    }
}