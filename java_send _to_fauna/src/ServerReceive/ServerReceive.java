package ServerReceive;

import Database.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerReceive {
 
  String inputLine ;

    public void startServer(){

        int port = 1233; // le port sur lequel le serveur écoute les connexions

       try (ServerSocket serverSocket = new ServerSocket(port)) {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("Serveur démarré sur l'adresse " + address.getHostAddress() + ", port " + port);
  
        /*// Attente de la connexion d'un client
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connecté depuis " + clientSocket.getInetAddress().getHostAddress());
  
        // Lecture des données envoyées par le client (dans ce cas, l'Arduino)
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //this.inputLine = in.readLine() ;*/

        this.inputLine = "Pulse:212, Name:jean" ;
  
      } catch (IOException e) {
        System.out.println("Erreur lors de l'exécution du serveur : " + e.getMessage());
      }


        ;
    }


  public String getInputLine() {
    return this.inputLine;
  }


    
}
