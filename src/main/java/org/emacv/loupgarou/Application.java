package org.emacv.loupgarou;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.emacv.loupgarou.personnages.LoupGarou;
import org.emacv.loupgarou.personnages.Personnage;
import org.emacv.loupgarou.personnages.Villageois;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
@Data
public class Application {
// Bonjour
    private static ArrayList<Integer> idJoueursDistribues = new ArrayList<Integer>();
    private static ArrayList<Personnage> personnages = new ArrayList<Personnage>();
    private static Random rand = new Random();
    private static int nbLoups = 2;
    private static int nbVillageois = 4;

    public static void init(){

        int[] idJoueur = {1,2,3,4,5,6};

        for (int i = 0; i < nbLoups; i++) {
            personnages.add(creerLoup(idJoueur));
        }
        for (int i = 0; i < nbVillageois; i++) {
            personnages.add(creerVillageois(idJoueur));
        }

        for (Personnage personnage: personnages) {
            log.info(""+personnage.getClass());
        }

    }

    public static LoupGarou creerLoup(int[] idJoueur) {

        LoupGarou loupGarou = null;
        int deltSize = idJoueursDistribues.size();

        while (idJoueursDistribues.size() == deltSize) {

            int idPerso = idJoueur[rand.nextInt(6)];

            if (!idJoueursDistribues.contains(idPerso)) {

                if (!personnages.isEmpty()) {
                    loupGarou = new LoupGarou(idPerso, personnages.get(personnages.size() - 1));
                    log.info(idPerso + " : " + loupGarou.getClass());
                } else {
                    loupGarou = new LoupGarou(idPerso, null);
                    log.info(idPerso + " : " + loupGarou.getClass());
                }

                idJoueursDistribues.add(idPerso);
            }
        }

        return loupGarou;
    }

    public static Villageois creerVillageois(int[] idJoueur) {

        Villageois villageois = null;
        int deltSize = idJoueursDistribues.size();

        while (idJoueursDistribues.size() == deltSize) {

            int idPerso = idJoueur[rand.nextInt(6)];

            if (!idJoueursDistribues.contains(idPerso)) {

                if (!personnages.isEmpty()) {
                    villageois = new Villageois(idPerso, personnages.get(personnages.size() - 1));
                    log.info(idPerso + " : " + villageois.getClass());
                } else {
                    villageois = new Villageois(idPerso, null);
                    log.info(idPerso + " : " + villageois.getClass());
                }

                idJoueursDistribues.add(idPerso);
            }
        }

        return villageois;
    }

    public static void main(String[] args) {
        init();
    }

}
