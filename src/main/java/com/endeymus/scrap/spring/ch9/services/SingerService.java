package com.endeymus.scrap.spring.ch9.services;

import com.endeymus.scrap.spring.ch9.entities.Singer;

import java.util.List;

/**
 * @author Mark Shamray
 */
public interface SingerService {

    List<Singer> findAll();

    Singer findById(Long id);

    Singer save(Singer singer);

    long countAll();
}
