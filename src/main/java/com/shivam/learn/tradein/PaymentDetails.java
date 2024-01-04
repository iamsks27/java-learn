package com.shivam.learn.tradein;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDetails {

    private boolean isPaymentDueOnTradeInVehicle;
    private BigDecimal tradePayOff;
    private BigDecimal tradeInValuationAmount;
}
