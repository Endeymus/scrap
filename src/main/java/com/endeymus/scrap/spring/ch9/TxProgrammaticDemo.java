package com.endeymus.scrap.spring.ch9;

import com.endeymus.scrap.spring.ch9.config.DataJpaConfig;
import com.endeymus.scrap.spring.ch9.config.ServicesConfig;
import com.endeymus.scrap.spring.ch9.entities.Singer;
import com.endeymus.scrap.spring.ch9.services.SingerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author Mark Shamray
 */
public class TxProgrammaticDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ServicesConfig.class, DataJpaConfig.class);

        SingerService singerService = ctx.getBean(SingerService.class);

        List<Singer> singerList = singerService.findAll();
        singerList.forEach(System.out::println);

        Singer singer = singerService.findById(1L);
        singer.setFirstName("John Clayton");
        singer.setLastName("Mayer");
        singerService.save(singer);
        System.out.println("Singer saved successfully: " + singer);

        System.out.println("Singer count: " + singerService.countAll());
    }
}
