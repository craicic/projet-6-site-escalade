package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Utilisateur;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class GestionUtilisateurAction extends ActionSupport implements SessionAware {

    public final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private String motDePasseDoubleVerifiction;
    private String nouveauMotDePasse;
    private List<Utilisateur> listUtilisateur;
    private Utilisateur utilisateur;
    private Map<String,Object> session;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMotDePasseDoubleVerifiction() {
        return motDePasseDoubleVerifiction;
    }
    public void setMotDePasseDoubleVerifiction(String motDePasseDoubleVerifiction) {
        this.motDePasseDoubleVerifiction = motDePasseDoubleVerifiction;
    }
    public String getNouveauMotDePasse() {
        return nouveauMotDePasse;
    }
    public void setNouveauMotDePasse(String nouveauMotDePasse) {
        this.nouveauMotDePasse = nouveauMotDePasse;
    }
    public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
        this.listUtilisateur = listUtilisateur;
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

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String doCreate() {
        String result = ActionSupport.INPUT;
        if (utilisateur != null) {
            try {
                if (utilisateur.getHashMotDePasse().equals(motDePasseDoubleVerifiction)) {
                    managerFactory.getUtilisateurManager().create(utilisateur);
                    result = ActionSupport.SUCCESS;
                } else {
                    addActionError("Les mots de passe ne correspondent pas.");
                }
            } catch (Exception e) {
                this.addActionError(e.getMessage());
                result = ActionSupport.ERROR;
            }
        }
        return result;
    }

    public String doDetail() {
        utilisateur = managerFactory.getUtilisateurManager().get(id);
        return ActionSupport.SUCCESS;
    }

    public String doList() {
        listUtilisateur = managerFactory.getUtilisateurManager().list();
        return ActionSupport.SUCCESS;
    }

    public String doUpdate(){
        // n'update ni la date d'inscription ni le mot de passe ni l'uuid
        // todo une meilleurs gestion du mot de passe, pour l'instant le mot de passe est appelé sur la page
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
                tmpUtilisateur.setDescription(utilisateur.getDescription());
                tmpUtilisateur.setAdresseMail(utilisateur.getAdresseMail());
//                tmpUtilisateur.setDateInscription(utilisateur.getDateInscription());
//                tmpUtilisateur.setUuid(utilisateur.getUuid());
//                tmpUtilisateur.setHashMotDePasse(utilisateur.getHashMotDePasse());
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
        return ActionSupport.SUCCESS;
    }
    
    public String doUpdatePassword(){
        String resultat = ActionSupport.INPUT;
        if (nouveauMotDePasse != null && motDePasseDoubleVerifiction != null) {
            // On vérif qu'on est bien un utilisateur enregistré en session
            if (this.session.containsKey("utilisateur")) {
                // On récupère l'utilisateur en session
                logger.info("session : " + session.values());
                Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("utilisateur");
                logger.info("utilisateur en session : " + utilisateurEnSession.getPseudo());
                // Si les deux nouveau mot de passe ne match pas, on va pas plus loin
                if (!nouveauMotDePasse.equals(motDePasseDoubleVerifiction)){
                    addActionError("Les mots de passe ne correspondent pas.");
                    return resultat;
                }
                // Si l'ancien mot de passe ne match pas, on va pas plus loin
                else if (!managerFactory.getUtilisateurManager().isCorrectPassword(utilisateurEnSession.getPseudo(), utilisateur.getHashMotDePasse())){
                    addActionError("L'ancien mot de passe est incorrecte.");
                    return resultat;
                }
                // Si toute les vérifications sont passées avec succes, on va mettre à jour le mdp
                else {
                    managerFactory.getUtilisateurManager().updatePassword(utilisateurEnSession.getPseudo(), nouveauMotDePasse);
                    resultat = ActionSupport.SUCCESS;
                }
            } else {
                addActionError("Erreur de session");
                resultat = ActionSupport.ERROR;
            }
        }
        return resultat;
    }
}
