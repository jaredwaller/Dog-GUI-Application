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

public class Semester {
    
    private String name;
    
    //do not initialize this here because we initialize it in StudentMain
    private Course[] course;
    
    public Semester(){}
    
    public Semester(String name, Course[] courses)
    {
        this.name = name;
        this.course = course;
    }
    

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course[] getCourses() {
        return course;
    }

    public void setCourses(Course[] newCourses) {
        course = newCourses;
    }
    
    
}
