
/**
 *
 * @author jaredwaller
 * 
 */

import java.util.*;
public class StudentMain {

    /*
        This assignment was a doozy. Good luck lol.
    */
    
    /*
        The logic used for creating students in this program is this...
        
        Student -> Semester (amount remaining) -> Course (a.r.) -> Test (a.r.)
        
        Student -> Semester(2) -> Course(3) -> Test(3)
                                            -> Test(2)
                                            -> Test(1)
    
                               -> Course(2) -> Test(3)
                                            -> Test(2)
                                            -> Test(1)
    
                               -> Course(1) -> Test(3)
                                            -> Test(2)
                                            -> Test(1)
    
    
                   Semester(1) -> Course(3) -> Test(3)
                                            -> Test(2)
                                            -> Test(1)
    
                               -> Course(2) -> Test(3)
                                            -> Test(2)
                                            -> Test(1)
    
                               -> Course(1) -> Test(3)
                                            -> Test(2)
                                            -> Test(1)
    
        I can show you in person how the logic works if you want.
    
        The addObjects methods are literally copy and pastes of each other.
        You just change the variable types and names.
                   
    */
    public static void main(String[] args) {
        
        
        Scanner in = new Scanner(System.in);
        
        //We do not intialize the students array here, we do that in 'addStudents'
        Student[] students;
        

        students = addStudents(in);


        printStudents(students);
    }
    
    public static Student[] addStudents(Scanner in)
    {
        /*
            We want to know how many students there are.
        */
        System.out.println("How many students are there?");
        int numOfStudents = in.nextInt();
        in.nextLine();
        
        //we need to create a temporary array of students that we will eventually
        //give to the student array in the main method
        Student[] tempStudents = new Student[numOfStudents];
        
        /*
            We will repeat this for each of our students
        */
        for(int i = 0; i < numOfStudents; i++)
        {
            System.out.println("What is the name of student #" + (i+1) + " ?");
            String studentName = in.nextLine();
            System.out.println("What is the major of student #" + (i+1) + " ?");
            String studentMajor = in.nextLine();
            
            //we must initialize the student to be able to give it a name
            //and tests
            Student newStudent = new Student();
            newStudent.setName(studentName);
            newStudent.setMajor(studentMajor);
            
            /*
                Here we will add the new student to the list of students that
                we will give to the student array in main.
            */
            tempStudents[i] = newStudent;
            
            /*
                Now, let's give our student some semesters
            */
            tempStudents[i].setSemesters(addSemesters(newStudent, in));
            
            
        }
        
        //Give the list of students to the student array in main
        return tempStudents;
    }
    
    
    
    /*
        In this method, we will find out how many semesters the student has
        and create courses, tests and grades for them.
    */
    
    public static Semester[] addSemesters(Student student, Scanner in)
    {
        /*
            Since the number of semesters was not declared in 'Semester', we
            will need the number of semesters from the user.
        */
        System.out.println("How many semesters does " + student.getName() + " have? ");
        int numOfSemesters = in.nextInt();
        /*
            THIS IS IMPORTANT
            After calling in.nextInt() we have to say in.nextLine() to clear
            the input line, otherwise the program will skip over your next
            question. Idk why, it is just some weird part of Java.
        */
        in.nextLine();
                       
        /*
            We have the number of semesters. We will create a temporary array
            of semesters. We will give this array to the student so the student
            can assign its semesters to the temp array.
        */
        Semester[] tempSemesters = new Semester[numOfSemesters];
        
        /*
            The reason we use for loops in all of the addObject() functions is
            because we want to use 'nested for loop' logic. Say we have 2
            semesters. We are going to go through semester #1, assign it courses
            (because every semester has an array of courses), then assign those
            courses, tests, then assign the tests, grades. Then when we finish
            with that semester, we are going to come all the way back here and
            start over with semester #2. The same logic is used for addCourses
            and addTests.
        */
        for(int i = 0; i < numOfSemesters; i++)
        {
            System.out.println("What is the name of semester #" + (i+1) + " ?");
            String semesterName = in.nextLine();
            
            //We have to initialize a new semester before we add it.
            Semester newSemester = new Semester();
            //Set the new semesters name to the user input
            newSemester.setName(semesterName);
            
            //we need to add courses to the new semester
            //notice that the addCourses function is inside the setCourses
            //so we are going to set the semester's courses to whatever courses
            //we add in addCourse.
            newSemester.setCourses(addCourses(newSemester,in));
            
            //when we are done with the semester, we will add it to the semester
            //array that belongs to our student
            tempSemesters[i] = newSemester;
            
            
        }
        
        /*
            Give the list of semesters to the student. The semesters also have
            their own indiviual courses, tests, and grades.
        */
        return tempSemesters;
    }
    
    
    public static Course[] addCourses(Semester semester, Scanner in)
    {
        /*
            We want to know how many courses there are.
        */
        System.out.println("How many courses are in the " + semester.getName() + " semester?");
        int numOfCourses = in.nextInt();
        in.nextLine();
        
        //we need to create a temporary array of courses that we will eventually
        //give to the semester
        Course[] tempCourses = new Course[numOfCourses];
        
        /*
            We will repeat this for each of our courses
        */
        for(int i = 0; i < numOfCourses; i++)
        {
            System.out.println("What is the name of course #" + (i+1) + " ?");
            String courseName = in.nextLine();
            
            //we must initialize the course to be able to give it a name
            //and tests
            Course newCourse = new Course();
            newCourse.setName(courseName);
            
            /*
                Here we will add the new course to the list of courses that
                we will give to the semester.
            */
            tempCourses[i] = newCourse;
            
            /*
                Now, let's add some tests to our new course
            */
            tempCourses[i].setTests(addTests(newCourse, in));
            
            
        }
        
        //Give the list of courses to the semester that belongs to our student
        return tempCourses;
    }
    
    /*
        This uses the same logic as the last function.
    */
    public static Test[] addTests(Course course, Scanner in)
    {
        
        System.out.println("How many tests does " + course.getName() + " have?");
        int numOfTests = in.nextInt();
        in.nextLine();
        Test[] tempTests = new Test[numOfTests];

        for(int i = 0; i < numOfTests; i++)
        {
            System.out.println("What is the grade for Test #" + (i+1) + " in " + course.getName() + " ?");
            int grade = in.nextInt();
            in.nextLine();
            
            Test newTest = new Test();
            newTest.setGrade(grade);
            
            tempTests[i] = newTest;
            
        }
        
        //Give the list of tests to the course that belongs to the semester
        return tempTests;
    }
    
    
    //For every student, we will print out their attributes
    public static void printStudents(Student[] students)
    {
        for(int i = 0; i < students.length; i++)
        {
            students[i].printStudent();
        }
    }
    
    
}
