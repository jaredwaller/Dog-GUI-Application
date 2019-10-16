import java.io.*;
import java.util.*;


public class Main 
{
    //make a universal scanner
    public static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        System.out.print("> Difficulty (1-3)? ");
        String difficulty = in.nextLine();
        int wordSize = 0;
        int numOfWords = 0;
        int numOfGuesses = 0;
        
        //Set the difficulty of the game
        switch(difficulty)
        {
            case "1":
                    wordSize = 4;
                    numOfWords = 6;
                    numOfGuesses = 4;
                break;
                
            case "2":
                    wordSize = 6;
                    numOfWords = 8;
                    numOfGuesses = 5;
                    
                break;
                
            case "3":
                    wordSize = 10;
                    numOfWords = 12;
                    numOfGuesses = 6;
                break;
                
            default:
                    wordSize = 2;
                    numOfWords = 6;
                    numOfGuesses = 4;
                break;
        }
        
        //run the game
        runGame(wordSize, numOfWords, numOfGuesses);
        
    }
    
    public static void runGame(int wordSize, int numOfWords, int numOfGuesses)
    {
        //Get every word that is wordSize long from file
        ArrayList<String> words = new ArrayList<String>();
        try
        {
            words = chooseWords(wordSize, numOfWords);
        }catch (IOException e)
        {
            System.out.println("Could not find file.");
            System.exit(0);
        }
        
        //Choose random word from our new words for the password
        Random rand = new Random();
        int randomIndex = rand.nextInt(words.size()-1);
        String keyword = words.get(randomIndex);
        
        //print out all the words
        for(String w: words)
        {
            System.out.println(w);
        }
        System.out.println();
        
        userInput(keyword, numOfGuesses);
        
    }
    
    public static void userInput(String keyword, int numOfGuesses)
    {
        while(numOfGuesses > 0)
        {
            //print out how many attempts are left
            System.out.print(numOfGuesses + " ATTEMPT(S) LEFT: ");
            for(int i = 0; i < numOfGuesses; i++) System.out.print("# ");
            
            //get user guess
            System.out.print("\n> ");
            String uI = in.nextLine();
            
            //if the input is invalid, tell the user
            if(uI.length() != keyword.length())
            {
                System.out.println("> Invalid input\n");
                userInput(keyword, numOfGuesses);
            }
            
            //if the guess is correct
            if(uI.equalsIgnoreCase(keyword))
            {
                System.out.println("> " + keyword.length() + "/" + keyword.length() + " correct");
                System.out.println("> Exact match!");
                System.exit(0);
            }
            
            //if the guess is incorrect, get the number of matching chararcters
            int matchingChars = 0;
            for(int i = 0; i < keyword.length(); i++)
            {
                if(Character.toLowerCase(uI.charAt(i)) == Character.toLowerCase(keyword.charAt(i)))
                {
                    matchingChars++;
                }
            }
            
            //tell the user they are incorrect and give the number of matching chars
            System.out.println("> Entry denied");
            System.out.println("> " + matchingChars + "/" + keyword.length() + " correct\n");
            numOfGuesses--;
        }
        
        //if the user runs out of attempts
        if(numOfGuesses == 0)
        {
            System.out.println("You failed. The keyword was\n" + keyword);
        }
    }
    
    public static ArrayList chooseWords(int wordLength, int numOfWords) throws IOException
    {
        //get the file name and prepare an arraylist to receive the words
        File file = new File("enable1.txt");
        Scanner fileReader = new Scanner(file);
        ArrayList<String> words = new ArrayList<String>();
        
        //add each line (word) to our array list
        while(fileReader.hasNext())
        {
            String line = fileReader.nextLine();
            
            if(line.length() == wordLength)
            {
                words.add(line);
            }
        }
        
        
        ArrayList<String> selectedWords = new ArrayList<String>();
        
        //pick a random word out of the words ArrayList and add it to selectedWords
        while(numOfWords > 0)
        {
            Random rand = new Random();
            int randomIndex = rand.nextInt(words.size()-1);
            selectedWords.add(words.get(randomIndex).toUpperCase());
            numOfWords--;
        }
        words.clear(); //save memory and delete the long list of words
        return selectedWords;
    }
    
    

}