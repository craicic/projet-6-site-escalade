package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.TopoDao;
import com.gg.proj.consumer.impl.rowmapper.TopoFullRM;
import com.gg.proj.consumer.impl.rowmapper.TopoRM;
import com.gg.proj.model.bean.Topo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Named
//@Singleton
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(Topo model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("INSERT INTO topo (auteur, titre, description, proprietaire_id) VALUES(?, ?, ?, ?);",
                model.getAuteur(),
                model.getTitre(),
                model.getDescription(),
                model.getProprietaireId()
        );
    }

    @Override
    public Topo get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + id);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        TopoRM topoRM = new TopoRM();
        // RowMapper<T> ecrit via lambda
//                (rs, rowNum) -> {
//                    Topo t = new Topo();
//                    t.setId(rs.getInt("id"));
//                    t.setTitre(rs.getString("titre"));
//                    t.setAuteur(rs.getString("auteur"));
//                    t.setDescription(rs.getString("description"));
//                    return t;
//                },
        return jdbcTemplate.queryForObject("SELECT t.* FROM topo t WHERE t.id = ?;", topoRM, id /* Paramètre '?' de la requête */);
    }

    @Override
    public List<Topo> list() {
        logger.debug("Entrée dans la méthode list");
        List<Topo> topos;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        TopoRM topoRM = new TopoRM();
        topos = jdbcTemplate.query("SELECT * FROM topo;", topoRM);
        return topos;
    }

    @Override
    public void update(Topo model) {
        logger.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("UPDATE topo SET (auteur, titre, description, proprietaire_id) = (?,?,?,?) WHERE id = ? ;",
                model.getAuteur(),
                model.getTitre(),
                model.getDescription(),
                model.getProprietaireId(),
                model.getId()
        );

    }

    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM topo WHERE id = ?;", id);
    }

    /**
     * Méthode qui recherche l'id du topo associé au titre
     *
     * @param titreTopo le titre du topo recherché
     * @return L'id du topo recherché
     */
    @Override
    public Integer getIdByTitre(String titreTopo) {
        logger.debug("Entrée dans la méthode getIdByTitre avec le titre titreTppo : " + titreTopo);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("titre", titreTopo);
        return jdbcTemplate.queryForObject("SELECT id FROM topo WHERE (titre) = (:titre);",
                /* Params '?' */
                param,
                /* RowMapper : */
                (rs, rowNum) -> rs.getInt("id")
        );
    }

    /**
     * Fonction qui va accéder à la BDD avec une requête LIKE, elle permet une recheche des topo comportant l'expression
     * termeDeLaRecherche.
     *
     * @param termeDeLaRecherche l'expression à rechercher
     * @return les topos qui correspondent
     */
    @Override
    public List<Topo> search(String termeDeLaRecherche) {
        logger.debug("Entrée dans la méthode search avec comme terme de recherche : " + termeDeLaRecherche);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        TopoRM topoRM = new TopoRM();
        // Préparation des paramètres
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("terme", "%" + termeDeLaRecherche + "%", Types.VARCHAR);

        String SQL = "SELECT * FROM topo t WHERE upper(t.auteur) LIKE upper(:terme) " +
                "OR upper(t.titre) LIKE upper(:terme) " +
                "OR upper(t.description) LIKE upper(:terme) ;";
        return jdbcTemplate.query(SQL, params, topoRM);
    }

    /**
     * Cette méthode renvoi la liste des topo qui ne sont pas en cour d'emprunt
     *
     * @return liste de topos
     */
    @Override
    public List<Topo> listAvailableTopo() {
        logger.debug("Entrée dans la méthode listAvailableTopo");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        TopoRM tRM = new TopoRM();
        String rSQL = "SELECT t.id, t.titre, t.auteur, t.description, t.proprietaire_id FROM topo t" +
                "   LEFT OUTER JOIN emprunt ON t.id = emprunt.topo_id" +
                "   WHERE emprunt.topo_id IS NULL" +
                "   OR emprunt.date_retour < CURRENT_DATE ;";
        return jdbcTemplate.query(rSQL, tRM);
    }


    /**
     * Récupère les topos qui ont été empruntés par l'utilisateur d'id borrowerId
     *
     * @param borrowerId
     * @return liste de topos
     */
    @Override
    public List<Topo> listTopoByBorrowerId(Integer borrowerId) {
        logger.debug("Entrée dans la méthode getTopoByBorrowerId");
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        TopoRM tRM = new TopoRM();
        // préparation des params
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("borrowerId", borrowerId, Types.INTEGER);

        String rSQL = "SELECT t.id, t.titre, t.proprietaire_id, t.auteur, t.description FROM topo t" +
                " INNER JOIN emprunt e ON t.id = e.topo_id " +
                "WHERE e.utilisateur_id = :borrowerId;";
        return jdbcTemplate.query(rSQL, params, tRM);
    }

    /**
     * Récupère les topos qui ont été prétés par l'utilisateur d'id loanerId
     *
     * @param loanerId
     * @return liste de topos
     */
    @Override
    public List<Topo> listTopoByLoanerId(Integer loanerId) {
        logger.debug("Entrée dans la méthode getTopoByBorrowerId");
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        TopoFullRM tRM = new TopoFullRM();
        // préparation des params
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("loanerId", loanerId, Types.INTEGER);

        String rSQL = "SELECT t.*, e.date_emprunt, e.date_retour, u.id as emprunteur_id, u.pseudo as emprunteur_pseudo FROM topo t" +
                " INNER JOIN emprunt e on t.id = e.topo_id" +
                " INNER JOIN utilisateur u on e.utilisateur_id = u.id" +
                " WHERE t.proprietaire_id = :loanerId" +
                " AND e.date_retour > CURRENT_DATE;";
        return jdbcTemplate.query(rSQL, params, tRM);
    }

    @Override
    public List<Topo> listTopoBySiteId(Integer siteId) {
        logger.debug("Entrée dans la méthode listTopoBySiteId avec le siteId : " + siteId);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        TopoRM tRM = new TopoRM();
        // préparation des params
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("siteId", siteId, Types.INTEGER);

        String rSQL = "SELECT t.* FROM topo t" +
                " INNER JOIN composition_site_topo c on t.id = c.topo_id" +
                " INNER JOIN site s on c.site_id = s.id" +
                " WHERE site_id = :siteId;";
        return jdbcTemplate.query(rSQL, params, tRM);
    }

    @Override
    public List<Topo> listTopoByDifficulty(List<String> listDifficultes, List<Integer> listTopoId) {
        logger.debug("Entrée dans la méthode listTopoByDifficulty");
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        // préparation des params
        TopoRM tRM = new TopoRM();
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("listDifficultes", listDifficultes);
        params.addValue("listTopoId", listTopoId);

        String rSQL = "SELECT DISTINCT t.* FROM topo t " +
                " INNER JOIN composition_site_topo c on t.id = c.topo_id" +
                " INNER JOIN site s ON c.site_id = s.id" +
                " INNER JOIN secteur se ON s.id = se.site_id" +
                " INNER JOIN voie v ON se.id = v.secteur_id" +
                " WHERE v.cotation IN (:listDifficultes) " +
                " AND t.id IN (:listTopoId);";
        return jdbcTemplate.query(rSQL, params, tRM);
    }

    /**
     * Cette méthode solicite la dao pour récupérer les topo qui n'ont pas encore été emprunter et qui appartiennent a l'
     * utilisateur d'id utilisateurId
     *
     * @param utilisateurId l'id de l'utilisateur concerné
     * @return une liste de topos qui sont disponibles à l'emprunt
     */
    @Override
    public List<Topo> listAvailableTopoByUtilisateurId(Integer utilisateurId) {
        logger.debug("Entrée dans la méthode listAvailableTopoByUtilisateurId avec l'utilisateurId : " + utilisateurId);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        TopoRM tRM = new TopoRM();
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("utilisateurId", utilisateurId);

        String rSQL = "SELECT t.id, t.titre, t.auteur, t.description, t.proprietaire_id FROM topo t" +
                " LEFT OUTER JOIN emprunt ON t.id = emprunt.topo_id" +
                " WHERE t.proprietaire_id = :utilisateurId" +
                " AND (emprunt.topo_id IS NULL OR emprunt.date_retour < CURRENT_DATE);";
        return jdbcTemplate.query(rSQL, params, tRM);
    }


}
