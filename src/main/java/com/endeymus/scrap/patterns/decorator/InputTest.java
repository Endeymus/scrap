package com.endeymus.scrap.patterns.decorator;

import java.io.*;

/**
 * @author Mark Shamray
 */
public class InputTest {
    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("src/main/java/com/endeymus/scrap/patterns/decorator/test.txt")));
            while ((c = in.read()) >= 0) {
                System.out.print((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
