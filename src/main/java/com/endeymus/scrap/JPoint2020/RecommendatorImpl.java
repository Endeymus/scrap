package com.endeymus.scrap.JPoint2020;

/**
 * @author Mark Shamray
 */
@Singleton
public class RecommendatorImpl implements Recommendator {
    @InjectProperty("wisky")
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("to protect from covid-19 drink " + alcohol);
    }
}
