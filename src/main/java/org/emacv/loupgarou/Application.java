package org.emacv.loupgarou;

import org.emacv.loupgarou.personnages.LoupGarou;
import org.emacv.loupgarou.personnages.Personnage;
import org.emacv.loupgarou.personnages.Villageois;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;


public class Application {

    private static ArrayList<String> idJoueursDistribues = new ArrayList<String>();
    private static ArrayList<Personnage> personnages = new ArrayList<Personnage>();
    private static Random rand = new Random();
    private static int nbLoups = 2;
    private static int nbVillageois = 4;

    public static void main(String[] args) {
        init();
    }

    private static void init(){

        int[] idJoueur = {1,2,3,4,5,6};

        for (int i = 0; i < nbLoups; i++) {
            personnages.add(creerLoup(idJoueur));
        }
        for (int i = 0; i < nbVillageois; i++) {
            personnages.add(creerVillageois(idJoueur));
        }

        for (Personnage personnage: personnages) {
            System.out.println(personnage.getClass());
        }

    }

    private static LoupGarou creerLoup(int[] idJoueur) {

        LoupGarou loupGarou = null;
        int deltSize = idJoueursDistribues.size();

        while (idJoueursDistribues.size() == deltSize) {

            int idPerso = idJoueur[rand.nextInt(6)];

            if (!idJoueursDistribues.contains(idPerso + "")) {

                if (!personnages.isEmpty()) {
                    loupGarou = new LoupGarou(idPerso, personnages.get(personnages.size() - 1));
                    System.out.println(idPerso + " : " + loupGarou.getClass());
                } else {
                    loupGarou = new LoupGarou(idPerso, null);
                    System.out.println(idPerso + " : " + loupGarou.getClass());
                }

                idJoueursDistribues.add(idPerso + "");
            }
        }

        return loupGarou;
    }

    private static Villageois creerVillageois(int[] idJoueur) {

        Villageois villageois = null;
        int deltSize = idJoueursDistribues.size();

        while (idJoueursDistribues.size() == deltSize) {

            int idPerso = idJoueur[rand.nextInt(6)];

            if (!idJoueursDistribues.contains(idPerso + "")) {

                if (!personnages.isEmpty()) {
                    villageois = new Villageois(idPerso, personnages.get(personnages.size() - 1));
                    System.out.println(idPerso + " : " + villageois.getClass());
                } else {
                    villageois = new Villageois(idPerso, null);
                    System.out.println(idPerso + " : " + villageois.getClass());
                }

                idJoueursDistribues.add(idPerso + "");
            }
        }

        return villageois;
    }

}
