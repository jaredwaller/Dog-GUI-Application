/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaredwaller
 */
import java.util.*;
public class Student {

    //Student Attributes
    private String major;
    private String lname;
    private String fname;

    //do not initialize this here because we initialize it in StudentMain
    private Semester[] semesters;

   
    //Constructor
    public Student(String major, String lname, String fname) {
        this.lname = lname;
        this.fname = fname;
        this.major = major;
    }
    
    //Default Constructor
    public Student(){}
    
    //Getters and Setters
    public String getLname() {
        return lname;
    }
    
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    public String getName()
    {
        return fname + " " + lname;
    }
    
    public String getMajor(){
        return major;
    }
    public void setMajor(String major){
        this.major = major;
    }
    
    public Semester[] getSemesters() {
        return semesters;
    }

    public void setSemesters(Semester[] semesters) {
        this.semesters = semesters;
    }

    /*
        Here we will use the same logic we used to assign everything its values.
        We will first print out the student's name and major. Then, need to go
        to each of their semesters, go into their courses, and print their
        grades.
    */
    public void printStudent()
    {
        System.out.println("Name: " + fname + " " + lname);
        System.out.println("Major: " + major);
        
        for(int semestersIndex = 0; semestersIndex < semesters.length; semestersIndex++)
        {
            System.out.println("\tSemester: " + semesters[semestersIndex].getName());
            Course[] tempCourses = semesters[semestersIndex].getCourses();
            
            for(int courseIndex = 0; courseIndex < tempCourses.length; courseIndex++)
            {
                System.out.println("\t\tCourse: " + tempCourses[courseIndex].getName());
                Test[] tempTests = tempCourses[courseIndex].getTests();
                for(int testIndex = 0; testIndex < tempTests.length; testIndex++)
                {
                    System.out.println("\t\t\tGrade #" + (testIndex + 1) + ": " + tempTests[testIndex].getGrade());
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    
}
