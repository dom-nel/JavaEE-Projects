import ja.util.*;
import java.io.*;
import java.util.ArrayList;
import java.sql.*;

public class NelthropeDriver
{
   public static void main(String[] args) throws IOException
   {
       //Creates char variables
       char keepGoing;
      
      
       do {    
               //Creates string variables
               String venueName, state, city, teamName, sport, league;
               
               //Creates int variables
               int maxCapacity, yearOpened, attendance, option;
                     
               //read from a file
               File file = new File("IndoorArenasTwo.txt");
               
               //creates a scanner object with the file object as the argument
               Scanner inputFile = new Scanner(file);
               
               //creates a scanner object to gather users input
               Scanner keyboard = new Scanner(System.in);
               
               //gathers the users first and last name
               System.out.print("Select an option from the following: ");
               
               //Gathers input for the option
               System.out.print("    \n    1. Build / Rebuild Arena Table" +
                          "\n    2. Display all of the Arena info in the Arena Table" +
                          "\n    3. Display all of the Arena info for Basketball Tenants" +
                          "\n    4. Display the average capacity for all Arenas" +
                          "\n    5. Display the Venue and Year Opened info for all Arenas Opened after 2000 in ascending order by year" +
                          "\n    6. Display the average capacity for all Arenas" +
                          "\n    7. Exit");
               System.out.print("\n          Enter your choice (1-7): ");
               option = keyboard.nextInt();

                while(option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7) //validate the input
                {
                     //Gathers input for the option
                     System.out.print("    \n    1. Build / Rebuild Arena Table" +
                             "\n    2. Display all of the Arena info in the Arena Table" +
                             "\n    3. Display all of the Arena info for Basketball Tenants" +
                             "\n    4. Display the average capacity for all Arenas" +
                             "\n    5. Display the Venue and Year Opened info for all Arenas Opened after 2000 in ascending order by year" +
                             "\n    6. Display the average capacity for all Arenas" +
                             "\n    7. Exit");
                     System.out.print("\n              Enter your choice (1-7): ");
                     option = keyboard.nextInt();
                }

               
                try
               {
                     // 1. create the connection to the database
                     Class.forName("org.postgresql.Driver");
                     Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ArenasDB", "postgres", "Doughboy33!");
                                          
                     
                    
                     
                     // statement object 
                     Statement stmt = conn.createStatement();

                     //use DROP TABLE IF EXIST to drop a postgres table
                     stmt.execute("DROP TABLE IF EXISTS ArenasFromProject2");
                     
                     
                     
                     // statement object 
                     Statement stmt2 = conn.createStatement();
                     
                     /*
                       SQL Syntax to create a table:
                      */
                     stmt2.execute( "CREATE TABLE ArenasFromProject2 (Venue CHAR(45) PRIMARY KEY," +
                           "City CHAR(15), " +
                           "State CHAR(15), " +
                           "MaxCapacity INT, " +
                           "YearOpened INT, " +
                           "Attendance INT, " +
                           "TeamName CHAR(30), " +
                           "Sport CHAR(10), " +
                           "League CHAR(15));");
                           
                           
                     PreparedStatement stmt3 = conn.prepareStatement("INSERT INTO ArenasFromProject2 (Venue, City, State, MaxCapacity, YearOpened, Attendance, TeamName, Sport, League) values(?,?,?,?,?,?,?,?,?)");
   
                        
                      

                     while(inputFile.hasNext())
                           {
                              
                              //Initializes the variables that will go inside the tenant and arena objects       
                              venueName = inputFile.nextLine();
                              city = inputFile.nextLine();
                              state = inputFile.nextLine();
                              maxCapacity = inputFile.nextInt();
                              yearOpened = inputFile.nextInt();
                              if (inputFile.hasNext())
                                  inputFile.nextLine();
                              teamName = inputFile.nextLine();
                              sport = inputFile.nextLine();
                              league = inputFile.nextLine();
                              attendance = inputFile.nextInt();
                              if (inputFile.hasNext())
                                  inputFile.nextLine();
                                  inputFile.nextLine();
                              
                              
                              
                                 
                              //creates a Tenant object
                              Tenant team = new Tenant(teamName, sport, league);
                              
                              //creates a Arena object
                              Arena arena = new Arena(venueName, city, state, maxCapacity, yearOpened, attendance, team);
                              
                              //calls the add rows to table function
                              //addRowsToArenasTable( conn, arena.getVenueName(), arena.getCity(), arena.getState(), arena.getMaxCapacity(),  arena.getYearOpened(), arena.getAttendance(), arena.getTenant().getTeamName(),  arena.getTenant().getSport(),  arena.getTenant().getLeague());
                             
                             // statement3 object 
                             //PreparedStatement stmt3 = conn.prepareStatement("INSERT INTO ArenasFromProject2 (Venue, City, State, MaxCapacity, YearOpened, Attendance, TeamName, Sport, League) values(?,?,?,?,?,?,?,?,?)");
                             stmt3.setString(1, arena.getVenueName());
                             stmt3.setString(2, arena.getCity());
                             stmt3.setString(3, arena.getState());
                             stmt3.setInt(4, arena.getMaxCapacity());
                             stmt3.setInt(5, arena.getYearOpened());
                             stmt3.setInt(6, arena.getAttendance());
                             stmt3.setString(7, arena.getTenant().getTeamName());
                             stmt3.setString(8, arena.getTenant().getSport());
                             stmt3.setString(9, arena.getTenant().getLeague());
                             stmt3.executeUpdate();
                              
                             
                              
                            }//while loop end 
                            
                     //menu option 1-7       
                     if(option == 1)
                      {
                        optionOne(conn);
                      }
                     else if(option == 2)
                      {
                        optionTwo(conn);
                      }
                      else if(option == 3)
                      {
                        optionThree(conn);
                      }
                      else if(option == 4)
                      {
                        optionFour(conn);
                      }
                      else if(option == 5)
                      {
                        optionFive(conn);
                      }
                      else if(option == 6)
                      {
                        optionSix(conn);
                      }
                      else
                      { 
                        //4.close the connection
                        conn.close();
                        break;
                      }
               }
               catch(Exception e)
               {
                  e.printStackTrace();
                  System.err.println(e.getClass().getName() + ": " + e.getMessage());
               }
      
        //Ask the user if the user would like to enter another bill
       System.out.print("\nWould you like to make another selection? (y/yes to continue, anything else to exit): ");
       System.out.println();
       
       keepGoing = keyboard.next().toUpperCase().charAt(0);
       
       }
      while(keepGoing == 'Y');
 
        
         
       
  }//main method end    
     
   
   
   // method that checks if table exist, drop table if exist and creates table 
   public static void optionOne(Connection conn)
   {
   
       
       try
       {
         //Creates string variables
               String venueName, state, city, teamName, sport, league;
               
               //Creates int variables
               int maxCapacity, yearOpened, attendance, option;
                     
               //read from a file
               File file = new File("IndoorArenasTwo.txt");
               
               //creates a scanner object with the file object as the argument
               Scanner inputFile = new Scanner(file);
               
               //creates a scanner object to gather users input
               Scanner keyboard = new Scanner(System.in);

         // statement object 
         Statement stmt = conn.createStatement();
         
          
         // message to check for tables
         System.out.println("Checking for existing tables.");
         
         //use DROP TABLE IF EXIST to drop a postgres table
         stmt.execute("DROP TABLE IF EXISTS Arenas");
         
         // print confirmation message that the table was dropped 
         System.out.println("Arenas table dropped.");
         
         
         // statement object 
         Statement stmt2 = conn.createStatement();
          
          
         System.out.println("ArenasFromProject2 table created");            
         /*
         SQL Syntax to create a table:
         */
         stmt2.execute( "CREATE TABLE ArenasFromProject2 (Venue CHAR(45) PRIMARY KEY," +
                      "City CHAR(15), " +
                      "State CHAR(15), " +
                      "MaxCapacity INT, " +
                      "YearOpened INT, " +
                      "Attendance INT, " +
                      "TeamName CHAR(30), " +
                      "Sport CHAR(10), " +
                      "League CHAR(15));");
                           
                           
        PreparedStatement stmt3 = conn.prepareStatement("INSERT INTO ArenasFromProject2 (Venue, City, State, MaxCapacity, YearOpened, Attendance, TeamName, Sport, League) values(?,?,?,?,?,?,?,?,?)");
   
                        
                      

        while(inputFile.hasNext())
        {
                              
             //Initializes the variables that will go inside the tenant and arena objects       
             venueName = inputFile.nextLine();
             city = inputFile.nextLine();
             state = inputFile.nextLine();
             maxCapacity = inputFile.nextInt();
             yearOpened = inputFile.nextInt();
             if (inputFile.hasNext())
                inputFile.nextLine();
                teamName = inputFile.nextLine();
                sport = inputFile.nextLine();
                league = inputFile.nextLine();
                attendance = inputFile.nextInt();
             if (inputFile.hasNext())
                 inputFile.nextLine();
                 inputFile.nextLine();
                              
                              
                              
         //creates a Tenant object
         Tenant team = new Tenant(teamName, sport, league);
                              
         //creates a Arena object
         Arena arena = new Arena(venueName, city, state, maxCapacity, yearOpened, attendance, team);
                              
         //calls the add rows to table function
         //addRowsToArenasTable( conn, arena.getVenueName(), arena.getCity(), arena.getState(), arena.getMaxCapacity(),  arena.getYearOpened(), arena.getAttendance(), arena.getTenant().getTeamName(),  arena.getTenant().getSport(),  arena.getTenant().getLeague());
         stmt3.setString(1, arena.getVenueName());
         stmt3.setString(2, arena.getCity());
         stmt3.setString(3, arena.getState());
         stmt3.setInt(4, arena.getMaxCapacity());
         stmt3.setInt(5, arena.getYearOpened());
         stmt3.setInt(6, arena.getAttendance());
         stmt3.setString(7, arena.getTenant().getTeamName());
         stmt3.setString(8, arena.getTenant().getSport());
         stmt3.setString(9, arena.getTenant().getLeague());
         stmt3.executeUpdate();
                              
                    
                              
      }//while loop end 

   }
       catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }

   
   }//option one end
   
   
      
      
   
       // method to display the rows from the table
   public static void optionTwo(Connection conn)
   {
      
    

      try
      {
         
         // statement object 
         Statement stmt = conn.createStatement();
         
         //SQL statement to execute the query
         String sqlStatement = "SELECT * FROM ArenasFromProject2;";
         
         // Statement to be sent to the DBMS
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         System.out.println("\nAll Arena Info Query: \n");
         
         
         //Display the results of the query
         while (result.next())
         {          
         
            
            System.out.println(result.getString("Venue") + "      " +
                              result.getString("city") + "   " +
                              result.getString("State") +"  " + 
                              result.getInt("MaxCapacity") + "  " +
                              result.getInt("YearOpened") + "   " +
                              result.getString("TeamName") + "  " + 
                              result.getString("Sport") + "  " +
                              result.getString("League") + "     " +
                              result.getInt("Attendance"));
                              
            
            
            
           
            
            
            
                     
         }
         
         

      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }

   }//end displayAllRows method
   
    // method to display Basketball Tenants
   public static void optionThree(Connection conn)
   {
       
      try
      {
         
         // statement object 
         Statement stmt = conn.createStatement();
         
         //SQL statement to execute the query
         String sqlStatement = "SELECT * FROM ArenasFromProject2 WHERE Sport = 'Basketball';";
         
         // Statement to be sent to the DBMS
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         System.out.println("\nBasketball Arena Query: \n");
         
         //Display the results of the query
         while (result.next())
         {          
         
            
            System.out.println(result.getString("Venue") + "      " +
                              result.getString("city") + "   " +
                              result.getString("State") +"  " + 
                              result.getInt("MaxCapacity") + "  " +
                              result.getInt("YearOpened") + "   " +
                              result.getString("TeamName") + "  " + 
                              result.getString("Sport") + "  " +
                              result.getString("League") + "     " +
                              result.getInt("Attendance"));
                              
            
            
            
           
            
            
            
                     
         }
         
         

      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }
   }//end displayBasketballTenants method
   
    // method to display average capacity
   public static void optionFour(Connection conn)
   {
      
    

      try
      {
         
         // statement object 
         Statement stmt = conn.createStatement();
         
         //SQL statement to execute the query
         String sqlStatement = "SELECT avg(maxcapacity) as average FROM ArenasFromProject2;";

         
         // Statement to be sent to the DBMS
         ResultSet result = stmt.executeQuery(sqlStatement);
         
                 
         //Display the results of the query
         while (result.next())
         {          
         
            
            System.out.println("Average Arena Capacity: " + result.getInt("average"));
                              
            
            
            
           
            
            
            
                     
         }
         
         

      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }

   }//end displayAverageCapacity method
   
    // method to display the venue and yearopened for all arenas opened after 2000
   public static void optionFive(Connection conn)
   {
      
    

      try
      {
         
         // statement object 
         Statement stmt = conn.createStatement();
         
         //SQL statement to execute the query
         String sqlStatement = "SELECT Venue, YearOpened FROM ArenasFromProject2 WHERE yearopened > 2000 GROUP BY venue ORDER BY  yearopened asc, venue asc;";

         
         // Statement to be sent to the DBMS
         ResultSet result = stmt.executeQuery(sqlStatement);
         
                 
         //Display the results of the query
         while (result.next())
         {          
         
            
            System.out.println(result.getString("venue") + "     "  + result.getInt("yearopened"));
                              
            
            
            
           
            
            
            
                     
         }
         
         

      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }

   }//end displayVenueAndArenas method
   
   // method to display California Arena Attendance 
   public static void optionSix(Connection conn)
   {
      
    

      try
      {
         
         // statement object 
         Statement stmt = conn.createStatement();
         
         //SQL statement to execute the query
         String sqlStatement = "SELECT sum(attendance) as caliSum FROM ArenasFromProject2 WHERE state = 'California';";

         
         // Statement to be sent to the DBMS
         ResultSet result = stmt.executeQuery(sqlStatement);
         
                 
         //Display the results of the query
         while (result.next())
         {          
         
            
            System.out.println("California Arena Attendance: " + result.getInt("caliSum"));
                              
            
            
            
           
            
            
            
                     
         }
         
         

      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
      }

   }//end displayAverageCapacity method




   
}//public calls nelthrope driver end

   

     
           
         
      
  

