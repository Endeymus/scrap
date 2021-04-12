package com.endeymus.scrap.patterns.observer;

/**
 * @author Mark Shamray
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);
}
