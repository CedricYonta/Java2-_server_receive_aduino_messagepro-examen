package Database;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

public class Requete {

    // ID
    final String USER = "postgres";
    final String PASS = "cedric";
    final String DB_URL = "jdbc:postgresql://localhost:5432/dvdrental";
    
    String pulse ;
    String nom ;
    //String date = Now();

    public Requete() {
    };


   public String getPulse() {
      return this.pulse;
   }

   public void setPulse(String pulse) {
      this.pulse = pulse;
   }

   public String getNom() {
      return this.nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }


    /*public String decryptage( String message){

      
    };*/

    //String url, String user, String pass
    public void Insert() {

        
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection(this.DB_URL,
           this.USER, this.PASS);
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO capteur (name, pulse_value, date) "
         + "VALUES ('" + this.nom + "'," + this.pulse +", Now());";

         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
    };

    /*public void select(){
        
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/dvdrental",
            "postgres", "cedric");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT * FROM capteur" );
         while ( rs.next() ) {
            int id = rs.getInt("user_id");
            String  name = rs.getString("keyName");
            float value = rs.getFloat("KeyValue");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "VALUE= " + value);
            System.out.println();
         }
         rs.close();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Operation done successfully");
    };*/
    
}
