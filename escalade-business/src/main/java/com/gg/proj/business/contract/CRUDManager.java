package com.gg.proj.business.contract;

import com.gg.proj.model.bean.Model;

import java.util.List;

/**
 * CRUDManager impose les methodes communes a tout les manager du projets (CRUD)
 * @param <T> Avec T un objet en base de donnée
 */
public interface CRUDManager<T extends Model> {
    void create(T model);
    T get(int id);
    List<T> list();
    void update(T model);
    void delete(T model);
}
