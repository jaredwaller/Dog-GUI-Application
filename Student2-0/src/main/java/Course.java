
/**
 *
 * @author jaredwaller
 */
public class Course {
  
    //Course Attributes
    private String name;

  
    private Test[] tests;
    
    //Constructors
    public Course(){}
    
    public Course(String name, Test[] tests)
    {
        this.name = name;
        this.tests = tests;
    }
    
    public void setTestScore(int i, int score)
    {
        Test test = new Test(score);
        tests[i] = test;
    }
    
    public int getTestScore(int i)
    {
        return tests[i].getGrade();
    }
    
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test[] getTests() {
        return tests;
    }

    public void setTests(Test[] tests) {
        this.tests = tests;
    }
    
    
    
}
