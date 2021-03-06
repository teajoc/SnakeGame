package personal;

import javax.swing.JPanel;
import java.awt.*;

public class BGPanel extends JPanel {

    public static final Color BG_COLOR = new Color(2826050);

    public static final Color SNAKE_COLOR = new Color(14872680);

    public static final Color APPLE_COLOR = new Color(15366788);

    private Snake snake;

    public BGPanel(Snake s) {
        snake = s;
    }

    protected void paintComponent(Graphics graph) {
        super.paintComponent(graph);

        graph.setColor(BG_COLOR); // draw bg
        graph.fillRect(0, 0, SnakeMain.WIDTH, SnakeMain.HEIGHT);

        graph.setColor(APPLE_COLOR); // draw apple
        graph.fillRect(snake.apple.x - snake.SIZE / 2, snake.apple.y - snake.SIZE / 2,
                snake.SIZE, snake.SIZE);

        graph.setColor(SNAKE_COLOR); // draw snake
        graph.fillRect(snake.head.x - snake.SIZE / 2, snake.head.y - snake.SIZE / 2,
                snake.SIZE, snake.SIZE);

        for (Point part : snake.getBod()) {
            graph.fillRect(part.x - snake.SIZE / 2, part.y - snake.SIZE / 2,
                            snake.SIZE, snake.SIZE);
        }
    }
}
