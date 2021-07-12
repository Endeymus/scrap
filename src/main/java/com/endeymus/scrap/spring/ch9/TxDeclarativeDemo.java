package com.endeymus.scrap.spring.ch9;

import com.endeymus.scrap.spring.ch9.entities.Singer;
import com.endeymus.scrap.spring.ch9.services.SingerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * @author Mark Shamray
 */
public class TxDeclarativeDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:tx-declarative-app-context.xml");
        ctx.refresh();

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
