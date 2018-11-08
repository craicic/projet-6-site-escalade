package com.gg.proj.consumer.impl.rowmapper;

import com.gg.proj.consumer.contract.dao.UtilisateurDao;
import com.gg.proj.model.bean.Commentaire;
import com.gg.proj.model.bean.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CommentaireFullRM implements RowMapper<Commentaire> {

    @Override
    public Commentaire mapRow(ResultSet rs, int rowNum) throws SQLException {
        Commentaire commentaire = new Commentaire();
        commentaire.setId(rs.getInt("id"));
        commentaire.setDateCreation(rs.getTimestamp("date_de_creation"));
        commentaire.setContenuTexte(rs.getString("contenu_texte"));
        commentaire.setUtilisateurId(rs.getInt("utilisateur_id"));
        commentaire.setUtilisateur(new Utilisateur(rs.getString("pseudo")));
        return commentaire;
    }
}
