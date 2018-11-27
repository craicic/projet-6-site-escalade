package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.RechercheManager;
import com.gg.proj.technical.GenerateurDeDifficulte;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Named;
import java.util.List;

@Named
public class RechercheManagerImpl implements RechercheManager {

    private static final Logger logger = LogManager.getLogger();

    /**
     * Cette méthode pilote la méthode statique afin de récupéré la liste intégrle des difficultés.
     * @return une liste de String
     */
    public List<String> generateList() {
        return GenerateurDeDifficulte.Generateur("1a-","9c+");
    }

}
