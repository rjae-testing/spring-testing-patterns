package org.rjae.springresearch.controllers;

import org.rjae.springresearch.models.Session;
import org.rjae.springresearch.repositories.MemoryRepository;
import org.rjae.springresearch.repositories.SessionRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class MockSessionRepository implements SessionRepository {
    private final JpaRepository<Session, Long> itsRepository;

    public MockSessionRepository() {
        this(new MemoryRepository<>());
    }

    public MockSessionRepository(JpaRepository<Session, Long> repository) {
        itsRepository = repository;
    }

    @Override
    public List<Session> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<Session> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    @Override
    public Page<Session> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public List<Session> findAllById(Iterable<Long> iterable) {
        return getRepository().findAllById(iterable);
    }

    @Override
    public long count() {
        return getRepository().count();
    }

    @Override
    public void deleteById(Long aLong) {
        getRepository().deleteById(aLong);
    }

    @Override
    public void delete(Session session) {
        getRepository().delete(session);
    }

    @Override
    public void deleteAll(Iterable<? extends Session> iterable) {
        getRepository().deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }

    @Override
    public <S extends Session> S save(S s) {
        return getRepository().save(s);
    }

    @Override
    public <S extends Session> List<S> saveAll(Iterable<S> iterable) {
        return getRepository().saveAll(iterable);
    }

    @Override
    public Optional<Session> findById(Long aLong) {
        return getRepository().findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return getRepository().existsById(aLong);
    }

    @Override
    public void flush() {
        getRepository().flush();
    }

    @Override
    public <S extends Session> S saveAndFlush(S s) {
        return getRepository().saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Session> iterable) {
        getRepository().deleteInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        getRepository().deleteAllInBatch();
    }

    @Override
    public Session getOne(Long aLong) {
        return getRepository().getOne(aLong);
    }

    @Override
    public <S extends Session> Optional<S> findOne(Example<S> example) {
        return getRepository().findOne(example);
    }

    @Override
    public <S extends Session> List<S> findAll(Example<S> example) {
        return getRepository().findAll(example);
    }

    @Override
    public <S extends Session> List<S> findAll(Example<S> example, Sort sort) {
        return getRepository().findAll(example, sort);
    }

    @Override
    public <S extends Session> Page<S> findAll(Example<S> example, Pageable pageable) {
        return getRepository().findAll(example, pageable);
    }

    @Override
    public <S extends Session> long count(Example<S> example) {
        return getRepository().count(example);
    }

    @Override
    public <S extends Session> boolean exists(Example<S> example) {
        return getRepository().exists(example);
    }

    protected JpaRepository<Session, Long> getRepository() {
        return itsRepository;
    }
}
