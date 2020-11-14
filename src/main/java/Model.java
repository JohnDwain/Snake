import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Processes the input and uses the checks from the Check class.
 *
 * @author Fabio Vitagliano
 * @version 1.0
 */
abstract class Model extends Check {
    private String[][] board = new board();

    File file = new File("board.txt");

    try (FileReader fileReader = new FileReader(file)) {
        int content;
        while ((content = fileReader.read()) != -1) {
            System.out.print((char) content);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }


}
