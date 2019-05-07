package org.emacv.loupgarou.personnages;

import javax.swing.*;

abstract public class Personnage {

    abstract String getIconPath();
    abstract String getName();

    public ImageIcon getImageIcon(){
        return(new ImageIcon(this.getIconPath()));
    }

    @Override
    public String toString(){
        return(this.getName());
    }
}
