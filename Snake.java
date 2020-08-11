package personal;

import java.awt.*;
import java.util.ArrayList;

public class Snake {

    protected Point head;
    protected Point apple;
    private ArrayList<Point> body = new ArrayList<>();
    public static final int SIZE = 10;
    public int direction;

    public Snake(SnakeMain board) {
        head = new Point(board.WIDTH / 2, board.HEIGHT / 2);
        /*body.add(new Point(head.x + SIZE, head.y)); /////
        body.add(new Point(head.x + SIZE + SIZE, head.y));
        body.add(new Point(head.x + SIZE + SIZE + SIZE, head.y));*/
    }

    public ArrayList<Point> getBod() {
        return body;
    }

    public void munch() {
        if (head.x - apple.x < SIZE / 2 && head.y - apple.y < SIZE / 2) {
            body.add(new Point(head.x, head.y));
            apple = SnakeMain.appleSetter(SIZE);
            System.out.println("munch");
        }
    }

    public void incr() {
        if (!body.isEmpty()) {
            for (int i = body.size() - 1; i > 0; i--) {
                body.set(i, body.get(i - 1));
            }
            body.set(0, new Point(head.x, head.y));
        }

    }
}
