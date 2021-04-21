package com.endeymus.scrap.streamapi.ch3.executearound;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Mark Shamray
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
