package com.endeymus.scrap.spring.ch12.services;

import com.endeymus.scrap.spring.ch12.repository.SingerRepository;
import com.endeymus.scrap.spring.ch12.entities.Singer;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Mark Shamray
 */
@Service("singerService")
@Transactional
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerRepository singerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return singerRepository.findById(id).get();
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public void delete(Singer singer) {
        singerRepository.delete(singer);
    }
}
