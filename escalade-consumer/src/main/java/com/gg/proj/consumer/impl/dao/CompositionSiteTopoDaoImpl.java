package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.CompositionSiteTopoDao;
import com.gg.proj.consumer.impl.rowmapper.CompositionSiteTopoRM;
import com.gg.proj.model.bean.CompositionSiteTopo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class CompositionSiteTopoDaoImpl extends AbstractDaoImpl implements CompositionSiteTopoDao {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(CompositionSiteTopo model) {
        logger.debug("Entrée dans la méthode create");
        NamedParameterJdbcTemplate jdbcTempplate = new NamedParameterJdbcTemplate(getDataSource());
        // Définition des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", model.getTopoId());
        params.addValue("siteId", model.getSiteId());
        // requete SQL
        String SQL = "INSERT INTO composition_site_topo (topo_id, site_id) VALUES (:topoId,:siteId);";
        jdbcTempplate.update(SQL, params);

    }

    @Override
    public CompositionSiteTopo get(int topoId) {
        logger.debug("Entrée dans la méthode get avec le topoId " + topoId);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        // instanciation RM
        CompositionSiteTopoRM cRM = new CompositionSiteTopoRM();
        // définition des params
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", topoId);
        // Requete SQL
        String SQL = "SELECT * FROM composition_site_topo WHERE topo_id = :topoId;";
        return namedParameterJdbcTemplate.queryForObject(SQL, params, cRM);
    }

    @Override
    public List<CompositionSiteTopo> list() {
        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        // instanciation du RM
        CompositionSiteTopoRM cRM = new CompositionSiteTopoRM();
        // requete SQL
        String SQL = "SELECT * FROM composition_site_topo;";

        return jdbcTemplate.query(SQL, cRM);
    }

    @Override
    public void update(CompositionSiteTopo model) {
        logger.debug("Entrée dans la méthode update");
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        // définition des params
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", model.getTopoId());
        params.addValue("siteId", model.getSiteId());
        // requete SQL
        String SQL = "UPDATE composition_site_topo SET (topo_id,site_id) = (:topoId,:siteId);";

        namedParameterJdbcTemplate.update(SQL, params);
    }

    @Override
    public void delete(Integer topoId) {
        logger.debug("Entrée dans la méthode delete");
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        // définition des params
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", topoId);
        jdbcTemplate.update("DELETE FROM composition_site_topo WHERE topo_id = :topoId;", params);
    }

    /**
     * Méthode dao de suppression de l'entrée compositionSiteTopo
     * @param compositionSiteTopo
     */
    @Override
    public void deleteByModel(CompositionSiteTopo compositionSiteTopo) {
        logger.debug("Entrée dans la méthode deleteByModel");
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        // définition des params
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", compositionSiteTopo.getTopoId());
        params.addValue("siteId", compositionSiteTopo.getSiteId());

        String SQL = "DELETE FROM composition_site_topo WHERE (topo_id,site_id) = (:topoId,:siteId);";
        jdbcTemplate.update(SQL, params);
    }
}
