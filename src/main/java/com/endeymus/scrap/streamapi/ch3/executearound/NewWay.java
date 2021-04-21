package com.endeymus.scrap.streamapi.ch3.executearound;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Mark Shamray
 */
public class NewWay {
    public String processFile(BufferedReaderProcessor b) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/endeymus/scrap/streamapi/ch3/executearound/data.txt"))) {
            return b.process(br);
        }
    }

}
