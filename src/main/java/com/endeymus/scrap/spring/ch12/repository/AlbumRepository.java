package com.endeymus.scrap.spring.ch12.repository;

import com.endeymus.scrap.spring.ch12.entities.Album;
import com.endeymus.scrap.spring.ch12.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Mark Shamray
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findBySinger(Singer singer);
}
