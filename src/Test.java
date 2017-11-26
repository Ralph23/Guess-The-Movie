import java.util.ArrayList;

/**
 * Created by ralphemerson on 11/21/2017.
 */
public class Test {
    public static void main(String[] args) {
        String word = "bannanas";
        String guess = "n";
        ArrayList<Integer> indexes = new ArrayList<>();

        int index = word.indexOf(guess);
        while (index >= 0) {
            System.out.println(index);
            indexes.add(index);
            index = word.indexOf(guess, index + 1);
        }

        for (int pos : indexes) {
            System.out.println(pos);
        }
    }
}
