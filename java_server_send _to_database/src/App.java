/*
  Titre      : java server front end et back end
  Auteur     : Cedric Yonta
  Date       : 31/03/2023
  Description: receive data from the arduino and insert into database 
  Version    : 0.0.1
*/


// Importation des classes nécessaires pour la communication avec la base de données et la réception des données du client
import Database.*;
import ServerReceive.ServerReceive;

public class App {
  public static void main(String[] args) {
    
  // Instanciation de la classe Requete qui sera utilisée pour insérer les données dans la base de données
    Requete requete = new Requete(); 

     // Création et lancement du thread du serveur
     Thread serverThread = new Thread(() -> {
      ServerReceive.startServer(requete);
  });
  serverThread.start();
  
  // Boucle infinie pour maintenir l'application ouverte
  while (true) {
      try {
          Thread.sleep(1000);// Attendre 1 seconde avant de continuer la boucle 
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }

  }
}
