package com.endeymus.scrap.spring.ch12.repository;

import com.endeymus.scrap.spring.ch12.entities.Singer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Mark Shamray
 */
public interface SingerRepository extends CrudRepository<Singer, Long> {

    @Query("select count(s) from Singer s")
    Long countAllSingers();
}
