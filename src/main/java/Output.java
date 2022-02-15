/**
 * Outputs the board of the game
 *
 * @author Fabio Vitagliano
 * @version 1.0
 */
public class Output {

    public void printBoard(Character[][] board) {
        StringBuffer line = new StringBuffer();

        for (int y = 0; y < Model.getHeight(); y++) {
            for (int x = 0; x < Model.getWidth(); x++) {
                if (y == Model.getSnakeHeadCurrentY() && x == Model.getSnakeHeadCurrentX()) {
                    line.append("@");
                } else {
                    line.append(board[y][x].toString());
                }
            }
            System.out.println(line);
            line = new StringBuffer();
        }
    }

}
