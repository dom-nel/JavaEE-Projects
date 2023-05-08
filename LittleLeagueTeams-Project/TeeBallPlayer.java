public class TeeBallPlayer implements Player {
   private String name;
   private String age;
   private String jerseyNumber;
   private String position;
   
   public TeeBallPlayer(String name, String age, String jerseyNumber, String position){
      super(); // calls the interface
      this.name = name; 
      this.age = age;
      this.jerseyNumber = jerseyNumber;
      this.position = position;
   }
   
   
   //getters
   
   /**
   *@return the name
   */
   public String getName(){
      return name;
   }
   
   /**
   *@return the age
   */
   public String getAge(){
      return age;
   }

   /**
   *@return the jersey number
   */
   public String getJerseyNumber(){
      return jerseyNumber;
   }

   /**
   *@return the position
   */
   public String getPosition(){
      return position;
   }
   
   //setters
   
   
   /**
   *@param name
   */
   public void setName(String name){
      this.name = name;
   }
   
   /**
   *@param age
   */
   public void setAge(String age){
      this.age = age;
   }

   /**
   *@param jersey number
   */
   public void setJerseyNumber(String jerseyNumber){
      this.jerseyNumber = jerseyNumber;
   }

   /**
   *@param position
   */
   public void setPosition(String position){
      this.position = position;
   }
   
   public String display(){
      // TODO Auto-generated method stub
      return "\n\tName: " + getName() +
             "\n\tLeague: Tee-Ball"  +
             "\n\tAge: " + getAge() +
             "\n\tDesired Jersey Number: " + 
             getJerseyNumber() + 
             "\n\tDesired Position: " + getPosition();
   }

   
   

}//public class player end