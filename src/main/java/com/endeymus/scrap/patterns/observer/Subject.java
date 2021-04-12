package com.endeymus.scrap.patterns.observer;

/**
 * @author Mark Shamray
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
