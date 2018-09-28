package com.gg.proj.consumer.impl.rowmapper;

import com.gg.proj.model.bean.Site;
import org.postgresql.geometric.PGpoint;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SiteRM implements RowMapper<Site> {

    @Override
    public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
        Site site = new Site();
        site.setId(rs.getInt("id"));
        site.setNom(rs.getString("nom"));
        site.setDescription(rs.getString("description"));
        site.setProfil(rs.getString("profil"));
        site.setRoche(rs.getString("roche"));
        site.setType(rs.getString("type"));
        site.setCoordonneesGPS((PGpoint) rs.getObject("coordonnees_gps"));
        return site;
    }
}
