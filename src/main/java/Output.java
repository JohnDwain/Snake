/**
 * Outputs the board of the game with updates every 500 milliseconds.
 *
 * @author Fabio Vitagliano
 * @version 1.0
 */
public class Output {

    public void printBoard(String[][] board) {
        StringBuffer line = null;

        for (int y = 0; y < Model.getHeight(); y++) {
            for (int x = 0; x < Model.getWidth(); x++) {
                line.append(board[y][x]);
            }
            System.out.println(line);
            line = null;
        }
    }
}
