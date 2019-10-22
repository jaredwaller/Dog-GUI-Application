
import java.util.*;


public class Dog 
{
    private String ID;
    private String name;
    private String breed;
    private String age;
    private String rented;
    
    private static int count = 0;


    public Dog(String name, String breed, String age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        count++;
        ID = Integer.toString(count);
    }
    
    public Dog(String ID, String name, String breed, String age, String rented)
    {
        this.ID = ID;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.rented = rented;
    }
    
    public Dog(){count++;}
    
    @Override
    public String toString()
    {
        return this.name;
    }
    
     public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Dog.count = count;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRented() {
        return rented;
    }

    public void setRented(String rented) {
        this.rented = rented;
    }
    
    

}
