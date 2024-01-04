package com.shivam.learn.innerclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author sksingh created on 08/11/23
 */
@Data
public class InboundEvent {

    private InboundEventMessage message;
    private EventType eventType;
    private String externalDealerId;


    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InboundEventMessage {

        private String id;
        private String externalOrderId;
        private String displayNumber;
        private Long emailTriggerTime;
        private Long createdTime;
    }

    public enum EventType {
        CREATE_RESERVATION,
        EMAIL_TRIGGERED,
        CANCEL_RESERVATION
    }
}
