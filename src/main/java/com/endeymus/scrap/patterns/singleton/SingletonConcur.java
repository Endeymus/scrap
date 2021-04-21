package com.endeymus.scrap.patterns.singleton;

/**
 * Синхронизация актуальна только при первом вызове этого метода.
 * Иначе говоря, после того, как переменной {@code uniqueInstance}
 * будет присвоен экземпляр синглетного класса, необходимость в дальнейшей синхронизации этого метода отпадает.
 * После первого выполнения синхронизация только приводит к лишним затратам ресурсов!
 * Если вызов {@code getInstance()} не приводит к заметному ухудшению быстродействия,
 * не обращайте внимания. Синхронизация {@code getInstance()} — простое и эффективное решение.
 * @author Mark Shamray
 */
public class SingletonConcur {
    private static SingletonConcur uniqueInstance;

    private SingletonConcur() {}

    public static synchronized SingletonConcur getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonConcur();
        }
        return uniqueInstance;
    }
}
