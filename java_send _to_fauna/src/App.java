
import Database.*;
import ServerReceive.ServerReceive;


public class App {
  public static void main(String[] args) {
    
    String message;
    Requete requete = new Requete(); 
    ServerReceive server = new ServerReceive();


    server.startServer();
    message = server.getInputLine();

      //message = "Pulse:210, Name:jean" ;
     //System.out.println(message);

     // Décryptage du message
      //String[] parts = inputLine.split(", ");
      String[] parts = message.split(", ");
      requete.setPulse(parts[0].substring(6)); 
      requete.setNom(parts[1].substring(5)); 
      System.out.println("Pulse: " + requete.getPulse());
      System.out.println("Name: " + requete.getNom());
      requete.Insert();

    

  }
}
