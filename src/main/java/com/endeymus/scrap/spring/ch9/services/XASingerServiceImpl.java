package com.endeymus.scrap.spring.ch9.services;

import com.endeymus.scrap.spring.ch9.entities.Singer;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 * @author Mark Shamray
 */
@Service("XAsingerService")
@Transactional
public class XASingerServiceImpl implements SingerService {

    @PersistenceContext(unitName = "emfA")
    private EntityManager emA;
    @PersistenceContext(unitName = "emfB")
    private EntityManager emB;

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        throw new NotYetImplementedException("findAll");
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        throw new NotYetImplementedException("findById");
    }

    @Override
    public Singer save(Singer singer) {
        Singer singerB = new Singer();
        singerB.setFirstName(singer.getFirstName());
        singerB.setLastName(singer.getLastName());
        if (singer.getId() == null) {
            emA.persist(singer);
            if (true) throw new JpaSystemException(new PersistenceException());
            emB.persist(singerB);
        } else {
            emA.merge(singer);
            emB.merge(singer);
        }
        return singer;
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public long countAll() {
        return 0;
    }
}
