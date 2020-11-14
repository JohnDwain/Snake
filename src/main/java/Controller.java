import java.io.FileNotFoundException;

/**
 *
 */
public class Controller {
    private static Model model;
    private static Output output;

    public static void main(String[] args) throws FileNotFoundException {
        model = new Model();
        output = new Output();
        model.readBoard();
        output.printBoard(model.getBoard());
    }
}
