package org.emacv.loupgarou.personnages;

import javax.swing.*;

public class LoupGarou extends Personnage {

    private ImageIcon carte;

    public LoupGarou(int idPerso, Personnage suivant) {
        super(idPerso,suivant);
        this.carte = new ImageIcon("loup-garou.png");
    }

    public ImageIcon getCarte() {
        return carte;
    }
}
