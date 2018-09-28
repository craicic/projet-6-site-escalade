package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.EmpreintDao;
import com.gg.proj.model.bean.Emprunt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class EmpruntDaoImpl extends AbstractDaoImpl implements EmpreintDao {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(Emprunt model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("INSERT INTO empreint (date_empreint, date_retour, utilisateur_id) VALUES(?, ?, ?);",
                model.getDateEmprunt(),
                model.getDateRetour(),
                model.getUtilisateurId()
        );
    }

    @Override
    public Emprunt get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + id);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.queryForObject("SELECT * FROM empreint WHERE id = ?;", (rs, rowNum) -> {
                    Emprunt emprunt = new Emprunt();
                    emprunt.setId(rs.getInt("id"));
                    emprunt.setDateEmprunt(rs.getDate("date_empreint"));
                    emprunt.setDateRetour(rs.getDate("date_retour"));
                    emprunt.setUtilisateurId(rs.getInt("utilisateur_id"));
                    return emprunt;
                },
                id);
    }

    @Override
    public List<Emprunt> list() {
        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.query("SELECT * FROM empreint;",
                (rs, rowNum) -> {
                    Emprunt emprunt = new Emprunt();
                    emprunt.setId(rs.getInt("id"));
                    emprunt.setDateEmprunt(rs.getDate("date_empreint"));
                    emprunt.setDateRetour(rs.getDate("date_retour"));
                    emprunt.setUtilisateurId(rs.getInt("utilisateur_id"));
                    return emprunt;
                });
    }

    @Override
    public void update(Emprunt model) {
        logger.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("UPDATE empreint SET (date_empreint,date_retour,utilisateur_id) = (?,?,?) WHERE id = ?;",
                model.getDateEmprunt(),
                model.getDateRetour(),
                model.getUtilisateurId(),
                model.getId());
    }

    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM empreint WHERE id = ?;", id);
    }
}
