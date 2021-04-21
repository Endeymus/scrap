package com.endeymus.scrap.spring.ch3;

import lombok.Setter;

/**
 * @author Mark Shamray
 */
public class StandardLookupDemoBean implements DemoBean {
    @Setter
    private Singer singer;
    @Override
    public Singer getMySinger() {
        return singer;
    }

    @Override
    public void doSomething() {
        singer.sing();
    }
}
