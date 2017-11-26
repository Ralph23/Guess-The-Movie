import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by ralphemerson on 11/21/2017.
 */
public class Movies {
    public static void main(String[] args) {

        File file = new File("movies.txt");
        MovieGenerator movieGenerator = new MovieGenerator();

        try {
            movieGenerator.generateMovieToGuess(file);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
            System.out.println("File not found");
        }

        while (movieGenerator.getLives() > 0) {
            char charGuess;

            if(movieGenerator.getHasWon()) {
                System.out.println("You won! The title is: " + movieGenerator.getSMovieToGuess());
                break;
            } else {
                System.out.println("You are guessing: " + movieGenerator.getHiddenMovieToGuess());

                try {
                    Scanner inputScanner = new Scanner(System.in);
                    charGuess = inputScanner.next(".").charAt(0);

                    movieGenerator.checkChar(charGuess);

                } catch (InputMismatchException e) {
                    e.getStackTrace();
                    System.out.println("Input 1 character only");
                }
            }
        }
    }
}
