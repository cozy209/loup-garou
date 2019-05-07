package org.emacv.loupgarou;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.emacv.loupgarou.personnages.*;

import java.util.ArrayList;
import java.util.Collections;

@Slf4j
@Data
public class Application {

    private ArrayList<Client> clients = new ArrayList<Client>();

    private int nbLoups = 2;
    private int nbJoueurs = 6;

    public void run(){
        this.initClients();
        this.setPersonnages();
        this.printClients();

    }

    public void initClients(){
        // Initialisation des clients à la main pour l'instant
        for(Integer i=0; i<nbJoueurs;i++){
            // Pour l'instant le nom et le pseudo sont les mêmes
            this.addClient(i, i.toString());
        }
    }

    public void addClient(Integer id, String pseudo){
        this.clients.add(new Client(id, pseudo));
    }

    public void printClients(){
        for(Client cli: clients){
            log.debug(cli.toString());
        }
    }

    public void setPersonnages(){
        // TODO : A refaire proprement pour pouvoir prendre en compte les autres cartes

        Collections.shuffle(this.clients);

        for(int i=0; i<this.nbLoups; i++){
            this.clients.get(i).setPersonnage(new LoupGarou());
        }
        for(int i=this.nbLoups; i<this.nbJoueurs; i++){
            this.clients.get(i).setPersonnage(new Villageois());
        }

        Collections.shuffle(this.clients);

    }

    public static void main(String[] args) {
        new Application().run();
    }

}
