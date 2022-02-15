import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Processes the input and uses the checks from the Check class.
 *
 * @author Fabio Vitagliano
 * @version 1.0
 */
public class Model {
    private static Character[][] staticBoard;
    private static List<MovingObject> snake = new ArrayList<>();
    private static MovingObject food;
    private static int boardWidth = 41;
    private static int boardHeight = 12;
    private static boolean gameOver = false;
    private static File file;

    public Model(String pathToFile) throws FileNotFoundException {
        staticBoard = new Character[boardHeight][boardWidth];
        file = new File(pathToFile);
        Scanner scanner = new Scanner(file);

        for (int y = 0; y < boardHeight; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < boardWidth; x++) {
                Character character = line.charAt(x);
                if (character.equals('@')) {
                    staticBoard[y][x] = ' ';
                    snake.add(new MovingObject(y, x, '@'));
                } else if (character.equals('o')) {
                    staticBoard[y][x] = ' ';
                    food = new MovingObject(y, x, 'o');
                } else {
                    staticBoard[y][x] = character;
                }
            }
        }
    }

    public void processInput(String input) {
        //TODO: Prohibit snake from moving to himself
        if (input.equals("w")) {
            moveSnake(getSnakeHeadPositionY() - 1, getSnakeHeadPositionX());
        } else if (input.equals("a")) {
            moveSnake(getSnakeHeadPositionY(), getSnakeHeadPositionX() - 1);
        } else if (input.equals("s")) {
            moveSnake(getSnakeHeadPositionY() + 1, getSnakeHeadPositionX());
        } else if (input.equals("d")) {
            moveSnake(getSnakeHeadPositionY(), getSnakeHeadPositionX() + 1);
        }
    }

    private void moveSnake(int newSnakeHeadY, int newSnakeHeadX) {
        boolean snakeEatsFood = false;
        int lastSnakeBodyY = snake.get(snake.size() - 1).getY();
        int lastSnakeBodyX  = snake.get(snake.size() - 1).getX();
        int newY = 0;
        int newX = 0;

        if (getCharacterOnBoard(newSnakeHeadY,newSnakeHeadX).equals('#') || Model.getCharacterOnBoard(newSnakeHeadY,newSnakeHeadX).equals('@') ) {
            gameOver = true;
        } else if (Model.getCharacterOnBoard(newSnakeHeadY,newSnakeHeadX).equals('o')) {
            snakeEatsFood = true;
            food.setYAndX(4, 32); // To delete
            //TODO: setFoodOnNewRandomLocation()
        }

        for (int index = 0; index < snake.size(); index++) {
            int oldY = snake.get(index).getY();
            int oldX = snake.get(index).getX();

            if (index == 0) {
                snake.get(index).setYAndX(newSnakeHeadY,newSnakeHeadX);
            } else {
                snake.get(index).setYAndX(newY, newX);
            }
            newY = oldY;
            newX = oldX;
        }

        if (snakeEatsFood) {
            snake.add(new MovingObject(lastSnakeBodyY, lastSnakeBodyX, '@'));
        }
    }

    public static List<MovingObject> getSnakeBodyList() {
        return snake;
    }

    public static int getSnakeHeadPositionX() {
        return snake.get(0).getX();
    }

    public static int getSnakeHeadPositionY() {
        return snake.get(0).getY();
    }

    public static Character getCharacterOnBoard(int y, int x) {
        if (food.getY() == y && food.getX() == x) {
            return food.getSymbol();
        } // else if for snake

        return staticBoard[y][x];
    }

    public static Character[][] getStaticBoard() {
        return staticBoard;
    }

    public static int getBoardWidth() {
        return boardWidth;
    }

    public static int getBoardHeight() {
        return boardHeight;
    }

    public static boolean getGameOver() {
        return gameOver;
    }

    public static MovingObject getFood() {
        return food;
    }
}
