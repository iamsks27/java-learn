package com.shivam.learn;


/**
 * @author sksingh created on 15/03/24
 */
public class TypeCastTest {

    interface DealerInfo {
        String getExternalId();
    }

    interface Pricing {
        String getPaymentType();
    }

    interface Entity {
        Pricing getPricing();
        String getEntityType();
        DealerInfo getDealerInfo();
    }

    interface LeadRequest {

    }

}
