package com.gg.proj.consumer.impl.rowmapper;

import com.gg.proj.model.bean.Emprunt;
import com.gg.proj.model.bean.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmpruntFullRM implements RowMapper<Emprunt> {

    @Override
    public Emprunt mapRow(ResultSet rs, int rowNum) throws SQLException {
        Emprunt emprunt = new Emprunt();
        emprunt.setId(rs.getInt("id"));
        emprunt.setDateEmprunt(rs.getObject("date_empreint", LocalDate.class));
        emprunt.setDateRetour(rs.getObject("date_retour", LocalDate.class));
        emprunt.setUtilisateurId(rs.getInt("utilisateur_id"));
        emprunt.setTopoId(rs.getInt("topo_id"));
        emprunt.setEmprunteur(new Utilisateur(rs.getInt("utilisateur_id"), rs.getString("emprunteur_pseudo")));
        emprunt.setProprietaire(new Utilisateur(rs.getInt("proprietaire_id"), rs.getString("proprietaire_pseudo")));
        return emprunt;
    }
}
