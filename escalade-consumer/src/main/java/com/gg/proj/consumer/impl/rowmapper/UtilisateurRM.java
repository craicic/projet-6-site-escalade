package com.gg.proj.consumer.impl.rowmapper;

import com.gg.proj.model.bean.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurRM implements RowMapper<Utilisateur> {

    @Override
    public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(rs.getInt("id"));
        utilisateur.setNom(rs.getString("nom"));
        utilisateur.setPrenom(rs.getString("prenom"));
        utilisateur.setPseudo(rs.getString("pseudo"));
        utilisateur.setAdresse(rs.getString("adresse"));
        utilisateur.setDescription(rs.getString("Description"));
        utilisateur.setAdresseMail(rs.getString("adresse_mail"));
        utilisateur.setDateInscription(rs.getDate("date_inscription"));
        utilisateur.setUuid(rs.getString("uuid"));
        return utilisateur;
    }
}
