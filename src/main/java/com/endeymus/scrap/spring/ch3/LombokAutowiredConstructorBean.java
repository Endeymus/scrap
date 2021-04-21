package com.endeymus.scrap.spring.ch3;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Mark Shamray
 */
@Component("lombokBean")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LombokAutowiredConstructorBean implements DemoBean {
    private final Singer singer;

    @Override
    public Singer getMySinger() {
        return singer;
    }

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
