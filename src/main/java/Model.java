import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Processes the input and uses the checks from the Check class.
 *
 * @author Fabio Vitagliano
 * @version 1.0
 */
public class Model extends Check {
    private static String[][] board;
    private static int width = 42;
    private static int height = 12;
    private File file = new File("board.txt");
    private Scanner scanner;
    private String line;

    public void readBoard() throws FileNotFoundException {
        board = new String[height][width];
        scanner = new Scanner(file);

        for (int y = 0; y < height; y++) {
            line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                Character  character = line.charAt(x);
                board[y][x] = character.toString();
            }
        }
    }

    public static String[][] getBoard() {
        return board;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
