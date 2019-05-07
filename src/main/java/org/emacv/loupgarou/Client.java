package org.emacv.loupgarou;

import org.emacv.loupgarou.personnages.Personnage;

public class Client {

    private Integer id;
    private String pseudo;
    private Personnage personnage;

    public Client(Integer id, String pseudo) {
        this.id = id;
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.pseudo, this.personnage);
    }

    public void setPersonnage(Personnage personnage){
        this.personnage = personnage;
    }
}
