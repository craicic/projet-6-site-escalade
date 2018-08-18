package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.TopoDao;
import com.gg.proj.model.bean.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

    @Override
    public void create(Object model) {

    }

    @Override
    public Object get(int id) {
        return null;
    }

    @Override
    public List list() {
        String vSQL = "SELECT * FROM topo";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Topo> vRowMapper = new RowMapper<Topo>() {
            public Topo mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Topo vTopo = new Topo(pRS.getInt("id"));
                return vTopo;
            }
        };

        List<Topo> vListStatut = jdbcTemplate.query(vSQL, vRowMapper);

        return vListStatut;
    }

    @Override
    public void update(Object model) {

    }

    @Override
    public void delete(Object model) {

    }
}
