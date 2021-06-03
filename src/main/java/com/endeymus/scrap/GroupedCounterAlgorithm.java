package com.endeymus.scrap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Mark Shamray
 */
public class GroupedCounterAlgorithm implements Algorithm<long[], Map<Long, Long>> {
    private Map<Long, Long> map = new HashMap<>();

    @Override
    public Algorithm<long[], Map<Long, Long>> execute(long[] data) {
/*         for (long l : data) {
            if (map.containsKey(l)) {
                map.put(l, map.get(l) + 1);
            } else {
                map.put(l, 1L);
            }
        }*/
        map = Arrays.stream(data).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return this;
    }

    @Override
    public Algorithm<long[], Map<Long, Long>> sort() {
        TreeMap<Long, Long> treeMap = new TreeMap<>(Comparator.reverseOrder());
        treeMap.putAll(map);
        map = treeMap;
        return this;
    }

    @Override
    public Map<Long, Long> get() {
        return map;
    }
}
