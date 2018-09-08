package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Utilisateur;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public class GestionUtilisateurAction extends ActionSupport {

    public final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private List<Utilisateur> listUtilisateur;
    private Utilisateur utilisateur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String doCreate() {
        String result = Action.INPUT;
        if (utilisateur != null) {
            try {
                managerFactory.getUtilisateurManager().create(utilisateur);
                result = Action.SUCCESS;
            } catch (Exception e) {
                this.addActionError(e.getMessage());
                result = ActionSupport.ERROR;
            }
        }
        return result;
    }

    public String doDetail() {
        utilisateur = managerFactory.getUtilisateurManager().get(id);
        return Action.SUCCESS;
    }

    public String doList() {
        listUtilisateur = managerFactory.getUtilisateurManager().list();
        return Action.SUCCESS;
    }

    public String doUpdate(){
        // todo une meilleurs gestion du mot de passe, pour l'instant le mot de passe est appelé sur la page !!!!!
        String resultat = ActionSupport.INPUT;

        if (this.utilisateur != null) {
            if (this.utilisateur.getId() != null) {
                // Le formulaire a été envoyé, afin d'éviter la manipulation des données via le navigateur, on instancie un objet temporaire
                // Ainsi l'id est non modifiable.
                Utilisateur tmpUtilisateur = managerFactory.getUtilisateurManager().get(utilisateur.getId());
                tmpUtilisateur.setNom(utilisateur.getNom());
                tmpUtilisateur.setPrenom(utilisateur.getPrenom());
                tmpUtilisateur.setPseudo(utilisateur.getPseudo());
                tmpUtilisateur.setAdresse(utilisateur.getAdresse());
                tmpUtilisateur.setAdresseMail(utilisateur.getAdresseMail());
                tmpUtilisateur.setDateInscription(utilisateur.getDateInscription());
                tmpUtilisateur.setUuid(utilisateur.getUuid());
                tmpUtilisateur.setHashMotDePasse(utilisateur.getHashMotDePasse());
                managerFactory.getUtilisateurManager().update(tmpUtilisateur);
                resultat = ActionSupport.SUCCESS;
            } else {
                this.addActionError("Id doit être défini");
                resultat = ActionSupport.ERROR;
            }
        } else {
            // Si utilisateur est null c'est qu'on va entrer sur la jsp update.jsp, il faut embarquer les données sur utilisateur afin de pré-rempir les champs de la page web
            utilisateur = managerFactory.getUtilisateurManager().get(id);
        }
        return resultat;
    }

    public String doDelete() {
        managerFactory.getUtilisateurManager().delete(id);
        return Action.SUCCESS;
    }
}
