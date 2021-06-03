package com.endeymus.scrap;

import java.util.Map;

/**
 * @author Mark Shamray
 */
public interface Algorithm<T, K extends Map > {
    Algorithm<T, K> execute(T data);
    Algorithm<T, K> sort();
    K get();
}
