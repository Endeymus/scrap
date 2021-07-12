package com.endeymus.scrap.spring.ch9.boot.services;

import com.endeymus.scrap.spring.ch9.entities.Singer;
import com.endeymus.scrap.spring.ch9.repository.SingerRepository;
import com.endeymus.scrap.spring.ch9.services.SingerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * @author Mark Shamray
 */
@Service("singerService")
@Transactional
@Qualifier
public class SingerServiceImpl implements SingerService {
    private SingerRepository singerRepository;
    private JmsTemplate jmsTemplate;

    public SingerServiceImpl(SingerRepository singerRepository, JmsTemplate jmsTemplate) {
        this.singerRepository = singerRepository;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return null;
    }

    @Override
    public Singer save(Singer singer) {
        jmsTemplate.convertAndSend("singers", "Just saved:" + singer);
        if (singer == null) {
            throw new JpaSystemException(new PersistenceException("Simulation of something wrong"));
        }
        singerRepository.save(singer);
        return singer;
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public long countAll() {
        return singerRepository.count();
    }
}
