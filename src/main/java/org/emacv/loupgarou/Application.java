package org.emacv.loupgarou;

import lombok.Data;
import org.emacv.loupgarou.personnages.LoupGarou;
import org.emacv.loupgarou.personnages.Personnage;
import org.emacv.loupgarou.personnages.Villageois;

import java.util.ArrayList;
import java.util.Random;

@Data
public class Application {

    private ArrayList<Integer> idJoueursDistribues = new ArrayList<Integer>();
    private ArrayList<Personnage> personnages = new ArrayList<Personnage>();
    private Random rand = new Random();
    private int nbLoups = 2;
    private int nbVillageois = 4;

    public void init(){

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

    public LoupGarou creerLoup(int[] idJoueur) {

        LoupGarou loupGarou = null;
        int deltSize = idJoueursDistribues.size();

        while (idJoueursDistribues.size() == deltSize) {

            int idPerso = idJoueur[rand.nextInt(6)];

            if (!idJoueursDistribues.contains(idPerso)) {

                if (!personnages.isEmpty()) {
                    loupGarou = new LoupGarou(idPerso, personnages.get(personnages.size() - 1));
                    System.out.println(idPerso + " : " + loupGarou.getClass());
                } else {
                    loupGarou = new LoupGarou(idPerso, null);
                    System.out.println(idPerso + " : " + loupGarou.getClass());
                }

                idJoueursDistribues.add(idPerso);
            }
        }

        return loupGarou;
    }

    public Villageois creerVillageois(int[] idJoueur) {

        Villageois villageois = null;
        int deltSize = idJoueursDistribues.size();

        while (idJoueursDistribues.size() == deltSize) {

            int idPerso = idJoueur[rand.nextInt(6)];

            if (!idJoueursDistribues.contains(idPerso)) {

                if (!personnages.isEmpty()) {
                    villageois = new Villageois(idPerso, personnages.get(personnages.size() - 1));
                    System.out.println(idPerso + " : " + villageois.getClass());
                } else {
                    villageois = new Villageois(idPerso, null);
                    System.out.println(idPerso + " : " + villageois.getClass());
                }

                idJoueursDistribues.add(idPerso);
            }
        }

        return villageois;
    }

}
