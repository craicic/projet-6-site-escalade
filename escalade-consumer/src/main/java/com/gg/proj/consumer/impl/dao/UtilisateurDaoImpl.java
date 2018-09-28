package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.UtilisateurDao;
import com.gg.proj.consumer.impl.rowmapper.UtilisateurRM;
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
    public void create(Utilisateur model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("INSERT INTO utilisateur (nom, prenom, pseudo, adresse, description, adresse_mail, date_inscription, uuid, hash_du_mot_de_passe) VALUES (?,?,?,?,?,?,?,?,?);",
                model.getNom(),
                model.getPrenom(),
                model.getPseudo(),
                model.getAdresse(),
                model.getDescription(),
                model.getAdresseMail(),
                model.getDateInscription(),
                model.getUuid(),
                model.getHashMotDePasse()
        );
    }

    @Override
    public Utilisateur get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        UtilisateurRM utilisateurRM = new UtilisateurRM();
        Utilisateur utilisateur = jdbcTemplate.queryForObject("SELECT * FROM utilisateur WHERE id = ?;",
                utilisateurRM,
                id);
        return utilisateur;
    }

    @Override
    public List list() {
        logger.debug("Entrée dans la méthode list");
        List<Utilisateur> utilisateurs;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        UtilisateurRM utilisateurRM = new UtilisateurRM();
        utilisateurs = jdbcTemplate.query("SELECT * FROM utilisateur;", utilisateurRM);
        return utilisateurs;
    }

    @Override
    public void update(Utilisateur model) {
        Utilisateur utilisateur = (Utilisateur) model;
        logger.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("UPDATE utilisateur SET (nom, prenom, pseudo, adresse, description, adresse_mail, date_inscription, uuid)" +
                        " = (?,?,?,?,?,?,?,?)" +
                        "WHERE id = ?;",
                utilisateur.getNom(),
                utilisateur.getPrenom(),
                utilisateur.getPseudo(),
                utilisateur.getAdresse(),
                utilisateur.getDescription(),
                utilisateur.getAdresseMail(),
                utilisateur.getDateInscription(),
                utilisateur.getUuid(),
//                utilisateur.getHashMotDePasse(),
                utilisateur.getId()
        );
    }

    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM utilisateur WHERE id = ?;", id);
    }

    @Override
    public Utilisateur getByUserPseudo(String identifiant) {
        logger.debug("Entrée dans la méthode getByUserPseudo(param : 'identifiant')");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        UtilisateurRM utilisateurRM = new UtilisateurRM();
        return jdbcTemplate.queryForObject("SELECT * FROM utilisateur WHERE pseudo = ?;", utilisateurRM, identifiant);
    }



    @Override
    public String getHash(String identifiant) {
        logger.debug("Entrée dans la méthode getHash");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        Utilisateur utilisateur = jdbcTemplate.queryForObject("SELECT * FROM utilisateur WHERE pseudo = ?;", (rs, rowNum) ->
        {
            Utilisateur u = new Utilisateur();
            u.setHashMotDePasse(rs.getString("hash_du_mot_de_passe"));
            return u;
        }, identifiant);
        return utilisateur.getHashMotDePasse();
    }

    @Override
    public void updatePassword(String identifiant, String motDePasse) {
        logger.debug("Entrée dans la méthode updatePassword");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        logger.info("mpd : "+motDePasse + " identifiant : "+identifiant);
        jdbcTemplate.update("UPDATE utilisateur SET hash_du_mot_de_passe = ? WHERE pseudo = ?;",
                motDePasse,
                identifiant);
    }

    @Override
    public Utilisateur getByUserMailAdress(String adresseEmail) {
        logger.debug("Entrée dans la méthode getByUserMailAdresse");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        UtilisateurRM utilisateurRM = new UtilisateurRM();
        return jdbcTemplate.queryForObject("SELECT * FROM utilisateur WHERE adresse_mail = ?;", utilisateurRM, adresseEmail);
    }
}