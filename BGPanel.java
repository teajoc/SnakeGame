package personal;

import javax.swing.JPanel;
import java.awt.*;

public class BGPanel extends JPanel {

    public static final Color BG_COLOR = new Color(2826050);

    private Snake snake;

    public BGPanel(Snake s) {
        snake = s;
    }

    protected void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        graph.setColor(BG_COLOR);
        graph.fillRect(0, 0, 500, 500);
        graph.setColor(Color.YELLOW);
        graph.fillRect(snake.head.x - snake.SIZE / 2, snake.head.y - snake.SIZE / 2,
                snake.SIZE, snake.SIZE);
        for (Point part : snake.getBod()) {
            graph.fillRect(part.x * snake.SIZE, part.y * snake.SIZE,
                            snake.SIZE, snake.SIZE);
        }
    }
}
