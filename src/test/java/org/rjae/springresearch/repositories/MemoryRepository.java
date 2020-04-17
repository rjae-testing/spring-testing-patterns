package org.rjae.springresearch.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemoryRepository<Entity, Key> implements JpaRepository<Entity, Key> {
    private final HashMap<Key, Entity> itsStorage = new HashMap<>();

    @Override
    public long count() {
        return itsStorage.size();
    }

    @Override
    public <S extends Entity> long count(Example<S> example) {
        return findAll(example).size();
    }

    @Override
    public void delete(Entity entity) {
        itsStorage.entrySet().removeIf(entry -> Objects.equals(entity, entry.getValue()));
    }

    @Override
    public void deleteAll(Iterable<? extends Entity> iterable) {
        for (Entity e : iterable) {
            delete(e);
        }
    }

    @Override
    public void deleteAll() {
        itsStorage.clear();
    }

    @Override
    public void deleteAllInBatch() {
        deleteAll();
    }

    @Override
    public void deleteById(Key key) {
        itsStorage.remove(key);
    }

    @Override
    public void deleteInBatch(Iterable<Entity> iterable) {
        for (Entity entity : iterable) {
            delete(entity);
        }
    }

    @Override
    public <S extends Entity> boolean exists(Example<S> example) {
        return existsById(getKey(example.getProbe()));
    }

    @Override
    public boolean existsById(Key key) {
        return itsStorage.containsKey(key);
    }

    @Override
    public List<Entity> findAll() {
        return new ArrayList<>(itsStorage.values());
    }

    @Override
    public List<Entity> findAll(Sort sort) {
        return findAll();
    }

    @Override
    public Page<Entity> findAll(Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Entity> List<S> findAll(Example<S> example) {
        Stream<Entity> stream = itsStorage.values().stream().filter(x -> Objects.equals(x, example.getProbe()));
        return stream.map(e -> (S) e).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public <S extends Entity> List<S> findAll(Example<S> example, Sort sort) {
        return findAll(example);
    }

    @Override
    public <S extends Entity> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Entity> findAllById(Iterable<Key> iterable) {
        ArrayList<Entity> result = new ArrayList<>();
        for (Key k : iterable) {
            if (itsStorage.containsKey(k)) {
                result.add(itsStorage.get(k));
            }
        }
        return result;
    }

    @Override
    public Optional<Entity> findById(Key key) {
        return itsStorage.containsKey(key) ? Optional.of(itsStorage.get(key)) : Optional.empty();
    }

    @Override
    public <S extends Entity> Optional<S> findOne(Example<S> example) {
        return (Optional<S>) findById(getKey(example.getProbe()));
    }

    @Override
    public void flush() {
    }

    @Override
    public Entity getOne(Key key) {
        return itsStorage.get(key);
    }

    @Override
    public <S extends Entity> S save(S s) {
        itsStorage.put(getKey(s), s);
        return s;
    }

    @Override
    public <S extends Entity> List<S> saveAll(Iterable<S> iterable) {
        ArrayList<S> saved = new ArrayList<>();
        for (S item : iterable) {
            saved.add(save(item));
        }
        return saved;
    }

    @Override
    public <S extends Entity> S saveAndFlush(S s) {
        return save(s);
    }

    protected Field getIdField(Entity entity) {
        Field field = Arrays.stream(entity.getClass().getDeclaredFields()).filter(x -> x.isAnnotationPresent(Id.class)).findFirst().orElseThrow();
        field.setAccessible(true);
        return field;
    }

    protected Key getKey(Entity entity) {
        try {
            return (Key) getIdField(entity).get(entity);
        } catch (IllegalAccessException ignored) {
            return null;
        }
    }
}
