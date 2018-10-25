package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.ProprieteTopoDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ProprieteTopoDaoImpl extends AbstractDaoImpl implements ProprieteTopoDao {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(ProprieteTopoDao model) {

    }

    @Override
    public ProprieteTopoDao get(int id) {
        return null;
    }

    @Override
    public List<ProprieteTopoDao> list() {
        return null;
    }

    @Override
    public void update(ProprieteTopoDao model) {

    }

    @Override
    public void delete(Integer id) {

    }
}
