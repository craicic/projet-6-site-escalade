package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.UtilisateurDao;
import com.gg.proj.model.bean.Utilisateur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

    private final static Logger logger = LogManager.getLogger();

    @Override
    public void create(Object model) {
        logger.debug("Entrée dans la méthode create");
        Utilisateur utilisateur = (Utilisateur) model;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("INSERT INTO utilisateur (nom, prenom, pseudo, adresse, description, adresse_mail, date_inscription, uuid, hash_du_mot_de_passe) VALUES (?,?,?,?,?,?,?,?,?);",
                utilisateur.getNom(),
                utilisateur.getPrenom(),
                utilisateur.getPseudo(),
                utilisateur.getAdresse(),
                utilisateur.getDescription(),
                utilisateur.getAdresseMail(),
                utilisateur.getDateInscription(),
                utilisateur.getUuid(),
                utilisateur.getHashMotDePasse()
        );
    }

    @Override
    public Object get(int id) {
        logger.debug("Entrée dans la méthode get");
        return null;
    }

    @Override
    public List list() {
        logger.debug("Entrée dans la méthode list");
        List<Utilisateur> utilisateurs;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        utilisateurs = jdbcTemplate.query("SELECT * FROM utilisateur;",
                (rs, rowNum) -> {
                    Utilisateur u = new Utilisateur();
                    u.setId(rs.getInt("id"));
                    u.setNom(rs.getString("nom"));
                    u.setPrenom(rs.getString("prenom"));
                    u.setPseudo(rs.getString("pseudo"));
                    u.setAdresse(rs.getString("adresse"));
                    u.setDescription(rs.getString("Description"));
                    u.setAdresseMail(rs.getString("adresse_mail"));
                    u.setDateInscription(rs.getDate("date_inscription"));
                    u.setUuid(rs.getString("uuid"));
                    return u;
                });
        return utilisateurs;
    }

    @Override
    public void update(Object model) {
        logger.debug("Entrée dans la méthode update");
    }

    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete");
    }
}
