package com.endeymus.scrap.spring.ch9.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Mark Shamray
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findBySinger(Singer singer);
}
