package com.gg.proj.consumer.impl.rowmapper;

import com.gg.proj.model.bean.Secteur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SecteurRM implements RowMapper<Secteur> {

    @Override
    public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Secteur secteur = new Secteur();
        secteur.setId(rs.getInt("id"));
        secteur.setNom(rs.getString("nom"));
        secteur.setDescription(rs.getString("description"));
        secteur.setCoordonneeX(rs.getDouble("coordonnee_x"));
        secteur.setCoordonneeY(rs.getDouble("coordonnee_y"));
        secteur.setSiteId(rs.getInt("site_id"));
        return secteur;
    }
}
