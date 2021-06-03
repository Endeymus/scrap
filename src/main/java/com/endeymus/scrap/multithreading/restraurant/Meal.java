package com.endeymus.scrap.multithreading.restraurant;

/**
 * @author Mark Shamray
 */
public class Meal {
    private final int idOrder;

    public Meal(int idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public String toString() {
        return "Meal " + idOrder;
    }
}
