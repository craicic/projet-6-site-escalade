package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.VoieDao;
import com.gg.proj.consumer.impl.rowmapper.VoieRM;
import com.gg.proj.model.bean.Secteur;
import com.gg.proj.model.bean.Site;
import com.gg.proj.model.bean.Topo;
import com.gg.proj.model.bean.Voie;
import javafx.util.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.sql.Types;
import java.util.List;

@Named
public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(Voie model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("INSERT INTO voie (nom,description,nombre_points,nombre_longueurs,cotation,hauteur,secteur_id) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?);",
                model.getNom(),
                model.getDescription(),
                model.getNombreDePoints(),
                model.getNombreDeLongueurs(),
                model.getCotation(),
                model.getHauteur(),
                model.getSecteurId()
        );
    }

    @Override
    public Voie get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + id);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        VoieRM voieRM = new VoieRM();
        return jdbcTemplate.queryForObject("SELECT * FROM voie WHERE id = ?;", voieRM, id);
    }

    @Override
    public List<Voie> list() {

        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        VoieRM voieRM = new VoieRM();
        return jdbcTemplate.query("SELECT * FROM voie;", voieRM);
    }

    @Override
    public void update(Voie model) {
        logger.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("UPDATE voie SET (nom,description,nombre_points,nombre_longueurs,cotation,hauteur,secteur_id) = (?,?,?,?,?,?,?) WHERE id = ?;",
                model.getNom(),
                model.getDescription(),
                model.getNombreDePoints(),
                model.getNombreDeLongueurs(),
                model.getCotation(),
                model.getHauteur(),
                model.getSecteurId(),
                model.getId());
    }

    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM voie WHERE id = ?;", id);
    }

    /**
     * Méthode qui va accéder à la BDD avec une requête LIKE
     *
     * @param termeDeLaRecherche
     * @return les voies qui correspondent
     */
    @Override
    public List<Voie> search(String termeDeLaRecherche) {
        logger.debug("Entrée dans la méthode search avec comme terme de recherche : " + termeDeLaRecherche);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        VoieRM voieRM = new VoieRM();
        //Préparation des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("terme", "%" + termeDeLaRecherche + "%", Types.VARCHAR);

        String SQL = "SELECT * FROM voie v WHERE upper(v.nom) LIKE upper(:terme) OR upper(v.description) LIKE upper(:terme);";
        return jdbcTemplate.query(SQL, params, voieRM);
    }

    /**
     * Méthode qui récupère les voie associé un secteur
     *
     * @param secteurId
     * @return la liste des voies liées au secteur
     */
    @Override
    public List<Voie> listBySecteurId(Integer secteurId) {
        logger.debug("Entrée dans la méthode listBySecteurId avec le secteurId : " + secteurId);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        VoieRM voieRM = new VoieRM();
        // Préparation des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("secteurId", secteurId, Types.INTEGER);

        String SQL = "SELECT * FROM voie v WHERE (v.secteur_id) = (:secteurId) ;";
        return jdbcTemplate.query(SQL, params, voieRM);
    }

    @Override
    public List<Voie> listVoieByDifficulty(List<String> listDifficultes, List<Integer> listVoieId) {
        logger.debug("Entrée dans la méthode listVoieByDifficulty");
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        // préparation des params
        VoieRM seRM = new VoieRM();
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("listDifficultes",listDifficultes);
        params.addValue("listVoieId",listVoieId);

        String rSQL = "SELECT DISTINCT v.* FROM voie v" +
                " WHERE v.cotation IN (:listDifficultes) " +
                " AND v.id IN (:listVoieId);";
        return jdbcTemplate.query(rSQL, params, seRM);
    }
}
