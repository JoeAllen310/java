// Joseph Harnage 
// Project 4
// Dr. Amlan Chatterjee
//CSC 311
// I did get some help pointing my code in the right direction from CSUDH LSAMP tutoring from tutor Lori Oliver
package boardingpass;


public class PplBoarding {
   private String FirstName;
   private String LastName;
   private String Boarding;
   private String Date;
   private int Priorty;
   
   
   public PplBoarding(String first, String last, String boarding, String date, int priorty){
       this.FirstName = first;
       this.LastName = last;
       this.Boarding = boarding;
       this.Date = date;
       this.Priorty = priorty;
   }
   
   public String toString(){
       return "Passengers First Name: " + FirstName + "\nPassengers Last Name: " + LastName + " \nDate of Birth: " + Date + "\nFlight Status: " + Boarding+ "\nPriorty: "  + Priorty;
       }
   public String getBoarding(){
       return Boarding;
          
   }
   
   public int getPriorty(){
       return Priorty;
       
   }
   
}
