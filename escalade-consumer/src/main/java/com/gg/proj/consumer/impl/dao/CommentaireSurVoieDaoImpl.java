package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.CommentaireSurVoieDao;
import com.gg.proj.model.bean.CommentaireSurVoie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireSurVoieDaoImpl extends AbstractDaoImpl implements CommentaireSurVoieDao {
    private static final Logger logger = LogManager.getLogger();

    /**
     * Création d'une entrée en base de donnée dans la table correspondante
     * @param model le bean de type {@link CommentaireSurVoie}
     */
    @Override
    public void create(CommentaireSurVoie model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("INSERT INTO commentaire_sur_voie (voie_id,commentaire_id)  VALUES(?, ?);",
                model.getVoieId(),
                model.getCommentaireId()
        );
    }

    /**
     * Cette méthode get pourrait plus précisement s'appeler getByCommentId (on garde get pour coller à l'interface CrudDao)
     * @param commentaireId
     * @return un bean CommentaireSurVoie qui associe à un commentaireId son voieId
     */
    @Override
    public CommentaireSurVoie get(int commentaireId) {
        logger.debug("Entrée dans la méthode get avec commentaireId " + commentaireId);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.queryForObject("SELECT * FROM commentaire_sur_voie WHERE commentaire_id = ?;", (rs, rowNum) -> {
                    CommentaireSurVoie c = new CommentaireSurVoie();
                    c.setVoieId(rs.getInt("voie_id"));
                    c.setCommentaireId(rs.getInt("commentaire_id"));
                    return c;
                },
                commentaireId);
    }

    @Override
    public List<CommentaireSurVoie> list() {
        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.query("SELECT * FROM commentaire_sur_voie;", (rs, rowNum) -> {
            CommentaireSurVoie c = new CommentaireSurVoie();
            c.setVoieId(rs.getInt("voie_id"));
            c.setCommentaireId(rs.getInt("commentaire_id"));
            return c;
        });
    }

    @Override
    public void update(CommentaireSurVoie model) {
        logger.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("UPDATE commentaire_sur_voie SET (voie_id) = (?) WHERE commentaire_id = ?;",
                model.getVoieId(),
                model.getCommentaireId()
        );
    }

    /**
     * la méthode delete prend en paramètre un commentaire_id (elle pourrait aussi s'appelée deleteByCommentId)
     * @param commentaireId
     */
    @Override
    public void delete(Integer commentaireId) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM commentaire_sur_voie WHERE commentaire_id = ?;", commentaireId);
    }
}
