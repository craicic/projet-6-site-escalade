package com.gg.proj.consumer.impl.rowmapper;

import com.gg.proj.model.bean.Commentaire;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentaireRM implements RowMapper<Commentaire> {

    @Override
    public Commentaire mapRow(ResultSet rs, int rowNum) throws SQLException {
        Commentaire commentaire = new Commentaire();
        commentaire.setId(rs.getInt("id"));
        commentaire.setDateCreation(rs.getTimestamp("date_de_creation"));
        commentaire.setContenuTexte(rs.getString("contenu_texte"));
        commentaire.setUtilisateurId(rs.getInt("utilisateur_id"));
        return commentaire;
    }
}
