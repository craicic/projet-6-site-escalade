package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.SecteurManager;
import com.gg.proj.consumer.contract.dao.SecteurDao;
import com.gg.proj.model.bean.Secteur;
import com.gg.proj.technical.GenerateurDeDifficulte;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@Named
public class SecteurManagerImpl implements SecteurManager {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    SecteurDao secteurDao;

    @Override
    @Transactional
    public void create(Secteur model) {
        logger.debug("Entrée dans la méthode create");
        // On vérifie que le model contienne bien l'id d'un site
        if (model.getSiteId() != null) {
            // puis on vérifie que getNom soit non null
            if (model.getNom() != null) {
                secteurDao.create(model);
            } else
                logger.warn("Secteur doit posséder un nom");
        } else
            logger.warn("Secteur doit être lié à un site par siteId");
    }

    @Override
    @Transactional
    public void create(Secteur secteur, Integer siteId) {
        logger.debug("Entrée dans la méthode create surchargée par siteId : " + siteId);
        secteur.setSiteId(siteId);
        secteurDao.create(secteur);
    }

    @Override
    public Secteur get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + id);
        return secteurDao.get(id);
    }

    @Override
    public List<Secteur> list() {
        logger.debug("Entrée dans la méthode list");
        return secteurDao.list();
    }

    @Override
    @Transactional
    public void update(Secteur model) {
        logger.debug("Entrée dans la méthode update");
        secteurDao.update(model);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode delete avec l'id " + id);
        secteurDao.delete(id);
    }

    /**
     * Solicite la Dao pour recherche de la liste des secteurs
     *
     * @param termeDeLaRecherche
     * @return une liste de secteur correspondant.
     */
    @Override
    @Transactional
    public List<Secteur> search(String termeDeLaRecherche) {

        logger.debug("Entrée dans la méthode search avec le terme de recherche :" + termeDeLaRecherche);
        return secteurDao.search(termeDeLaRecherche);
    }

    /**
     * Solicite la dao pour récupération de tout les secteur lié au site d'id siteId
     *
     * @param siteId
     * @return
     */
    @Override
    @Transactional
    public List<Secteur> listLinkedSecteurBySiteId(Integer siteId) {
        logger.debug("Entrée dans la méthode listLinkedSecteurBySiteId avec le siteId : " + siteId);
        List<Secteur> listSecteur = secteurDao.list();
        List<Secteur> listSecteurLinked = new ArrayList<Secteur>();
        for (Secteur s : listSecteur) {
            if (s.getSiteId().equals(siteId)) {
                listSecteurLinked.add(s);
            }
        }
        return listSecteurLinked;
    }

    /**
     * Solicite la dao pour récupération d'un secteur par voieId
     *
     * @param voieId
     * @return un object Secteur
     */
    @Override
    @Transactional
    public Secteur getLinkedSecteurByVoieId(Integer voieId) {
        logger.debug("Entrée dans la méthode getLinkedSecteurByVoieId avec le secteurId " + voieId);
        return secteurDao.getSecteurByVoieId(voieId);
    }

    /**
     * Cette fonction reçoit deux difficultés de grimpe, elle génère une liste des difficultés intermédiaires et envoit
     * la liste à la dao secteurDao pour traitement.
     *
     * @param minDiff la difficulté minimale à rechercher
     * @param maxDiff la difficulté maximale à rechercher
     * @return un liste des secteurs.
     */
    @Override
    @Transactional
    public List<Secteur> advancedSearchByDifficulty(String minDiff, String maxDiff, String termeDeLaRecherche) throws InputMismatchException {
        logger.debug("Entrée dans la méthode advancedSearchByDifficulty avec minDiff : " + minDiff + " et maxDiff : " + maxDiff);

        if (GenerateurDeDifficulte.isOrdinate(minDiff, maxDiff)) {
            List<Secteur> listRetrievedSecteur = secteurDao.search(termeDeLaRecherche);
            if (!listRetrievedSecteur.isEmpty()) {
                List<Integer> listSecteurId = new ArrayList<>();
                for (Secteur t : listRetrievedSecteur) {
                    listSecteurId.add(t.getId());
                }
                listRetrievedSecteur = secteurDao.listSecteurByDifficulty(GenerateurDeDifficulte.Generateur(minDiff, maxDiff), listSecteurId);
            }
            return listRetrievedSecteur;
        } else {
            throw new InputMismatchException("La cotation max doit être supérieur à la cotation min");
        }
    }

    // todo Javadoc
    @Override
    @Transactional
    public Integer getId(Secteur secteur) {
        return secteurDao.getId(secteur);
    }
}
