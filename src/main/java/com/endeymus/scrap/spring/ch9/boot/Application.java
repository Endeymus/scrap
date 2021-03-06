package com.endeymus.scrap.spring.ch9.boot;

import com.endeymus.scrap.spring.ch9.entities.Singer;
import com.endeymus.scrap.spring.ch9.services.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Mark Shamray
 */
@SpringBootApplication(scanBasePackages = "com.endeymus.scrap.spring.ch9.services")
public class Application implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String... args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.in.read();
        ctx.close();
    }

    @Autowired
    SingerService singerService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("dfgdfg");
        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1977, 9, 16)).getTime().getTime()));
        singerService.save(singer);

        long count = singerService.countAll();
        if (count == 1) {
            logger.info("--> Singer saved successfully");
        }  else {
            logger.error("--> Singer was not saved, check the configuration!!");
        }

        try {
            singerService.save(null);
        } catch (Exception ex) {
            logger.error(ex.getMessage() + "Final count:" + singerService.countAll());
        }
    }
}
