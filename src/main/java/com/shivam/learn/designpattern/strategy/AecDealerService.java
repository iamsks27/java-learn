package com.shivam.learn.designpattern.strategy;

/**
 * @author sksingh created on 16/02/24
 */
public class AecDealerService implements DealerDetails {

    @Override
    @SuppressWarnings("unchecked")
    public AecDealerDetailsDTO dealerDetails(String externalDealerId) {
        return null;
    }

    @Override
    public String onboardingStatus(String externalDealerId) {
        return null;
    }
}
