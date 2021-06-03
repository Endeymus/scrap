package com.endeymus.scrap.streamapi.ch3;

/**
 * @author Mark Shamray
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
