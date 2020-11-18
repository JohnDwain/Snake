import java.util.ArrayList;
import java.util.List;

/**
 * For each @ of the snake body a object is created.
 *
 * @author Fabio Vitagliano
 * @version 1.0
 */
public class MovingObject {
    private int y;
    private int x;
    private Character symbol;

    public MovingObject(int y, int x, Character symbol) {
        this.y = y;
        this.x = x;
        this.symbol = symbol;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setYAndX(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public Character getSymbol() {
        return symbol;
    }
}
