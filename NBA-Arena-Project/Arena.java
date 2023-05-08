public class Arena 
{
   //private fields for the Arena class
   private String venueName;
   private String city;
   private String state;
   private int maxCapacity;
   private int yearOpened;
   private int attendance;
   private Tenant team;
   
   /**
   No Arg Constructor
   **/
   public Arena()
   {
      venueName = "Little Caesars arena";
       city = "Detroit";
       state = "Michigan";
       maxCapacity = 20332;
       yearOpened = 2017;
       attendance = 16214;

   }
   
   
   /**
     Constructor that accepts arguments for the Arena class
     @param venueName Name of the venue 
     @param city Name of the city
     @param state Name of the state
     @param maxCapacity Sets the capacity for the arena
     @param yearOpened Sets the year the arena was opened
     @param attendance Sets sets the attendance of the venue 
   */
   public Arena(String venueName, String city, String state, int maxCapacity, int yearOpened, int attendance, Tenant team)
      {
         this.venueName = venueName;
         this.city = city;
         this.state = state;
         this.maxCapacity = maxCapacity;
         this.yearOpened = yearOpened;
         this.attendance = attendance;
         this.team = new Tenant(team);
         
   
      }
      
   //Setters
   
   /**
      @param attendance sets the attendance of the venue 
   **/
   public void setAttendance(int attendance)
   {
      this.attendance = attendance;
   }

  
  
   /**
      @param venueName sets the name of the venue 
   **/
   public void setVenueName(String venueName)
   {
      this.venueName = venueName;
   }
   
    /**
      @param city sets the name of the city 
   **/
   public void setCity(String city)
   {
      this.city = city;
   }
   
   /**
      @param state sets the name of the state 
   **/
   public void setState(String state)
   {
      this.state = state;
   }
 
   
   /**
      @param maxCapacity sets the max capacity for the venue 
   **/
   public void setMaxCapacity(int maxCapacity)
   {
      this.maxCapacity = maxCapacity;
   }
   
   /**
      @param yearOpened sets the year the venue was opened 
   **/
   public void setYearOpened(int yearOpened)
   {
      this.yearOpened = yearOpened;
   }
   
   //Getters
   
   /**
      @return attendance Returns the attendance of the venue
   **/
   public int getAttendance()
   {
      return attendance;
   }

   
   
   
   /**
      @return venueName Returns the name of the venue
   **/
   public String getVenueName()
   {
      return venueName;
   }
   
   /**
      @return city Returns the city of the venue
   **/
   public String getCity()
   {
      return city;
   }
   
   /**
      @return state Returns the state of the venue
   **/
   public String getState()
   {
      return state;
   }
   
   /**
      @return maxCapacity Returns the max capacity of the venue
   **/
   public int getMaxCapacity()
   {
      return maxCapacity;
   }
   
   /**
      @return yearOpened Returns the year the venue was opened
   **/
   public int getYearOpened()
   {
      return yearOpened;
   }
   
   /**
      to string method
    */
    public String toString() {
        return "Venue: " + venueName + "\n" +
               "Location: " + city + "," + state + "\n" +
               "Capacity: " + maxCapacity + "\n" +
               "Year Opened: " + yearOpened + 
               "Attendance: " + attendance +
                getTenant().toString();
               
                               
    }
    
     /**
      @return Tenant Return a deep copy of an Tenant object
    */
    public Tenant getTenant() {
        return new Tenant(team);
    }

    /**
      @param Tenant sets an Tenant object\
    */
    public void setTenant(Tenant team) {
        this.team = new Tenant(team);
    }










   
  
}