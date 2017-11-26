import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by ralphemerson on 11/21/2017.
 */
public class MovieGenerator {

    private String[] moviesArray = new String[26];
    private String sMovieToGuess;
    private StringBuilder sbMovieToGuess = new StringBuilder();
    private int movieCounter = 0;
    private int lives = 10;
    private StringBuilder hiddenMovieToGuess = new StringBuilder();
    private boolean hasWon = false;

    public MovieGenerator() {
    }

    public void generateMovieToGuess(File moviesFile) throws FileNotFoundException{

        Scanner fileScanner = new Scanner(moviesFile);
        Random random = new Random();

        while (fileScanner.hasNextLine()) {
            moviesArray[movieCounter] = String.valueOf(fileScanner.nextLine());
            movieCounter++;
        }

        int randomNumer = random.nextInt(movieCounter);

        sbMovieToGuess.append( moviesArray[randomNumer]);
        sMovieToGuess = sbMovieToGuess.toString();

        hiddenMovieToGuess.append(sMovieToGuess.replaceAll("[a-zA-Z]", "_"));

        System.out.println(sMovieToGuess);
    }

    public String getSMovieToGuess() {
        return sMovieToGuess;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean getHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public StringBuilder getHiddenMovieToGuess() {
        return hiddenMovieToGuess;
    }

    public void checkChar(char charGuess) {

        ArrayList<Integer> indexes = new ArrayList<>();
        char charGuessLowerCase = Character.toLowerCase(charGuess);
        int charIndex = sMovieToGuess.toLowerCase().indexOf(charGuessLowerCase);

        if (!(charIndex >= 0)) {
            setLives(lives -1);
            System.out.println(lives + " lives left");
        } else {
            while (charIndex >= 0) {
                indexes.add(charIndex);
                charIndex = sMovieToGuess.toLowerCase().indexOf(charGuessLowerCase, charIndex+1);
            }

            for (int position: indexes) {
                hiddenMovieToGuess.setCharAt(position, sbMovieToGuess.charAt(position));
                if (!hiddenMovieToGuess.toString().contains("_")) {
                    setHasWon(true);
                }
            }
        }
    }
}
