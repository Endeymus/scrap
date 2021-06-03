package com.endeymus.scrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GroupedCounterAlgorithmTest {
    private static final long[] data = {1, 2, 4, 4, 1, 4, 0, 4, 4};
    private GroupedCounterAlgorithm algorithm;

    @BeforeEach
    void setUp() {
        algorithm = new GroupedCounterAlgorithm();
    }

    @Test
    @DisplayName(value = "")
    void execute() {
        Map<Long, Long> groupedValues = algorithm.execute(data).get();
        System.out.println(groupedValues);
        assertEquals(groupedValues.get(0L), 1);
        assertEquals(groupedValues.get(1L), 2);
        assertEquals(groupedValues.get(2L), 1);
        assertEquals(groupedValues.get(4L), 5);
    }

    @Test
    @DisplayName(value = "")
    void sort() {
        Map<Long, Long> groupedValues = algorithm.execute(data).sort().get();
        Set<Long> expected = new LinkedHashSet<>();
        expected.add(4L);
        expected.add(2L);
        expected.add(1L);
        expected.add(0L);
        assertIterableEquals(groupedValues.keySet(), expected);
    }

}