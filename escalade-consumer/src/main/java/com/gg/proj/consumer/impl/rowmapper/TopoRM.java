package com.gg.proj.consumer.impl.rowmapper;

import com.gg.proj.model.bean.Topo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopoRM implements RowMapper<Topo> {


    @Override
    public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Topo topo = new Topo();
        topo.setId(rs.getInt("id"));
        topo.setTitre(rs.getString("titre"));
        topo.setAuteur(rs.getString("auteur"));
        topo.setDescription(rs.getString("description"));
        topo.setEmpreintable(rs.getBoolean("empreintable"));
        topo.setProprietaireId(rs.getInt("proprietaire_id"));
        return topo;
    }
}
