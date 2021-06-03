package com.endeymus.scrap.patterns.singleton;

/**
 * Сначала проверяется, создается ли новый экземпляр, и если нет — ТОГДА синхронизируется фрагмент кода.
 * В этом случае синхронизация будет выполняться только при первом вызове (что нам, собственно, и тре-
 * бовалось).
 * @author Mark Shamray
 */
public class SingletonConcurVolatile {
    private volatile static SingletonConcurVolatile uniqueInstance;

    private SingletonConcurVolatile() {}

    public static SingletonConcurVolatile getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonConcurVolatile.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonConcurVolatile();
                }
            }
        }
        return uniqueInstance;
    }

}
