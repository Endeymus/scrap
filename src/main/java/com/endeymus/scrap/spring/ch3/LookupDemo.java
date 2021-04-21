package com.endeymus.scrap.spring.ch3;

import com.endeymus.scrap.spring.ch3.config.AppContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

/**
 * @author Mark Shamray
 */
public class LookupDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

        DemoBean abstractBean = context.getBean("abstractLookupBean", DemoBean.class);
        DemoBean standardBean = context.getBean("standardLookupBean", DemoBean.class);
        DemoBean lombokBean = context.getBean("lombokBean", DemoBean.class);

        displayInfo("abstractLookupBean", abstractBean);
        displayInfo("standardLookupBean", standardBean);
        displayInfo("lombokBean", lombokBean);


    }

    public static void displayInfo(String name, DemoBean bean) {
        Singer singer1 = bean.getMySinger();
        Singer singer2 = bean.getMySinger();

        System.out.println("" + name + ": "
                + "Singer Instances the Same? "
                + (singer1 == singer2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int i = 0; i < 100000; i++) {
            Singer singer = bean.getMySinger();
            singer.sing();
        }
        stopWatch.stop();
        System.out.println("100000 gets took "
                + stopWatch.getTotalTimeMillis() + "ms");
    }
}
