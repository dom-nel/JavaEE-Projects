import java.sql.*;
import java.io.*;

public class nelthropeJDBC1
{
   public static void main(String[] args)
   {
      try
      {
         // 1. create the connection to the database
         Class.forName("org.postgresql.Driver");
         Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ClassSchedule", "postgres", "Doughboy33!");
         System.out.println("Connected to the database successfully!");
         // 2. check to see if the database table exists, if so, drop the table
         dropTable(conn);
         
         // 3. build (or rebuild) the ClassSchedule table and add rows
         buildClassScheduleTable(conn);
         
         // 4. display all of the rows of data from the ClassSchedule table
         displayAllRows(conn);
         
         // 5. calculate the total cost of all of the ClassSchedule in the database table
         totalCreditHours(conn);
         // 6. close the connection
         conn.close();
      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
   }//end main method
   
   /*
      dropTable method drops existing ClassSchedule table, in case the database table already exist
   */
   public static void dropTable(Connection conn)
   {
       // message to check for tables
       System.out.println("Checking for existing ClassSchedule table in the ClassSchedule Database...");
       
       try
       {
         // statement object 
         Statement stmt = conn.createStatement();
         
         // execute statement to drop the table 
         //use DROP TABLE IF EXIST to drop a postgres table
         stmt.execute("DROP TABLE IF EXISTS ClassSchedule");
         // print confirmation message that the table was dropped 
         System.out.println("ClassSchedule table dropped");
       }
       catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
   } // end dropTable method
   
   
    // method to build the ClassSchedule table 
   public static void buildClassScheduleTable(Connection conn)
   {
      // message to attempt to build the ClassSchedule table
       System.out.println("Building the ClassSchedule table in the ClassSchedule Database...");
       
       try
       {
         // statement object 
         Statement stmt = conn.createStatement();
         
         // 1. create the table
         /*
            SQL Syntax to create a table:
               CREATE TABLE 'tableName' (fieldName dataType, fieldName dataType(size (if not numerical)), etc)
         */
         stmt.execute("CREATE TABLE ClassSchedule (CourseNumber VARCHAR PRIMARY KEY," +
                     "CourseName VARCHAR, " +
                     "CreditHours INT);");
                     
         // 2. add rows to the table
         /*
            SQL Syntax to insert a row into a table:
            INSERT INTO 'tableName' (fields, fields, etc.) VALUES(fieldValue, fieldValue,etc.)
        */
         stmt.execute("INSERT INTO ClassSchedule (CourseNumber, CourseName, CreditHours) VALUES ('CSC-284', 'Emerging Comp Prog Tech', 3);");
         stmt.execute("INSERT INTO ClassSchedule (CourseNumber, CourseName, CreditHours) VALUES ('CSC-258', 'JAVA Enterprise Programs', 3);");
         stmt.execute("INSERT INTO ClassSchedule (CourseNumber, CourseName, CreditHours) VALUES ('CSC-249', 'Data Structure & Algorithms', 3);");
         stmt.execute("INSERT INTO ClassSchedule (CourseNumber, CourseName, CreditHours) VALUES ('CSC-174', 'Server-Side Javascript', 3);");
         
         // once the rows are inserted into the table, give a successful message
         System.out.println("ClassSchedule table created.");
       }
       catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }


   }// end buildClassScheduleTable method
   
   
    
   // method to display the rows from the table
   public static void displayAllRows(Connection conn)
   {
      // message to attempt to build the IceCream table
       System.out.println("Displaying all rows in the ClassSchedule table in the ClassSchedule Database...");

      try
      {
         
         // statement object 
         Statement stmt = conn.createStatement();
         
         //SQL statement to execute the query
         String sqlStatement = "SELECT * FROM ClassSchedule;";
         
         // Statement to be sent to the DBMS
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         //Display the results of the query
         while(result.next())
         {
                    
                       System.out.println("\nCourse This Semester: \n" +
                                         "   CourseNumber: " + result.getString("CourseNumber") + "\n" +
                                         "   Course Name: " + result.getString("CourseName") + "\n" +
                                         "   Credit Hours: " + result.getInt("CreditHours"));
                                         System.out.println();
                                         
                                       
            
         }
         
         

      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }

   }//end displayAllRows method
   
   

    // method to display the total credit hours
   public static void totalCreditHours(Connection conn)
   {
      // give message for the query
      System.out.print("\nTotal Credit Hours: ");
      
      try
      {
         // statement object 
         Statement stmt = conn.createStatement();
         
         //SQL statement to execute the query
         String sqlStatement = "SELECT SUM(credithours) FROM ClassSchedule;";
         
         //Statement to be sent to the DBMS
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         // display results of the query
         result.next(); //call .next method to get the result from the result set
         System.out.println(result.getInt(1));
      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
   }//end totalCreditHours



   
}// end Class Schedule