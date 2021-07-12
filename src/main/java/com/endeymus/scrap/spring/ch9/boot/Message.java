package com.endeymus.scrap.spring.ch9.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

/**
 * @author Mark Shamray
 */
public class Message {
    private static Logger logger = LoggerFactory.getLogger(Message.class);

    @JmsListener(destination = "singers")
    public void onMessage(String content){
        logger.info("--> Received content: " + content);
    }
}
