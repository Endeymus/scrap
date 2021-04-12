package com.endeymus.scrap.patterns.observer;

/**
 * @author Mark Shamray
 */
public class StatisticDisplay implements Observer, DisplayElement{
    private float max = Float.MIN_VALUE;
    private float min = Float.MAX_VALUE;
    private float avg = 0;
    private int count = 0;
    private Subject weatherData;

    public StatisticDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("max/avg/min temperature = " + max + "/" + avg + "/" + min);

    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        if (temp > max)
            max = temp;
        if (min > temp)
            min = temp;
        avg = ((avg * count) + temp) / ++count;
        display();
    }
}
