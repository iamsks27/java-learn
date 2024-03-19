package com.shivam.learn.designpattern.strategy;

/**
 * @author sksingh created on 16/02/24
 */
public interface DealerDetails {

    <T> T dealerDetails(String externalDealerId);

    String onboardingStatus(String externalId);
}
