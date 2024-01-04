package com.shivam.learn.tradein;

import lombok.Data;

import java.util.List;

@Data
public class TradeIn {

    private Provider provider;
    private TradeInVehicle tradeInVehicle;
    private List<String> options; // OptionId
    private String colorOption; // KBB
    private List<Condition> conditions; // BB
    private Contact contact; // BB
    private String pageUrl; // BB
    private String zipCode; // User zipCode used for KBB
    private PaymentDetails paymentDetails;
    private String bbToken; // BB token
    private TradeInType tradeInType; // YMM/VIN/PLATE
    private PurchaseVehicle purchaseVehicle;
}
