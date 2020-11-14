import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Sends the input to the Model class and uses all methods from other classes
 *
 * @author Fabio Vitagliano
 * @version 1.0
 */
public class Controller {
    private static Model model;
    private static Output output;

    public static void main(String[] args) throws FileNotFoundException {
        model = new Model();
        output = new Output();
        model.readBoard();

        Timer timer = new Timer();
        int begin = 0;
        int timeInterval = 1000;
        timer.schedule (new TimerTask() {
            @Override
            public void run() {
                if (true) { // getInput() != null
                    model.moveSnake("w"); // getInput()
                    if (model.getGameOver() == true) {
                        output.printBoard(model.getBoard());
                        System.out.println("GAME OVER");
                        timer.cancel();
                    } else {
                        output.printBoard(model.getBoard());
                    }
                }
            }
        }, begin, timeInterval);
    }
}
