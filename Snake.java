package personal;

import java.awt.*;
import java.util.ArrayList;

public class Snake {

    protected Point head;
    private ArrayList<Point> body = new ArrayList<>();
    public static final int SIZE = 10;
    public int direction;

    public Snake(SnakeMain board) {
        head = new Point(board.WIDTH / 2, board.HEIGHT / 2);

    }

    public ArrayList<Point> getBod() {
        return body;
    }
}
