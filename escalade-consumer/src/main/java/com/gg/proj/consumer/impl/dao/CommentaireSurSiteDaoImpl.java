package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.CommentaireSurSiteDao;
import com.gg.proj.model.bean.CommentaireSurSite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireSurSiteDaoImpl extends AbstractDaoImpl implements CommentaireSurSiteDao {

    private static final Logger logger = LogManager.getLogger();

    /**
     * Création d'une entrée en base de donnée dans la table correspondante
     * @param model le bean de type {@link CommentaireSurSite}
     */
    @Override
    public void create(CommentaireSurSite model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("INSERT INTO commentaire_sur_site (site_id,commentaire_id)  VALUES(?, ?);",
                model.getSiteId(),
                model.getCommentaireId()
        );
    }


    /**
     * Cette méthode get pourrait plus précisement s'appeler getByCommentId (on garde get pour coller à l'interface CrudDao)
     * @param commentaireId
     * @return un bean CommentaireSurSite qui associe à un commentaireId son siteId
     */
    @Override
    public CommentaireSurSite get(int commentaireId) {
        logger.debug("Entrée dans la méthode get avec commentaireId " + commentaireId);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.queryForObject("SELECT * FROM commentaire_sur_site WHERE commentaire_id = ?;", (rs, rowNum) -> {
                    CommentaireSurSite c = new CommentaireSurSite();
                    c.setSiteId(rs.getInt("site_id"));
                    c.setCommentaireId(rs.getInt("commentaire_id"));
                    return c;
                },
                commentaireId);
    }

    @Override
    public List<CommentaireSurSite> list() {
        return null;
    }

    @Override
    public void update(CommentaireSurSite model) {

    }

    @Override
    public void delete(Integer id) {

    }
}
