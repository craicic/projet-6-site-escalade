package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.ProprieteTopoDao;
import com.gg.proj.consumer.impl.rowmapper.ProprieteTopoRM;
import com.gg.proj.consumer.impl.rowmapper.UtilisateurRM;
import com.gg.proj.model.bean.ProprieteTopo;
import com.gg.proj.model.bean.Utilisateur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.sql.Types;
import java.util.List;

@Named
public class ProprieteTopoDaoImpl extends AbstractDaoImpl implements ProprieteTopoDao {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(ProprieteTopo model) {
        logger.debug("Entrée dans la méthode create");
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        // Préparation des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", model.getTopoId(), Types.INTEGER);
        params.addValue("utilisateurId", model.getUtilisateurId(), Types.INTEGER);
        params.addValue("status", model.getStatus(), Types.VARCHAR);
        //SQL
        String SQL = "INSERT INTO propriete_topo (topo_id, utilisateur_id, status) VALUES (:topoId, :utilisateurId,:status) ;";
        // Query
        jdbcTemplate.update(SQL, params);
    }

    /**
     * Méthode au nom trop générique, c'est un getByTopoId
     *
     * @param id
     * @return
     * @deprecated
     */
    @Override
    public ProprieteTopo get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + id);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        // Préparation des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", id, Types.INTEGER);
        // RowMapper
        ProprieteTopoRM proprieteTopoRM = new ProprieteTopoRM();
        // SQL
        String SQL = "SELECT * FROM propriete_topo WHERE topo_id = :topoId;";
        return jdbcTemplate.queryForObject(SQL, params, proprieteTopoRM);
    }

    @Override
    public List<ProprieteTopo> list() {
        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        // RowMapper
        ProprieteTopoRM proprieteTopoRM = new ProprieteTopoRM();
        // SQL
        String SQL = "SELECT * FROM propriete_topo;";
        return jdbcTemplate.query(SQL, proprieteTopoRM);
    }

    /**
     * Méthode au nom trop générique, c'est un updateByTopoId
     *
     * @param model
     * @deprecated
     */
    @Override
    public void update(ProprieteTopo model) {
        logger.debug("Entrée dans la méthode update");
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        // Préparation des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", model.getTopoId(), Types.INTEGER);
        params.addValue("utilisateurId", model.getUtilisateurId(), Types.INTEGER);
        params.addValue("status", model.getStatus(), Types.VARCHAR);
        //SQL
        String SQL = "UPDATE propriete_topo p SET (utilisateur_id, status) = (:utilisateurId,:status) WHERE p.topo_id = :topoId;";
        // Update
        jdbcTemplate.update(SQL, params);

    }

    /**
     * Méthode au nom trop générique, c'est un deleteByTopoId
     *
     * @param id l'id du Topo
     * @deprecated
     */
    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete avec l'id " + id);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        // Préparation des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", id, Types.INTEGER);
        // SQL
        String SQL = "DELETE FROM propriete_topo WHERE topo_id = :topoId;";
        // Update
        jdbcTemplate.update(SQL, params);
    }


    /**
     * Méthode de récupération des utilisateurs possedant le topo d'id topoId
     * @param topoId
     * @return Liste de possesseurs
     */
    @Override
    public List<Utilisateur> listAllOnwersByTopoId(Integer topoId) {
        logger.debug("Entrée dans la méthode listAllOnwersByTopoId " + topoId);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        // Préparation des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", topoId);
        // RowMapper
        ProprieteTopoRM pRM = new ProprieteTopoRM();
        UtilisateurRM uRM = new UtilisateurRM();
        // SQL
        String SQL = "SELECT * FROM utilisateur WHERE utilisateur.id IN (SELECT propriete_topo.utilisateur_id FROM propriete_topo WHERE propriete_topo.topo_id = :topoId ); ";
        // Update
        return jdbcTemplate.query(SQL, params, uRM);
    }
}
