package com.gg.proj.consumer.impl.rowmapper;

import com.gg.proj.model.bean.Emprunt;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmpruntRM implements RowMapper<Emprunt> {

    @Override
    public Emprunt mapRow(ResultSet rs, int rowNum) throws SQLException {
        Emprunt emprunt = new Emprunt();
        emprunt.setId(rs.getInt("id"));
        emprunt.setDateEmprunt(rs.getObject("date_emprunt", LocalDate.class));
        emprunt.setDateRetour(rs.getObject("date_retour", LocalDate.class));
        emprunt.setUtilisateurId(rs.getInt("utilisateur_id"));
        emprunt.setTopoId(rs.getInt("topo_id"));
        return emprunt;
    }
}
