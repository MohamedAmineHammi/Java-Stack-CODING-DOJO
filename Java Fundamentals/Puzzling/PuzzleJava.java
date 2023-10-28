import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    /*
     * getTenRolls
     * 
     * Write a method that will generate and return an array with 10 random numbers
     * between 1 and 20 inclusive.
     */
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> random10 = new ArrayList<Integer>();
        Random randMachine = new Random();
        for (int i = 1; i <= 10; i++) {
            random10.add(randMachine.nextInt(20) + 1);
        }
        System.out.println(random10);
        return random10;
    }
    /*
     * getRandomLetter
     * 
     * Write a method that will:
     * Create an array within the method that contains all 26 letters of the
     * alphabet (this array must have 26 values).
     * Return the random letter.
     */

    // With Array

    public String getRandomLetter() {
        Random randOneLetter = new Random();
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = new String[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = String.valueOf(alphabetString.charAt(i));
        }
        System.out.println(alphabet[randOneLetter.nextInt(26)]);
        return alphabet[randOneLetter.nextInt(26)];

    }

    // Without Array
    public String getRandomLetterTwo() {
        Random randOneLetterTwo = new Random();
        String AlphabetStringTwo = "abcdefghijklmnopqrstuvwxyz";
        char randomChar = AlphabetStringTwo.charAt(randOneLetterTwo.nextInt(26));
        System.out.println(String.valueOf(randomChar));
        return String.valueOf(randomChar);

    }

    /*
     * generatePassword
     * 
     * Write a method that uses the previous method to create a random string of
     * eight characters and return that string.
     */
    public String generatePassword() {

        String password = "";

        for(int i = 0; i < 8; i++) {
            password = password + getRandomLetter();
        }

        return password;
    }

    public ArrayList <String> getNewPasswordSet(int length){
        ArrayList<String> passwordList = new ArrayList<String>();
        for (int i=0; i<length; i++) {
            passwordList.add(generatePassword());
        }
        System.out.println ("passListe:" + passwordList);
        return passwordList;


    }}

