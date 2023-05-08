public class Tenant
{
   //private fields for the Tenant class
   private String teamName;
   private String sport;
   private String league;
   
   
   /**
      No-arg constructor
   **/
   public Tenant()
   {
      teamName = "Detroit Pistons";
      sport = "Basketball";
      league = "NBA";
   }
   
   /**
      Constructor that accepts arguments
      @param teamName sets the teams name
      @param sport sets the sport of the team
      @param league sets the league of the team
   **/
   public Tenant(String teamName, String sport, String league)
   {
      this.teamName = teamName;
      this.sport = sport;
      this.league = league;
   }
   
   //Setters
   
   /**
      @param teamName sets the team name
   **/
   public void setTeamName(String teamName)
   {
      this.teamName = teamName;
   }
   
   /**
      @param sport sets the name of the sport
   **/
   public void setSport(String sport)
   {
      this.sport = sport;
   }
   
   /**
      @param sport sets the name of the league
   **/
   public void setLeague(String league)
   {
      this.league = league;
   }
   
   //Getters
   
   /**
      @return teamName Returns the name of the team
   **/
   public String getTeamName()
   {
      return teamName;
   }
   
   /**
      @return sport Returns the name of the sport
   **/
   public String getSport()
   {
      return sport;
   }
   
   /**
      @return league Returns the name of the league
   **/
   public String getLeague()
   {
      return league;
   }
   
   /**
      to string method
    */
    public String toString() {
        return "\n" + "Team Name: " + teamName + "\n" +
               "Sport: " + sport + "\n" +
               "League: " + league + "\n";
                                              
    }
    
    /**
      copy constructor
      @param Account object
    */
    public Tenant(Tenant obj)
    {
      
      this.teamName = obj.teamName;
      this.sport = obj.sport;
      this.league = obj.league;


    }






   
   
}