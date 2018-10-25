package com.gg.proj.consumer.contract;

import com.gg.proj.model.bean.ProprieteTopo;

import java.util.List;

public interface CrudDao<T> {
    void create(T model);
    T get(int id);
    List<T> list();
    void update(T model);
    void delete(Integer id);
}
