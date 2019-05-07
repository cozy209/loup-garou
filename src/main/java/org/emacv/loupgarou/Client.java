package org.emacv.loupgarou;

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
        return String.format("%s -> %s", this.pseudo, this.card);
    }

    public void setCard(Card card){
        this.card = card;
    }
}
