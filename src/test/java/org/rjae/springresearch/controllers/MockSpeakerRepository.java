package org.rjae.springresearch.controllers;

import org.rjae.springresearch.models.Speaker;
import org.rjae.springresearch.repositories.MemoryRepository;
import org.rjae.springresearch.repositories.SpeakerRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class MockSpeakerRepository implements SpeakerRepository {
    private final JpaRepository<Speaker, Long> itsRepository;

    public MockSpeakerRepository() {
        this(new MemoryRepository<>());
    }

    public MockSpeakerRepository(JpaRepository<Speaker, Long> repository) {
        itsRepository = repository;
    }

    @Override
    public List<Speaker> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<Speaker> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    @Override
    public Page<Speaker> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public List<Speaker> findAllById(Iterable<Long> iterable) {
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
    public void delete(Speaker session) {
        getRepository().delete(session);
    }

    @Override
    public void deleteAll(Iterable<? extends Speaker> iterable) {
        getRepository().deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }

    @Override
    public <S extends Speaker> S save(S s) {
        return getRepository().save(s);
    }

    @Override
    public <S extends Speaker> List<S> saveAll(Iterable<S> iterable) {
        return getRepository().saveAll(iterable);
    }

    @Override
    public Optional<Speaker> findById(Long aLong) {
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
    public <S extends Speaker> S saveAndFlush(S s) {
        return getRepository().saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Speaker> iterable) {
        getRepository().deleteInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        getRepository().deleteAllInBatch();
    }

    @Override
    public Speaker getOne(Long aLong) {
        return getRepository().getOne(aLong);
    }

    @Override
    public <S extends Speaker> Optional<S> findOne(Example<S> example) {
        return getRepository().findOne(example);
    }

    @Override
    public <S extends Speaker> List<S> findAll(Example<S> example) {
        return getRepository().findAll(example);
    }

    @Override
    public <S extends Speaker> List<S> findAll(Example<S> example, Sort sort) {
        return getRepository().findAll(example, sort);
    }

    @Override
    public <S extends Speaker> Page<S> findAll(Example<S> example, Pageable pageable) {
        return getRepository().findAll(example, pageable);
    }

    @Override
    public <S extends Speaker> long count(Example<S> example) {
        return getRepository().count(example);
    }

    @Override
    public <S extends Speaker> boolean exists(Example<S> example) {
        return getRepository().exists(example);
    }

    protected JpaRepository<Speaker, Long> getRepository() {
        return itsRepository;
    }
}
