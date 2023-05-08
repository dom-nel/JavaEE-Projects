import java.sql.*;
import java.io.*;

public class nelthropeJDBC2
{
   public static void main(String[] args)
   {
      final String PET = "PET";   
      final String SERVICES = "SERVICES";   
      final String VISITS = "VISITS";   
      try
      {
         // 1. create the connection to the database
         Class.forName("org.postgresql.Driver");
         Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AnimalHospital", "postgres", "Doughboy33!");
         System.out.println("Connected to the database successfully!");
         // 2. check to see if the database table PET, SERVICES, and VISITS exists, if so, drop the tables
         //dropTable(conn, PET);
         //dropTable(conn, SERVICES);
         //dropTable(conn, VISITS);
         
         // 3. build (or rebuild) the PET, SERVICES, and VISITS tables and add rows
         //buildPetTable(conn);
         //buildServicesTable(conn);
         //buildVisitsTable(conn);
         
         // 4. Query 1 and 2
         query1(conn);
         query2(conn);
         // 5. close the connection
         conn.close();
      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
   }//end main method
   
   /*
      dropTable method drops existing AnimalHospital table, in case the database table already exist
   */
   public static void dropTable(Connection conn, String tableName)
   {
       // message to check for tables
       System.out.println("\nChecking for existing " + tableName + " table in the AnimalHospital Database...");
       
       try
       {
         // statement object 
         Statement stmt = conn.createStatement();
         
         // execute statement to drop the table 
         //use DROP TABLE IF EXIST to drop a postgres table
         stmt.execute("DROP TABLE IF EXISTS " + tableName);
         // print confirmation message that the table was dropped 
         System.out.println( tableName + " table dropped");
       }
       catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
   } // end dropTable method
   
    // method to build the PET table 
   public static void buildPetTable(Connection conn)
   {
      // message to attempt to build the PET table
       System.out.println("Building the PET table in the AnimalHospital Database...");
       
       try
       {
         // statement object 
         Statement stmt = conn.createStatement();
         
         // 1. create the table
         /*
            SQL Syntax to create a table:
               CREATE TABLE 'tableName' (fieldName dataType, fieldName dataType(size (if not numerical)), etc)
         */
         stmt.execute("CREATE TABLE PET (petID VARCHAR PRIMARY KEY," +
                     "petName VARCHAR," +
                     "petType VARCHAR," +
                     "petAge INT," +
                     "ownerName VARCHAR);");
                     
         // 2. add rows to the table
         /*
            SQL Syntax to insert a row into a table:
            INSERT INTO 'tableName' (fields, fields, etc.) VALUES(fieldValue, fieldValue,etc.)
        */
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0001', 'Ribbles', 'cat', 3, 'Jimmy');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0002', 'Jerome', 'dog', 7, 'Tony');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0003', 'Rocky', 'dog', 10, 'Tony');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0004', 'Goldie', 'fish', 1, 'Terry');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0005', 'Hammy', 'hamster', 1, 'Jimmy');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0006', 'Swims', 'fish', 2, 'Tony');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0007', 'Star', 'cat', 8, 'Lydia');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0008', 'Party Supplies', 'dog', 7, 'Brenda');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0009', 'Ralph', 'turtle', 2, 'April');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0010', 'Leo', 'turtle', 3, 'April');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0011', 'Donny', 'turtle', 2, 'April');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0012', 'Mikey', 'turtle', 2, 'April');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0013', 'Ace', 'bird', 6, 'Paige');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0014', 'Lizzy', 'lizard', 6, 'Elizabeth');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0015', 'Bishop', 'dog', 8, 'Julius');");
         stmt.execute("INSERT INTO PET (petID, petName, petType, petAge, ownerName) VALUES ('a0016', 'Slizz', 'snake', 6, 'Julius');");
         

         
         // once the rows are inserted into the table, give a successful message
         System.out.println("PET table created.");
       }
       catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }


   }// end buildPetTable method
   
   
     // method to build the SERVICES table 
   public static void buildServicesTable(Connection conn)
   {
      // message to attempt to build the SERVICES table
       System.out.println("Building the SERVICES table in the AnimalHospital Database...");
       
       try
       {
         // statement object 
         Statement stmt = conn.createStatement();
         
         // 1. create the table
         /*
            SQL Syntax to create a table:
               CREATE TABLE 'tableName' (fieldName dataType, fieldName dataType(size (if not numerical)), etc)
         */
         stmt.execute("CREATE TABLE SERVICES (serviceID VARCHAR PRIMARY KEY," +
                     "serviceName VARCHAR," +
                     "serviceCost DECIMAL);");
                     
         // 2. add rows to the table
         /*
            SQL Syntax to insert a row into a table:
            INSERT INTO 'tableName' (fields, fields, etc.) VALUES(fieldValue, fieldValue,etc.)
        */
         stmt.execute("INSERT INTO SERVICES (serviceID, serviceName, serviceCost) VALUES ('s0001', 'Check Up', 25.00);");
         stmt.execute("INSERT INTO SERVICES (serviceID, serviceName, serviceCost) VALUES ('s0002', 'Annual Shots', 50.00);");
         stmt.execute("INSERT INTO SERVICES (serviceID, serviceName, serviceCost) VALUES ('s0003', 'Buy Medicine', 10.00);");
         stmt.execute("INSERT INTO SERVICES (serviceID, serviceName, serviceCost) VALUES ('s0004', 'Minor Surgery', 250.00);");
         stmt.execute("INSERT INTO SERVICES (serviceID, serviceName, serviceCost) VALUES ('s0005', 'Major Surgery', 1000.00);");
         stmt.execute("INSERT INTO SERVICES (serviceID, serviceName, serviceCost) VALUES ('s0006', 'Physical Therapy Session', 25.00);");
         stmt.execute("INSERT INTO SERVICES (serviceID, serviceName, serviceCost) VALUES ('s0007', 'Grooming', 80.00);");
         
         
         // once the rows are inserted into the table, give a successful message
         System.out.println("SERVICES table created.");
       }
       catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }


   }// end buildSERVICESTable method
   
   
   // method to build the VISITS table 
   public static void buildVisitsTable(Connection conn)
   {
      // message to attempt to build the VISITS table
       System.out.println("Building the VISITS table in the AnimalHospital Database...");
       
       try
       {
         // statement object 
         Statement stmt = conn.createStatement();
         
         // 1. create the table
         /*
            SQL Syntax to create a table:
               CREATE TABLE 'tableName' (fieldName dataType, fieldName dataType(size (if not numerical)), etc)
         */
         stmt.execute("CREATE TABLE VISITS (visitID VARCHAR PRIMARY KEY," +
                     "petID VARCHAR," +
                     "serviceID VARCHAR," +
                     "visitDate VARCHAR," +
                     "FOREIGN KEY (petID) REFERENCES PET(petID)," +
                     "FOREIGN KEY (serviceID) REFERENCES SERVICES(serviceID));");
                     
         // 2. add rows to the table
         /*
            SQL Syntax to insert a row into a table:
            INSERT INTO 'tableName' (fields, fields, etc.) VALUES(fieldValue, fieldValue,etc.)
        */
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0001', 'a0002', 's0001', '01-05-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0002', 'a0001', 's0001', '01-06-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0003', 'a0003', 's0001', '01-06-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0004', 'a0004', 's0001', '01-07-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0005', 'a0005', 's0001', '01-07-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0006', 'a0006', 's0001', '01-07-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0007', 'a0007', 's0001', '01-07-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0008', 'a0008', 's0001', '01-07-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0009', 'a0009', 's0001', '01-07-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0010', 'a0005', 's0007', '01-10-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0011', 'a0015', 's0001', '01-09-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0012', 'a0014', 's0001', '01-09-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0013', 'a0015', 's0002', '01-09-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0014', 'a0014', 's0002', '01-09-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0015', 'a0015', 's0004', '01-22-2022');");
         stmt.execute("INSERT INTO VISITS (visitID, petID, serviceID, visitDate) VALUES  ('v0016', 'a0014', 's0005', '01-24-2022');");
         
         
         // once the rows are inserted into the table, give a successful message
         System.out.println("VISITS  table created.");
       }
       catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }


   }// end buildVisitsTable method


   // method to display query1 results
   public static void query1(Connection conn)
   {
      // message to attempt to build the AnimalHospital table
       System.out.println("\nDisplaying Query1 results: ");

      try
      {
         
         // statement object 
         Statement stmt = conn.createStatement();
         
         //SQL statement to execute the query
         String sqlStatement = "SELECT pet.petName, COUNT(services.serviceID)" +
                              "FROM PET " +
                              "JOIN VISITS " +
                              "ON pet.petID = visits.petID " +
                              "JOIN SERVICES " +
                              "ON services.serviceID = visits.serviceID " +
                              "GROUP BY pet.petname " +
                              "ORDER BY COUNT(services.serviceID) DESC " +
                              "LIMIT 3;";
         
         // Statement to be sent to the DBMS
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         //Display the results of the query
         while(result.next())
         {
                    System.out.println(result.getString("petName") + " " + result.getInt("count")); 
            
         }
         
         

      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }

   }//end query1
   
   // method to display query2 results
   public static void query2(Connection conn)
   {
      // message to attempt to build the AnimalHospital table
       System.out.println("\nDisplaying Query2 results: ");

      try
      {
         
         // statement object 
         Statement stmt = conn.createStatement();
         
         //SQL statement to execute the query
         String sqlStatement = "SELECT pet.petName, SUM(services.serviceCost)" +
                              "FROM PET " +
                              "JOIN VISITS " +
                              "ON pet.petID = visits.petID " +
                              "JOIN SERVICES " +
                              "ON services.serviceID = visits.serviceID " +
                              "GROUP BY pet.petname " +
                              "ORDER BY SUM(services.serviceCost) DESC " +
                              "LIMIT 3;";
         
         // Statement to be sent to the DBMS
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         //Display the results of the query
         while(result.next())
         {
                    System.out.printf("%s %.2f \n", result.getString("petName"), result.getDouble("sum"));
                                
         }
         
         

      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }

   }//end query1



   
   }// end JDBC2
