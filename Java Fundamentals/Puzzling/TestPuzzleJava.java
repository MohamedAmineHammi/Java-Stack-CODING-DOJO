import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TestPuzzleJava {
    public static void main (String[] args) {

        PuzzleJava rand10 = new PuzzleJava();
        rand10.getTenRolls();

       PuzzleJava randLetter = new PuzzleJava();
        randLetter.getRandomLetter();

        PuzzleJava randLetterTwo = new PuzzleJava();
        randLetterTwo.getRandomLetterTwo();

        PuzzleJava passwords = new PuzzleJava();
        passwords.generatePassword();

        PuzzleJava passwordLists = new PuzzleJava();
        passwordLists.getNewPasswordSet(7);

    }
}
