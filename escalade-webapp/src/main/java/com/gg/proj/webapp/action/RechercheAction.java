package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Secteur;
import com.gg.proj.model.bean.Site;
import com.gg.proj.model.bean.Topo;
import com.gg.proj.model.bean.Voie;
import com.gg.proj.technical.GenerateurDeDifficulte;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.InputMismatchException;
import java.util.List;

public class RechercheAction extends ActionSupport {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private List<Topo> listTopo;
    private List<Site> listSite;
    private List<Secteur> listSecteur;
    private List<Voie> listVoie;
    private String termeDeLaRecherche;
    private List<String> listDifficulte;
    private String difficulteMin;
    private String difficulteMax;

    public List<Topo> getListTopo() {
        return listTopo;
    }
    public void setListTopo(List<Topo> listTopo) {
        this.listTopo = listTopo;
    }
    public List<Site> getListSite() {
        return listSite;
    }
    public void setListSite(List<Site> listSite) {
        this.listSite = listSite;
    }
    public List<Secteur> getListSecteur() {
        return listSecteur;
    }
    public void setListSecteur(List<Secteur> listSecteur) {
        this.listSecteur = listSecteur;
    }
    public List<Voie> getListVoie() {
        return listVoie;
    }
    public void setListVoie(List<Voie> listVoie) {
        this.listVoie = listVoie;
    }
    public String getTermeDeLaRecherche() {
        return termeDeLaRecherche;
    }
    public void setTermeDeLaRecherche(String termeDeLaRecherche) {
        this.termeDeLaRecherche = termeDeLaRecherche;
    }
    public List<String> getListDifficulte() {
        return listDifficulte;
    }
    public void setListDifficulte(List<String> listDifficulte) {
        this.listDifficulte = listDifficulte;
    }
    public String getDifficulteMin() {
        return difficulteMin;
    }
    public void setDifficulteMin(String difficulteMin) {
        this.difficulteMin = difficulteMin;
    }
    public String getDifficulteMax() {
        return difficulteMax;
    }
    public void setDifficulteMax(String difficulteMax) {
        this.difficulteMax = difficulteMax;
    }

    public String doSearch() {
//        String result = ActionSupport.INPUT;

//        if(difficulteMin == null && difficulteMax == null) {

        listDifficulte = managerFactory.getRechercheManager().generateList();
        listTopo = managerFactory.getTopoManager().search(termeDeLaRecherche);
        listSite = managerFactory.getSiteManager().search(termeDeLaRecherche);
        listSecteur = managerFactory.getSecteurManager().search(termeDeLaRecherche);
        listVoie = managerFactory.getVoieManager().search(termeDeLaRecherche);
//            result = ActionSupport.SUCCESS;
//        } else {
//            logger.debug(difficulteMin);
//            logger.debug(difficulteMax);
//            listTopo = managerFactory.getTopoManager().advancedSearchByDifficulty(difficulteMin,difficulteMax,termeDeLaRecherche);
//
//        }

//        return result;
        return ActionSupport.SUCCESS;
    }

    public String doSearchAsync() {
        listTopo = managerFactory.getTopoManager().search("m");
        return ActionSupport.SUCCESS;
    }

    public String doFilter() {
        String result = ActionSupport.SUCCESS;
        try {
            listTopo = managerFactory.getTopoManager().advancedSearchByDifficulty(difficulteMin, difficulteMax, termeDeLaRecherche);
            listSite = managerFactory.getSiteManager().advancedSearchByDifficulty(difficulteMin,difficulteMax,termeDeLaRecherche);
            listSecteur = managerFactory.getSecteurManager().advancedSearchByDifficulty(difficulteMin,difficulteMax,termeDeLaRecherche);
            listVoie = managerFactory.getVoieManager().advancedSearchByDifficulty(difficulteMin,difficulteMax,termeDeLaRecherche);
        } catch (InputMismatchException e) {
            addActionError(e.getMessage());
            result = ActionSupport.ERROR;
        }
        return result;
    }
}
