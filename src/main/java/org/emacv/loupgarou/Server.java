package org.emacv.loupgarou;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private Socket           socket = null;
    private ServerSocket     server = null;
    private DataInputStream  in     = null;
    private DataOutputStream out    = null;

    List<String> joueurs = new ArrayList<String>();
    boolean nuit;
    boolean loup;
    boolean end;

    public Server(int port) {

        joueurs.add("toto");
        joueurs.add("titi");
        joueurs.add("tata");
        end = false;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            out = new DataOutputStream(socket.getOutputStream());

            String line = "";

            while (!line.equals("Quit") || !end) {
                try {
                    line = in.readUTF();
                    System.out.println(line);

                    tour(line);

                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Server server = new Server(5000);
    }


    private void tour(String line) throws IOException{
        line.toLowerCase();

        if (line.contains("go")){
            nuit = true;
            loup = true;
            out.writeUTF("nuit\nloup");
        }
        if (loup && joueurs.contains(line)){
            String stringOut = "mort."+line+".jour";
            loup = false;
            nuit = false;
            joueurs.remove(line);
            if (joueurs.size() == 1){
                System.out.println("fin");
                stringOut+=".end";
                end = true;
            } else {
                stringOut+=".vote";
            }
            out.writeUTF(stringOut);
        }
        if (!nuit && joueurs.contains(line)){
            String stringOut = "mort."+line+".nuit";
            nuit = true;
            loup = true;
            joueurs.remove(line);
            if (joueurs.size() == 1){
                System.out.println("fin");
                stringOut += ".end";
                end = true;
            } else {
                stringOut+=".loup";
            }
            out.writeUTF(stringOut);
        }
    }
}