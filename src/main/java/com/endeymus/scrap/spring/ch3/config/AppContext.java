package com.endeymus.scrap.spring.ch3.config;

import com.endeymus.scrap.spring.ch3.Singer;
import com.endeymus.scrap.spring.ch3.StandardLookupDemoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Mark Shamray
 */
@Configuration
@ComponentScan("com.endeymus.scrap.spring.ch3")
public class AppContext {

    @Bean
    @Scope("prototype")
    public Singer singer() {
        return new Singer();
    }


    @Bean
    public StandardLookupDemoBean standardLookupBean() {
        StandardLookupDemoBean bean = new StandardLookupDemoBean();
        bean.setSinger(singer());
        return bean;
    }
}
