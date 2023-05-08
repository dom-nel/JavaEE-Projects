import java.util.*;
public class BaseballDriver{
   public static boolean validAge(String age) throws AgeException
   {
        // check for the conditions and throw an Exception
        if(Integer.parseInt(age) < 5 || Integer.parseInt(age) > 15)
        {
            throw new AgeException("Age must be between 5 and 15 years old");
        }     
        
        // if and exception is not thrown, return true
        return true;  
    }
    
     public static boolean validJersey(String jerseyNumber) throws JerseyNumberException
   {
        // check for the conditions and throw an Exception
        if(Integer.parseInt(jerseyNumber) < 0 || Integer.parseInt(jerseyNumber) > 99)
        {
            throw new JerseyNumberException("Jersey Number is invalid");
        }     
        
        // if and exception is not thrown, return true
        return true;  
    }
    
    public static boolean validPosition(String position, String age) throws PositionException
    {
      
        // check for the conditions and throw an Exception
        if(position.length() < 1 || position.length() > 2)
        {
            throw new PositionException("Invalid Position");
        }  
        
        // check the age parmater
        if(Integer.parseInt(age) < 8)
        {
            //tee ball can play any position except for pitcher
            if(!position.equalsIgnoreCase("18") &&
               !position.equalsIgnoreCase("28") &&
               !position.equalsIgnoreCase("38") &&
               !position.equalsIgnoreCase("C") &&
               !position.equalsIgnoreCase("LF") &&
               !position.equalsIgnoreCase("CF") &&
               !position.equalsIgnoreCase("RF") &&
               !position.equalsIgnoreCase("SS")){
               throw new PositionException("Not a valid position for Tee-Ball");
        }
        else
        {
          //all
            if(!position.equalsIgnoreCase("18") &&
               !position.equalsIgnoreCase("28") &&
               !position.equalsIgnoreCase("38") &&
               !position.equalsIgnoreCase("C") &&
               !position.equalsIgnoreCase("LF") &&
               !position.equalsIgnoreCase("CF") &&
               !position.equalsIgnoreCase("RF") &&
               !position.equalsIgnoreCase("SS")&&
               !position.equalsIgnoreCase("P")){
               throw new PositionException("Not a valid position for this league");

        }
        
        }   
        }
        
        // if and exception is not thrown, return true
        return true;  

    }
    
    public static void main(String[] args){
    
      //arrayLists to hold the player for each league
      ArrayList<TeeBallPlayer> TBPlayers = new ArrayList<TeeBallPlayer>();
      ArrayList<LittleLeaguePlayer> LLPlayers = new ArrayList<LittleLeaguePlayer>();
      ArrayList<JuniorVarsityPlayer> JVPlayers = new ArrayList<JuniorVarsityPlayer>();
      
      String name, age, position = null , jerseyNumber = null, repeat = "";
      
      Scanner keyboard = new Scanner(System.in);
      
      do 
      {
         // prompt for name and the age 
         System.out.print("Name: ");
         name = keyboard.nextLine();
         
         try
         {
            System.out.print("Age: ");
            age = keyboard.nextLine();
            if(validAge(age) == true)
            {
               // display the league the player is eligible for 
               if(Integer.parseInt(age) < 8)
               {
                  System.out.println("Player is old enough to play Tee-Ball");
               }
               else if(Integer.parseInt(age) < 13)
               {
                  System.out.println("Player is old enough to play Little League");
               }
               else
               {
                  System.out.println("Player is old enough to play Junior Varsity");
               }
            }
            
           // prompt the use for Jersey Number
            try
         {
            System.out.print("Desired Jersey Number: ");
            jerseyNumber = keyboard.nextLine();
            if(validJersey(jerseyNumber) == true)
            {
               System.out.println("Jersey Number is Valid");
            }
         }catch(JerseyNumberException e) 
         {
            System.out.println(e.getMessage());
         }
         
         // prompt the use for Position
            try
         {
            System.out.print("Desired Position: ");
            position = keyboard.nextLine();
            if(validPosition(position, age) == true)
            {
               System.out.println("Position is Valid");
            }
         }catch(PositionException e) 
         {
            System.out.println(e.getMessage());
         }

                  // add to the appropiate arraylist 
            if(Integer.parseInt(age) < 8)
            {
               TBPlayers.add(new TeeBallPlayer(name, age, jerseyNumber, position));
            }
             else if(Integer.parseInt(age) < 13)
            {
               LLPlayers.add(new LittleLeaguePlayer(name, age, jerseyNumber, position));
            }
            else
            {
               JVPlayers.add(new JuniorVarsityPlayer(name, age, jerseyNumber, position));
            }


         }catch(AgeException e) // catch the age Exception
         {
            System.out.println(e.getMessage());
         }
         
         System.out.print("Would you like to enter another player? (Y/N): ");
         repeat = keyboard.nextLine();
        }while(repeat.equalsIgnoreCase("y"));
        
        //use loops to display the players
        System.out.println("\n\nTee-Ball Players\n");
        for(TeeBallPlayer p : TBPlayers)
        {
         System.out.println(p.display());
        }
        
        System.out.println("\n\nLittle League Players\n");
        for(LittleLeaguePlayer p : LLPlayers)
        {
         System.out.println(p.display());
        }

        
        System.out.println("\n\nJunior Varsity Players\n");
        for(JuniorVarsityPlayer p : JVPlayers)
        {
         System.out.println(p.display());
        }

        
      }
  }
   
