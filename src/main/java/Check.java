/**
 * Class for checking if snake head made contact with either wall,
 * food or himself.
 *
 * @author Fabio Vitagliano
 * @version 1.0
 */
abstract class Check {
    public String checkInput(String input) {
        if (input.equals("w")) {
            return "up";
        } else if (input.equals("a")) {
            return "left";
        } else if (input.equals("s")) {
            return "down";
        } else if (input.equals("d")) {
            return "right";
        }
        return null;
    }

    public boolean checkIfWall(String[] nextArrayPosition) {
        if (nextArrayPosition.equals("#")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfFood(String[] nextArrayPosition) {
        if (nextArrayPosition.equals("o")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfSnake(String[] nextArrayPosition) {
        if (nextArrayPosition.equals("@")) {
            return true;
        } else {
            return false;
        }
    }
}
