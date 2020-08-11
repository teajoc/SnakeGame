package personal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SnakeMain implements ActionListener, KeyListener {

    public final int WIDTH = 500;
    public final int HEIGHT = 500;
    private int tick = 0;
    private JFrame frame;
    private Random rand;
    private boolean gameOver = false;
    Timer timer;
    Snake snake;
    private BGPanel bg;
    @SuppressWarnings("checkstyle:MultipleVariableDeclarations")
    final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

    public SnakeMain() {
        frame = new JFrame("My Snake Game");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setResizable(false);
        snake = new Snake(this);
        bg = new BGPanel(snake);
        frame.add(bg);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        gamePlay();
    }

    public void gamePlay() {
        timer = new Timer(20, this);
        timer.start();
        snake.direction = UP;
    }

    public static void main(String[] args) {
        SnakeMain snakeGame = new SnakeMain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bg.repaint();
        tick++;
        if (tick % 20 == 0) {
            if (snake.direction == UP && !(snake.head.y == 0)) {
                snake.head.y -= snake.SIZE;
            }
            if (snake.direction == RIGHT && !(snake.head.x == WIDTH)) {
                snake.head.x += snake.SIZE;
            }
            if (snake.direction == DOWN && !(snake.head.y == HEIGHT)) {
                snake.head.y += snake.SIZE;
            }
            if (snake.direction == LEFT && !(snake.head.x == 0)) {
                snake.head.x -= snake.SIZE;
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
