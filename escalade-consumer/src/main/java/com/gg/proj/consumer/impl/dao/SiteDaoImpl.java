package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.SiteDao;
import com.gg.proj.consumer.impl.rowmapper.SiteRM;
import com.gg.proj.model.bean.Site;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.sql.Types;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
    private static final Logger logger = LogManager.getLogger();

    // TODO gestion des coordonnées
    @Override
    public void create(Site model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("INSERT INTO site (nom, description, profil, roche, type, coordonnee_x,coordonnee_y) VALUES (?,?,?,?,?,?,?);",
                model.getNom(),
                model.getDescription(),
                model.getProfil(),
                model.getRoche(),
                model.getType(),
                model.getCoordonneeX(),
                model.getCoordonneeY()
        );
    }

    @Override
    public Site get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + id);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        SiteRM siteRM = new SiteRM();
        return jdbcTemplate.queryForObject("SELECT * FROM site WHERE id = ?;", siteRM, id);
    }

    @Override
    public List<Site> list() {
        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        SiteRM siteRM = new SiteRM();
        return jdbcTemplate.query("SELECT * FROM site;", siteRM);
    }

    @Override
    public void update(Site model) {
        logger.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("UPDATE site SET (nom,description,profil,roche,type,coordonnee_x,coordonnee_y) = (?,?,?,?,?,?,?) WHERE id = ?;",
                model.getNom(),
                model.getDescription(),
                model.getProfil(),
                model.getRoche(),
                model.getType(),
                model.getCoordonneeX(),
                model.getCoordonneeY(),
                model.getId()
        );
    }

    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM site WHERE id = ? ;", id);
    }

    /**
     * Méthode qui va accéder à la BDD avec une requête LIKE
     *
     * @param termeDeLaRecherche
     * @return les sites qui correspondent
     */
    @Override
    public List<Site> search(String termeDeLaRecherche) {
        logger.debug("Entrée dans la méthode search avec le terme de recherche :" +termeDeLaRecherche);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        SiteRM siteRM = new SiteRM();
        // Préparation des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("terme", "%" + termeDeLaRecherche + "%", Types.VARCHAR);

        String SQL = "SELECT * FROM site WHERE upper(nom) LIKE upper(:terme) OR upper(description) LIKE upper(:terme);";
        return jdbcTemplate.query(SQL, params, siteRM);
    }

    /**
     * Méthode qui accède à la BDD avec utilisation de la table de composition site / topo.
     * Elle récupère les sites liés au topoId passé en paramètre.
     *
     * @param topoId
     * @return liste des site lié au Topo.
     */
    @Override
    public List<Site> getListByTopoId(Integer topoId) {
        logger.debug("Entrée dans la méthode getListByTopoId avec le topoId : "+topoId);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        SiteRM siteRM = new SiteRM();
        // Préparation des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", topoId, Types.INTEGER);
        // requete SQL : On récupère les sites liés au topoId passé en paramètre.
        String SQL = "SELECT * FROM site WHERE site.id IN " +
                "(SELECT composition_site_topo.site_id FROM composition_site_topo " +
                "WHERE composition_site_topo.topo_id = :topoId);";
        return jdbcTemplate.query(SQL, params, siteRM);
    }

    /**
     * Méthode qui accède à la BDD avec utilisation de la table de composition site / topo.
     * Elle récupère la liste de tout les sites qui ne sont pas associé au topoId
     *
     * @param topoId
     * @return liste des site non-lié au Topo.
     */
    @Override
    public List<Site> getListByTopoIdReverse(Integer topoId) {
        logger.debug("Entrée dans la méthode getListByTopoIdReverse avec le topoId : "+topoId);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        SiteRM siteRM = new SiteRM();
        // Préparation des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topoId", topoId, Types.INTEGER);
        // requete SQL : On récupère les sites liés au topoId passé en paramètre.
        String SQL = "SELECT * FROM site WHERE site.id NOT IN " +
                "(SELECT composition_site_topo.site_id FROM composition_site_topo " +
                "WHERE composition_site_topo.topo_id = :topoId);";
        return jdbcTemplate.query(SQL, params, siteRM);
    }

    /**
     *
     * Cette méthode récupère l'objet Site par secteurId
     *
     * @param secteurId
     * @return Site
     */
    @Override
    public Site getSiteBySecteurId(Integer secteurId) {
        logger.debug("Entrée dans la méthode getSiteBySecteurId avec le secteurId : " + secteurId);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        SiteRM siteRM = new SiteRM();
        // Préparation des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("secteurId", secteurId, Types.INTEGER);

        String SQL = "SELECT * FROM site JOIN secteur ON site.id = secteur.site_id WHERE secteur.id = :secteurId;";
        return jdbcTemplate.queryForObject(SQL ,params,siteRM);
    }

}
