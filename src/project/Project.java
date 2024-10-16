
package project;

import java.util.Scanner;


public class Project {

    public static void main(String[] args) {
        String resp;
      
        do {
            Project test = new Project();
            Scanner sc = new Scanner(System.in);
            
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
        
            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            
        switch(action){
            case 1:
                test.addRecord();
            break;
            case 2:
                test.viewRecord();
            break;                
            case 3:
                test.viewRecord();
                test.updateRecord();
            break;           
            case 4:
                test.viewRecord();
                test.deleteRecord();
                test.viewRecord();
            break;
        }
            System.out.print("Do you want to Continue?");
            resp = sc.next();
            
        } while (true);
       
    }
    
    public void addRecord(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter Student ID: ");
        String sid = sc.next();
        System.out.print("Enter Project Title: ");
        String title = sc.next();
        System.out.print("Enter Project Description: ");
        String description = sc.next();
        System.out.print ("Submission Date: ");
        String date = sc.next();
        System.out.print("Grade: ");
        String grade = sc.next();

        
        String sql = "INSERT INTO Project (Student_ID, Project_title, Project_description, Submission_Date, Grade) VALUES (?, ?, ?, ?, ?)";


        conf.addRecord(sql, sid, title, description, date, grade);
    }
    
    public void viewRecord(){
        String qry = "SELECT * FROM Project";
        String[] hdrs = {"Student_ID", "Project Title", "Project Description", "Submission Date", "Grade"};
        String[] clmns = {"Student_ID", "Project_title", "Project_description", "Submission_Date", "Grade"};
        
        config conf = new config();
        
        conf.viewRecords(qry, hdrs, clmns);
    }
    
     public void updateRecord(){
         Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Student ID: ");
        String sid = sc.next();
        System.out.print("Enter Project Title: ");
        String title = sc.next();
        System.out.print("Enter Project Description: ");
        String description = sc.next();
        System.out.print ("Submission Date: ");
        String date = sc.next();
        System.out.print("Grade: ");
        String grade = sc.next();

        
        String qry = " UPDATE Project SET Student_ID = ?, Project_Title = ?, Project_description = ? , Submission_Date = ?, Grade = ?";

        config conf = new config();
        conf.updateRecord(qry, sid, title, description, date, grade);
    }
     
     public void deleteRecord(){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the ID to delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM Project WHERE Student_ID = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
                
    }


}
