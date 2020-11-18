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
        model = new Model("src\\main\\java\\board.txt");
        output = new Output();

        Timer timer = new Timer();
        int begin = 0;
        int timeInterval = 1000;
        timer.schedule (new TimerTask() {
            @Override
            public void run() {
                model.processInput("s"); // getInput()
                output.printBoard(model.getStaticBoard());
                if (model.getGameOver() == true) {
                    System.out.println("GAME OVER");
                    timer.cancel();
                }
            }
        }, begin, timeInterval);
    }
}
