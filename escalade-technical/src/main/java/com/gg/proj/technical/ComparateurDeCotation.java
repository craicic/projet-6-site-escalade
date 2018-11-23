package com.gg.proj.technical;

public class ComparateurDeCotation {

    public static String getTheMoreDifficult(String a, String b) {

        char[] tab1 = a.toCharArray();
        char[] tab2 = b.toCharArray();


        if (tab1[0] > tab2[0])
            return a;
        else if (tab1[0] < tab2[0])
            return b;
        else {
            if (tab1[1] > tab2[1])
                return a;
            else if (tab1[1] < tab2[1])
                return b;
        }

        int lenghtTab1 = tab1.length;
        int lenghtTab2 = tab2.length;

        if (lenghtTab1 == 2 && lenghtTab2 == 2)
            return a;

        if (lenghtTab1 > 2) {
            if (lenghtTab2 > 2) {
                if (tab1[2] > tab2[2])
                    return b;
                else
                    return a;
            } else {
                if (tab1[2] == '+')
                    return a;
                else return b;
            }
        } else {
            if (lenghtTab2 > 2) {
                if (tab2[2] == '+')
                    return b;
            }
        }
        return a;
    }
}
