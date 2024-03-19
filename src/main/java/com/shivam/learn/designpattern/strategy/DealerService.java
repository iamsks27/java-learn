package com.shivam.learn.designpattern.strategy;

/**
 * @author sksingh created on 16/02/24
 */
public class DealerService implements DealerDetails {

    @Override
    @SuppressWarnings("unchecked")
    public DealerDetailDTO dealerDetails(String externalDealerId) {
        return null;
    }

    @Override
    public String onboardingStatus(String externalDealerId) {
        return null;
    }
}
