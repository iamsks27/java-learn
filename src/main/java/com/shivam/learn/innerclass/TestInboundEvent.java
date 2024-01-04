package com.shivam.learn.innerclass;

/**
 * @author sksingh created on 08/11/23
 */
public class TestInboundEvent {

    public static void main(String[] args) {
        final InboundEvent inboundEvent = new InboundEvent();

        InboundEvent.InboundEventMessage message = inboundEvent.getMessage();

        InboundEvent.EventType eventType = inboundEvent.getEventType();
    }

}
