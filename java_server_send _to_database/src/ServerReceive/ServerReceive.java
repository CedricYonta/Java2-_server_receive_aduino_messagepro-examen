package ServerReceive;

// importation des class et librairies nécessaire
import Database.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerReceive {
 
    // Méthode qui démarre le serveur et prend en paramètre un objet Requete
    /**
     * @param requete
     */
    public static void startServer(Requete requete){

        int port = 8000 ; // le port sur lequel le serveur écoute les connexions

         // Création d'un socket serveur qui écoute les connexions entrantes
       try (ServerSocket serverSocket = new ServerSocket(port)) {

        // Récupération de l'adresse IP du serveur et affichage dans la console
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("Serveur démarré sur l'adresse " + address.getHostAddress() + ", port " + port);
  
        // Boucle infinie pour attendre les connexions entrantes
        while (true) {
          // Attente de la connexion d'un client
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connecté depuis " + clientSocket.getInetAddress().getHostAddress());
  
        // Lecture des données envoyées par le client (dans ce cas, l'Arduino)
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine = in.readLine() ;
         //String inputLine = "Pulse:212,Name:jean,Date:18:30:10" ;

         // Extraction des informations reçues (le nom et le pulse) et enregistrement dans l'objet Requete
          requete.setPulse(inputLine.substring(6,(inputLine.indexOf(",") )));
          int index = inputLine.indexOf(",");
          if (index != -1) {
            inputLine = inputLine.substring(0, index) + inputLine.substring(index + 1);
          }
          requete.setNom(inputLine.substring(((inputLine.indexOf("m")+3 )),(inputLine.indexOf(",") )));
          index = inputLine.indexOf(",");
          if (index != -1) {
            inputLine = inputLine.substring(0, index) + inputLine.substring(index + 1);
          }
          requete.setDate(inputLine.substring((inputLine.indexOf("t")+3),(inputLine.indexOf("t")+11)));

          System.out.println("Pulse : " + requete.getPulse());
          System.out.println("Nom : " + requete.getNom());
          System.out.println("Date : " + requete.getDate());


          // Insertion des informations dans la base de données
          requete.Insert();
  
      }

      } catch (IOException e) {
        System.out.println("Erreur lors de l'exécution du serveur : " + e.getMessage());
      }


        ;
    }

}
