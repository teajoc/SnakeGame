package personal;

import java.awt.*;
import java.util.ArrayList;

public class Snake {

    Point head;

    Point apple;

    private ArrayList<Point> body = new ArrayList<>();

    public final int SIZE = 20;

    public int direction;

    public Snake(int width, int height) {
        head = new Point(width / 2, height / 2);
    }

    public ArrayList<Point> getBod() {
        return body;
    }

    public boolean munch() {
        if (head.equals(apple)) {
            body.add(new Point(head.x, head.y));
            apple.setLocation(SnakeMain.appleSetter(SIZE));
            while (hasBod(apple)) { // ensures that the apple does not reappear underneath snake
                apple.setLocation(SnakeMain.appleSetter(SIZE));
            }
            return true;
        }
        return false;
    }

    public void incr() { // checks if there are any body segments to increment
        if (!body.isEmpty()) { // then moves each segment
            for (int i = body.size() - 1; i > 0; i--) {
                body.set(i, body.get(i - 1));
            }
            body.set(0, new Point(head.x, head.y)); //moves first segment to head location
        }
    }

    public boolean hasBod(Point pt) {
        return (body.contains(pt));
    }
}
