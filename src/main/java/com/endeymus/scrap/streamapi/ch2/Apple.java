package com.endeymus.scrap.streamapi.ch2;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mark Shamray
 */
@Setter
@Getter
public class Apple {
    private Color color;
    private float weight;

    public Apple(Color color, float weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Color: " + color + ", weight: " + weight;
    }
}
