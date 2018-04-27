
package examsystem;

import java.awt.Color;

/**
 *
 * @author Reagan
 */
public class Calculations {
   
    String grade;
    String comment;
    Calculations(double total) {
       if(total >= 0 && total <=29) { grade = "E";   }
       else if(total >= 30 && total <=34) { grade = "D-";}
       else if(total >= 35 && total <=39) { grade = "D";}
       else if(total >= 40 && total <=44) { grade = "D+";}
       else if(total >= 45 && total <=49) { grade = "C-";}
       else if(total >= 50 && total <=54) { grade = "C";}
       else if(total >= 55 && total <=59) { grade = "C+";}
       else if(total >= 60 && total <=64) { grade = "B-";}
       else if(total >= 65 && total <=69) { grade = "B";}
       else if(total >= 70 && total <=74) { grade = "B+";}
       else if(total >= 75 && total <=79) { grade = "A-";}
       else if(total >= 80 && total <=100) { grade = "A";}
       
       switch (grade)
       {
           case "A": comment = "Excellent";
                     break;
           case "A-": comment = "V.Good";
                     break;
           case "B+": comment = "V.Good";
                     break;
           case "B": comment = "Good";
                     break;
           case "B-": comment = "Good";
                     break;
           case "C+": comment = "Fairly Done";
                     break;
           case "C": comment = "Fairly Done";
                     break;
           case "C-": comment = "You Can Do Better";
                     break;
           case "D+": comment = "You Can Do Better";
                     break;
           case "D": comment = "Very Poor";
                     break;
           case "D-": comment = "Very Poor";
                     break;
           case "E": comment = "Very Poor";
                     
       }
    }
    public String getGrade() { return grade;}
    public String getComment() { return comment;}

   
}
