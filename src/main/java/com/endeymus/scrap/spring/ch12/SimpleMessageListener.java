package com.endeymus.scrap.spring.ch12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author Mark Shamray
 */
@Component
public class SimpleMessageListener {
    private static Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);

    @JmsListener(destination = "prospring5", containerFactory = "containerFactory")
    public void onMessage(Message message){
        TextMessage textMessage = (TextMessage) message;
        try {
            logger.info(">>> Received: " + textMessage.getText());
        } catch (JMSException e) {
            logger.error("JMS error", e);
        }
    }
}
