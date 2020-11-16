import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Processes the input and uses the checks from the Check class.
 *
 * @author Fabio Vitagliano
 * @version 1.0
 */
public class Model {
    private static Character[][] board;
    private static int snakeHeadCurrentX;
    private static int snakeHeadCurrentY;
    private static int foodCurrentX;
    private static int foodHeadCurrentY;
    private static int width = 41;
    private static int height = 12;
    private static boolean gameOver = false;
    private File file = new File("src\\main\\java\\board.txt");
    private Scanner scanner;
    private String line;

    public void readBoard() throws FileNotFoundException {
        board = new Character[height][width];
        scanner = new Scanner(file);

        for (int y = 0; y < height; y++) {
            line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                Character character = line.charAt(x);
                if (character.equals('@')) {
                    board[y][x] = ' ';
                    snakeHeadCurrentX = x;
                    snakeHeadCurrentY = y;
                } else if (character.equals('o')) {
                    board[y][x] = ' ';
                    foodCurrentX = x;
                    foodHeadCurrentY = y;
                } else {
                    board[y][x] = character;
                }
            }
        }
    }

    public void moveSnake(String input) {
        if (input.equals("w")) {
            checks(getSnakeHeadCurrentY() + 1, getSnakeHeadCurrentX());
            snakeHeadCurrentY++;
        } else if (input.equals("a")) {
            checks(getSnakeHeadCurrentY(), getSnakeHeadCurrentX() - 1);
            snakeHeadCurrentX--;
        } else if (input.equals("s")) {
            checks(getSnakeHeadCurrentY() - 1, getSnakeHeadCurrentX());
            snakeHeadCurrentY--;
        } else if (input.equals("d")) {
            checks(getSnakeHeadCurrentY(), getSnakeHeadCurrentX() + 1);
            snakeHeadCurrentX++;
        }
    }

    public void checks(int y, int x) {
        if (getCharacterOnBoard(y,x).equals('#') || Model.getCharacterOnBoard(y,x).equals('@') ) {
            gameOver = true;
        } else if (Model.getCharacterOnBoard(y,x).equals('o')) {
            // add character "@" to snake body
        }
    }

    public static Integer getSnakeHeadCurrentX() {
        return snakeHeadCurrentX;
    }

    public static Integer getSnakeHeadCurrentY() {
        return snakeHeadCurrentY;
    }

    public static Character getCharacterOnBoard(int y, int x) {
        return board[y][x];
    }

    public static Character[][] getBoard() {
        return board;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static boolean getGameOver() {
        return gameOver;
    }
}
