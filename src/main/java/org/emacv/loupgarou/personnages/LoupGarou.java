package org.emacv.loupgarou.personnages;

import javax.swing.*;

public class LoupGarou extends Personnage {

    // Attribute hidding, à voir pour faire ça plus propre
    // ça devrait etre des attributs de classe ?
    public String getName(){
        return("Loup-Garou");
    }

    public String getIconPath(){
        return("loup-garou.png");
    }
}
