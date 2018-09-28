package com.gg.proj.consumer.impl.rowmapper;

import com.gg.proj.model.bean.Voie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VoieRM implements RowMapper<Voie> {

    @Override
    public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Voie voie = new Voie();
        voie.setId(rs.getInt("id"));
        voie.setNom(rs.getString("nom"));
        voie.setDescription(rs.getString("description"));
        voie.setNombreDePoints(rs.getInt("nombre_points"));
        voie.setNombreDeLongueurs(rs.getInt("nombre_longueurs"));
        voie.setCotation(rs.getString("cotation"));
        voie.setHauteur(rs.getString("hauteur"));
        voie.setSecteurId(rs.getInt("secteur_id"));
        return voie;
    }
}
