package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.EmpruntDao;
import com.gg.proj.consumer.impl.rowmapper.EmpruntRM;
import com.gg.proj.model.bean.Emprunt;
import com.gg.proj.model.bean.Topo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import javax.naming.Name;
import java.sql.Types;
import java.util.List;

@Named
public class EmpruntDaoImpl extends AbstractDaoImpl implements EmpruntDao {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(Emprunt model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("INSERT INTO emprunt (date_emprunt, date_retour, utilisateur_id, topo_id) VALUES(?, ?, ?, ?);",
                model.getDateEmprunt(),
                model.getDateRetour(),
                model.getUtilisateurId(),
                model.getTopoId()
        );
    }

    @Override
    public Emprunt get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + id);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        EmpruntRM empruntRM = new EmpruntRM();
        return jdbcTemplate.queryForObject("SELECT * FROM emprunt WHERE id = ?;", empruntRM, id);
    }

    @Override
    public List<Emprunt> list() {
        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        EmpruntRM empruntRM = new EmpruntRM();
        return jdbcTemplate.query("SELECT * FROM emprunt;", empruntRM);
    }

    @Override
    public void update(Emprunt model) {
        logger.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("UPDATE emprunt SET (date_emprunt,date_retour,utilisateur_id) = (?,?,?,?) WHERE id = ?;",
                model.getDateEmprunt(),
                model.getDateRetour(),
                model.getUtilisateurId(),
                model.getTopoId(),
                model.getId());
    }

    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM emprunt WHERE id = ?;", id);
    }

    @Override
    public List<Emprunt> getEmpruntByTopoId(Integer topoId){
        logger.debug("Entrée dans la méthode getEmpruntByTopoId avec le topoId " + topoId);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        EmpruntRM eRM = new EmpruntRM();
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", topoId, Types.INTEGER);
        String rSQL = "SELECT * FROM emprunt WHERE emprunt.topo_id = :topoId;";
        return jdbcTemplate.query(rSQL, params, eRM);
    }
}
