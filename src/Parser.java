import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Parser {
    public static LinkedList<Integer> parseInput(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        LinkedList<Integer> ll = new LinkedList<>();
        while (scanner.hasNextInt())
            ll.add(scanner.nextInt());
        return ll;
    }
}
