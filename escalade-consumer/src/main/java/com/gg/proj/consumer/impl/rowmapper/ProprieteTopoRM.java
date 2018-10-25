package com.gg.proj.consumer.impl.rowmapper;

import com.gg.proj.model.bean.ProprieteTopo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProprieteTopoRM implements RowMapper<ProprieteTopo> {

    @Override
    public ProprieteTopo mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProprieteTopo proprieteTopo = new ProprieteTopo();
        proprieteTopo.setStatus(rs.getString("status"));
        proprieteTopo.setTopoId(rs.getInt("topo_id"));
        proprieteTopo.setUtilisateurId(rs.getInt("utilisateur_id"));
        return proprieteTopo;
    }
}
