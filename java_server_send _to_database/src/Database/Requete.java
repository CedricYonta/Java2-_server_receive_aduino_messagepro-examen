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

   String pulse;
   String nom;
   String date;

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

   public String getDate() {
      return this.date;
   }

   public void setDate(String date) {
      this.date = date; 
   }

   // Method to insert data into the table
   public void Insert() {

      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");// Load the driver class
         c = DriverManager
               .getConnection(this.DB_URL,
                     this.USER, this.PASS);// Create a connection to the database

         c.setAutoCommit(false);// Turn off autocommit mode
         System.out.println("Opened database successfully");

         stmt = c.createStatement(); // Create a statement object

         // SQL query to insert data into the table
         String sql = "INSERT INTO capteur (name, pulse_value, date) "
               + "VALUES ('" + this.nom + "'," + this.pulse + ",'"+ this.date +"');";

         stmt.executeUpdate(sql);// Execute the SQL query

         stmt.close(); // Close the statement
         c.commit(); // Commit the changes
         c.close(); // Close the connection

      } catch (Exception e) {// Catch any exception that may occur
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(0);
      }
      System.out.println("Records created successfully");
   };

}
