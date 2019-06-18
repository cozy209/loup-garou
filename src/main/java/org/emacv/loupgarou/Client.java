package org.emacv.loupgarou;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Client {
    private Socket           socket = null;
    private DataInputStream  input  = null;
    private DataInputStream  in  = null;
    private DataOutputStream out    = null;

    private String       carte  = "loup";
    private String       joueur = "toto";
    private List<String> persos = new ArrayList<String>();

    public Client(String address, int port) {

        persos.add("toto");
        persos.add("titi");
        persos.add("tata");

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            //
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        // string to read message from input
        String lineInput = "";
        String line = "";

        // keep reading until "Over" is input
        while (!lineInput.equals("Quit") || !line.contains("end")) {
            try {
                lineInput = input.readLine();
                out.writeUTF(lineInput);

                line = in.readUTF();

                tour(line,lineInput);

            } catch (IOException i) {
                System.out.println(i);
            }
        }

        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Client client = new Client("127.0.0.1", 5000);
    }

    private void loup(){
        if (carte.equals("loup")){
            System.out.println("Entrez le nom du villageois a tuer "+persos.toString());
        }
    }
    private void vote(){
        System.out.println("Qui suspectez vous? "+persos.toString());
    }

    private void nuit(){
        System.out.println("Mode nuit activé");
    }
    private void jour(){
        System.out.println("Mode jour activé");
    }
    private void mort(String line){
        String[] tab = line.split(Pattern.quote("."));
        String mort = tab[1];
        if (persos.contains(mort)) {
            System.out.println(mort + " est mort, tué par les loups");
            persos.remove(mort);
        }
    }

    private void tour(String line,String lineInput) throws IOException{
        line.toLowerCase();

        if (line.contains("nuit")){
            if (line.contains("mort")){
                mort(line);
            }
            nuit();
        }
        if (line.contains("jour")){
            jour();
            if (line.contains("mort")){
                mort(line);
            }
        }

        if (line.contains("loup")){
            loup();
        }

        if (line.contains("vote")){
            vote();
        }

        if (persos.contains(lineInput.toLowerCase())){
            out.writeUTF(lineInput);
        }

        if (line.contains("end")){
            System.out.println(persos.get(0)+" a gagné");
            System.exit(0);
        }
    }
}