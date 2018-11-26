package com.gg.proj.technical;

import java.util.ArrayList;
import java.util.List;

public class GenerateurDeDifficulte {

    public static final String[] difficultes = new String[]{
            "1a-", "1a", "1a+", "1b-", "1b", "1b+", "1c-", "1c", "1c+",
            "2a-", "2a", "2a+", "2b-", "2b", "2b+", "2c-", "2c", "2c+",
            "3a-", "3a", "3a+", "3b-", "3b", "3b+", "3c-", "3c", "3c+",
            "4a-", "4a", "4a+", "4b-", "4b", "4b+", "4c-", "4c", "4c+",
            "5a-", "5a", "5a+", "5b-", "5b", "5b+", "5c-", "5c", "5c+",
            "6a-", "6a", "6a+", "6b-", "6b", "6b+", "6c-", "6c", "6c+",
            "7a-", "7a", "7a+", "7b-", "7b", "7b+", "7c-", "7c", "7c+",
            "8a-", "8a", "8a+", "8b-", "8b", "8b+", "8c-", "8c", "8c+",
            "9a-", "9a", "9a+", "9b-", "9b", "9b+", "9c-", "9c", "9c+"
    };

    public static List<String> Generateur(String difficulteMin, String difficulteMax) {

        boolean write = false;
        List<String> listDifficultes = new ArrayList<>();

//        for (int i = 0; difficultes[i].equals(difficulteMax); i++) {
//            if(difficultes[i].equals(difficulteMin))
//                write = true;
//            if(write){
//                listDifficultes.add(difficultes[i]);
//            }
//        }

        int j = 0;

        for (int i = 0; difficultes[i].equals(difficulteMin); i++) {
            j = i;
        }

        for (int k = j; difficultes[k].equals(difficulteMax); k++) {
            listDifficultes.add(difficultes[k + 1]);
        }
        return listDifficultes;
    }
}
