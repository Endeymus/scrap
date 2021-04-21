package com.endeymus.scrap.streamapi.ch3.executearound;

import java.io.IOException;
import java.util.function.Predicate;

/**
 * @author Mark Shamray
 */
public class ExecuteAroundTest {
    public static void main(String[] args) throws IOException {
        System.out.println("Old:");
        OldWay oldWay = new OldWay();
        System.out.println(oldWay.processFile());

        System.out.println("New:");
        NewWay newWay = new NewWay();
        System.out.println(newWay.processFile(b -> b.readLine() + "\n" + b.readLine()));
    }
}
