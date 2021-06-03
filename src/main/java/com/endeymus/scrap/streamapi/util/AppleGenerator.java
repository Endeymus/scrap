package com.endeymus.scrap.streamapi.util;

import com.endeymus.scrap.streamapi.ch2.Apple;
import com.endeymus.scrap.streamapi.ch2.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Mark Shamray
 */
public class AppleGenerator implements Generator<Apple> {
    private Random rand = new Random();
    private final BiFunction<Color, Float, Apple> appleFunction = Apple::new;
    @Override
    public List<Apple> generate(int count) {
        List<Apple> result = new ArrayList<>(count);
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            float fl = rand.nextFloat() % .300f;
            result.add(appleFunction.apply(flag ? Color.RED : Color.GREEN, fl));
            flag = !flag;
        }
        return result;
    }
}
