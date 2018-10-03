package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.CommentaireSurTopoDao;
import com.gg.proj.model.bean.CommentaireSurTopo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireSurTopoDaoImpl extends AbstractDaoImpl implements CommentaireSurTopoDao {

    private static final Logger logger = LogManager.getLogger();

    /**
     * Création d'une entrée en base de donnée dans la table correspondante
     * @param model le bean de type {@link CommentaireSurTopo}
     */
    @Override
    public void create(CommentaireSurTopo model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("INSERT INTO commentaire_sur_topo (topo_id,commentaire_id)  VALUES(?, ?);",
                model.getTopoId(),
                model.getCommentaireId()
        );
    }

    /**
     * Cette méthode get pourrait plus précisement s'appeler getByCommentId (on garde get pour coller à l'interface CrudDao)
     * @param commentaireId
     * @return un bean CommentaireSurTopo qui associe à un commentaireId son topoId
     */
    @Override
    public CommentaireSurTopo get(int commentaireId) {
        logger.debug("Entrée dans la méthode get avec commentaireId " + commentaireId);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.queryForObject("SELECT * FROM commentaire_sur_topo WHERE commentaire_id = ?;", (rs, rowNum) -> {
                    CommentaireSurTopo c = new CommentaireSurTopo();
                    c.setTopoId(rs.getInt("topo_id"));
                    c.setCommentaireId(rs.getInt("commentaire_id"));
                    return c;
                },
                commentaireId);
    }

    @Override
    public List<CommentaireSurTopo> list() {
        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.query("SELECT * FROM commentaire_sur_topo;", (rs, rowNum) -> {
            CommentaireSurTopo c = new CommentaireSurTopo();
            c.setTopoId(rs.getInt("topo_id"));
            c.setCommentaireId(rs.getInt("commentaire_id"));
            return c;
        });
    }

    @Override
    // Cette méthode parait assez inutile
    public void update(CommentaireSurTopo model) {
        logger.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("UPDATE commentaire_sur_topo SET (topo_id) = (?) WHERE commentaire_id = ?;",
                model.getTopoId(),
                model.getCommentaireId()
        );
    }

    @Override
        /*
    /!\ la méthode getByUserPseudo prend en paramètre un commentaire_id
     */
    public void delete(Integer commentaireId) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM commentaire_sur_topo WHERE commentaire_id = ?;", commentaireId);
    }
}
