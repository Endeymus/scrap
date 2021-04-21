package com.endeymus.scrap.spring.ch3;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @author Mark Shamray
 */
@Component("abstractLookupBean")
public class AbstractLookupDemoBean implements DemoBean {
    @Override
    @Lookup("singer")
    public Singer getMySinger() {
        return null;
    };
    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
