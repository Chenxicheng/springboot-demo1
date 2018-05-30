package com.demo.commen.base;

import java.util.Collection;
import java.util.List;

public interface BaseService <T extends DataEntity<T>> {

    T get(String id);

    T get(T t);

    List<T> findList(T t);

    void save(T t);

    void delete(T t);

    void delete(String id);

    void deleteAll(Collection<T> collection);

}
