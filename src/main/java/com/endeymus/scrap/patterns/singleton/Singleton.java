package com.endeymus.scrap.patterns.singleton;

/**
 * Экземпляр {@code Singleton} создается в статиче ком инициализаторе.
 * Потоковая безопасность этого кода гарантирована!
 * При таком подходе мы доверяем JVM создание уникального экземпляра {@code Singleton} при за-
 * грузке класса. JVM гарантирует, что экземпляр будет создан до того, как какой-либо поток
 * сможет обратиться к статической переменной {@code ourInstance}.
 *
 * @author Mark Shamray
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}