package com.gg.proj.consumer.impl.rowmapper;

import com.gg.proj.model.bean.CompositionSiteTopo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompositionSiteTopoRM implements RowMapper<CompositionSiteTopo> {

    @Override
    public CompositionSiteTopo mapRow(ResultSet rs, int rowNum) throws SQLException {
        CompositionSiteTopo compositionSiteTopo = new CompositionSiteTopo();
        compositionSiteTopo.setSiteId(rs.getInt("site_id"));
        compositionSiteTopo.setTopoId(rs.getInt("topo_id"));
        return compositionSiteTopo;
    }
}
