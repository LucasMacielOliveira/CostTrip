package com.costtrip.api.service;

import com.costtrip.api.dto.ExchangeRateApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;

@Service
public class ExchangeRateService {

    private final RestClient restClient;

    public ExchangeRateService(@Value("${exchange.api.base-url}") String baseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public BigDecimal getExchangeRate(String currency) {
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Moeda inválida.");
        }

        if ("BRL".equalsIgnoreCase(currency)) {
            return BigDecimal.ONE;
        }

        try {
            ExchangeRateApiResponse response = restClient.get()
                    .uri("/rate/{base}/{quote}", currency.toUpperCase(), "BRL")
                    .retrieve()
                    .body(ExchangeRateApiResponse.class);

            if (response == null || response.getRate() == null) {
                throw new IllegalArgumentException("Não foi possível obter a cotação para " + currency);
            }

            return response.getRate();
        } catch (RestClientException ex) {
            throw new IllegalArgumentException("Erro ao consultar API de câmbio: " + ex.getMessage());
        }
    }
}