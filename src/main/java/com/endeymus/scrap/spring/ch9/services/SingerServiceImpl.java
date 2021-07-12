package com.endeymus.scrap.spring.ch9.services;

import com.endeymus.scrap.spring.ch9.entities.Singer;
import com.endeymus.scrap.spring.ch9.repository.SingerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Mark Shamray
 */
//@Service("singerService")
//@Transactional
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerRepository singerRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @PersistenceContext
    private EntityManager em;

    @Override
//    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    @Override
//    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return singerRepository.findById(id).get();
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

//    @Override
//    @Transactional(propagation = Propagation.NEVER)
//    public long countAll() {
//        return singerRepository.countAllSingers();
//    }


    @Override
    public long countAll() {
        return transactionTemplate.execute(
                transactionStatus -> em.createNamedQuery(Singer.COUNT_ALL, Long.class).getSingleResult()
        );
    }
}
