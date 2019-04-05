package org.emacv.loupgarou.personnages;


import javax.swing.*;

public class Personnage {

    private Personnage suivant;
    private int idPerso;

    public Personnage(int idPerso, Personnage suivant) {
        this.idPerso = idPerso;
        this.suivant = suivant;
    }
}
