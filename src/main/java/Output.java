import java.util.List;

/**
 * Outputs the board of the game
 *
 * @author Fabio Vitagliano
 * @version 1.0
 */
public class Output {

    public void printBoard(Character[][] staticBoard) {
        StringBuffer line = new StringBuffer();
        Character charToAppend;

        for (int y = 0; y < Model.getBoardHeight(); y++) {
            for (int x = 0; x < Model.getBoardWidth(); x++) {
                charToAppend = staticBoard[y][x];
                for (int index = 0; index < Model.getSnakeBodyList().size(); index++) {
                    if (Model.getSnakeBodyList().get(index).getY() == y && Model.getSnakeBodyList().get(index).getX() == x) {
                        charToAppend = Model.getSnakeBodyList().get(index).getSymbol();
                    }
                }

                if (Model.getFood().getY() == y && Model.getFood().getX() == x) {
                    charToAppend = Model.getFood().getSymbol();
                }

                line.append(charToAppend.toString());

            }
            System.out.println(line);
            line = new StringBuffer();
        }

    }
}
