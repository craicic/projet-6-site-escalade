package com.gg.proj.consumer.contract;

import java.util.List;

public interface CrudDao<T > {
    void create(T model);
    T get(int id);
    List<T> list();
    void update(T model);
    void delete(T model);
}
