
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
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Student[] students = new Student[]{};
        
        /*
            uI will be our conditional requirement. We set it to 'y' at first
            so that the while loop runs in the first place. If it is set to
            anything else, nothing will happen.
        */
        String uI = "y";
        while(uI.equalsIgnoreCase("y"))
        {
            
            /*
                We will carry the scanner and the array of students into
                'createStudent'.
            */
            Student temp = createStudent(in, students);
            
            students = addStudent(students,temp);
            

            printStudents(students);
            
            System.out.println("Would you like to make another student? (y/n)");
            uI = in.nextLine();
        }
        
        
        
    }
    
    /*
        In this method, we will get the name and major of the student and
        create the student.
    */
    public static Student createStudent(Scanner in, Student[] students)
    {
        System.out.println("Enter the student's first name: ");
        String fname = in.nextLine();
        System.out.println("Enter the student's last name: ");
        String lname = in.nextLine();
        System.out.println("Enter the student's major: ");
        String major = in.nextLine();
        
        Student temp = new Student(major, lname, fname);
        
        /*
            This is the start of the rabbit hole to H E double hockey sticks.
            Remember the room analogy? How you can't go to the end without
            first going through every other room? Well here we go...
        
            So we created a student called 'temp' and gave him a name and
            major based off of user input. We will drop him into the whirpool
            where we will assign him a number of semesters, and within those
            semesters, we will assign him a number of courses, and within
            those courses, we will assign him a number of tests, and within
            those tests, we will assing him grades. In that order. So first
            we set his semester array to an array of semesters we make in
            'addSemesters'. We carry the student and the scanner with us.
        */
        temp.setSemesters(addSemesters(temp, in));
        
        return temp;
    }
    
    /*
        In this method, we will find out how many semester the student has
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
    
    /*
        This method adds the newly created student to our student array in main
        It is separate because the array of students in the main method is
        persistent.
    */
    public static Student[] addStudent(Student[] students, Student newStudent)
    {
        /*
            Since you can not change the length of arrays in Java, we need to
            make a temporary array that is one length longer than the current
            student array.
        */
        Student[] temp = new Student[students.length+1];
        
        /*
            arraycopy is a built in Java function. The parameters are:
            arraycopy(arrayToCopyFrom, startingIndex, copyToArray, startingIndex, finishingIndex)
            This copies the array into a new one that has one new empty spot at
            the end
        */
        System.arraycopy(students,0,temp,0,students.length);
        
        /*
            Since we never filled in the last spot of the new array because we
            stopped at the original array length, we have a spot for our new
            student.
        */
        temp[temp.length-1] = newStudent;
        return temp;
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
