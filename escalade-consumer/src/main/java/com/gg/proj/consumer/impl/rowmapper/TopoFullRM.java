package com.gg.proj.consumer.impl.rowmapper;

import com.gg.proj.model.bean.Emprunt;
import com.gg.proj.model.bean.Topo;
import com.gg.proj.model.bean.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TopoFullRM implements RowMapper<Topo> {

    @Override
    public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Topo topo = new Topo();
        topo.setId(rs.getInt("id"));
        topo.setTitre(rs.getString("titre"));
        topo.setAuteur(rs.getString("auteur"));
        topo.setDescription(rs.getString("description"));
        topo.setEmpreintable(rs.getBoolean("empreintable"));
        topo.setProprietaireId(rs.getInt("proprietaire_id"));
        topo.setEmprunteur(new Utilisateur(rs.getInt("emprunteur_id"),rs.getString("emprunteur_pseudo")));
        topo.setEmprunt(new Emprunt(rs.getObject("date_emprunt", LocalDate.class), rs.getObject("date_retour", LocalDate.class)));
        return topo;
    }
}