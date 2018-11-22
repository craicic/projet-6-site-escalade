package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.SecteurManager;
import com.gg.proj.consumer.contract.dao.SecteurDao;
import com.gg.proj.model.bean.Secteur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
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
                // todo retirer ce fix de coordonnéesGPS
                model.setCoordonneeX(1.0);
                model.setCoordonneeY(1.0);
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
        model.setCoordonneeX(1.0);
        model.setCoordonneeY(1.0);
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
            if(s.getSiteId().equals(siteId)){
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
}
