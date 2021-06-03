package com.endeymus.scrap.streamapi.util;

import java.util.List;

/**
 * @author Mark Shamray
 */
public interface Generator<T> {
    List<T> generate(int count);
}
