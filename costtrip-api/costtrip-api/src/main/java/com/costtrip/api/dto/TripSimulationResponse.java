package com.costtrip.api.dto;

import com.costtrip.api.enums.TravelProfile;

public class TripSimulationResponse {

    private String destination;
    private int days;
    private int travelers;
    private TravelProfile profile;

    private double flightCost;
    private double lodgingCost;
    private double foodCost;
    private double localTransportCost;
    private double extraCost;

    private double estimatedTotal;
    private double costPerTraveler;
    private double costPerDay;

    private String currency;
    private String recommendation;
    private String destinationCurrency;
    private double exchangeRateUsed;


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTravelers() {
        return travelers;
    }

    public void setTravelers(int travelers) {
        this.travelers = travelers;
    }

    public TravelProfile getProfile() {
        return profile;
    }

    public void setProfile(TravelProfile profile) {
        this.profile = profile;
    }

    public double getFlightCost() {
        return flightCost;
    }

    public void setFlightCost(double flightCost) {
        this.flightCost = flightCost;
    }

    public double getLodgingCost() {
        return lodgingCost;
    }

    public void setLodgingCost(double lodgingCost) {
        this.lodgingCost = lodgingCost;
    }

    public double getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }

    public double getLocalTransportCost() {
        return localTransportCost;
    }

    public void setLocalTransportCost(double localTransportCost) {
        this.localTransportCost = localTransportCost;
    }

    public double getExtraCost() {
        return extraCost;
    }

    public void setExtraCost(double extraCost) {
        this.extraCost = extraCost;
    }

    public double getEstimatedTotal() {
        return estimatedTotal;
    }

    public void setEstimatedTotal(double estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }

    public double getCostPerTraveler() {
        return costPerTraveler;
    }

    public void setCostPerTraveler(double costPerTraveler) {
        this.costPerTraveler = costPerTraveler;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public double getExchangeRateUsed() {
        return exchangeRateUsed;
    }

    public void setExchangeRateUsed(double exchangeRateUsed) {
        this.exchangeRateUsed = exchangeRateUsed;
    }
}
