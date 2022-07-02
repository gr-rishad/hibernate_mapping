package com.hibernate_mapping.util;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

    T saveOrUpdate(T t);
    Optional<T> findById(Long id);
    void delete(Long id);
    List<T> findAll();
}
