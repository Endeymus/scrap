package com.endeymus.scrap.streamapi.ch3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.Comparator;

/**
 * @author Mark Shamray
 */
@AllArgsConstructor
@Getter
@ToString
public class ThreeParamConstr {
    private Integer cost;
    private Integer count;
    private Integer size;

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, ThreeParamConstr> func = ThreeParamConstr::new;
        System.out.println(func.apply(1, 2, 3));
    }
}
