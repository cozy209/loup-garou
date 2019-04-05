package org.emacv.loupgarou.personnages;

import javax.swing.*;

public class Villageois extends Personnage {

     private ImageIcon carte;

    public Villageois(int idPerso, Personnage suivant) {
        super(idPerso,suivant);
        this.carte = new ImageIcon("villageois.png");
    }

    public ImageIcon getCarte() {
        return carte;
    }
}
