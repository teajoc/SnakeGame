package personal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SnakeMain implements ActionListener, KeyListener {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    private int tick = 0;
    private JFrame frame;
    private static Random rand;
    private boolean gameOver = false;
    Timer timer;
    Snake snake;
    private BGPanel bg;
    private int score;
    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

    public SnakeMain() {
        frame = new JFrame("My Snake Game");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setResizable(false);
        snake = new Snake(this);
        rand = new Random();
        snake.apple = appleSetter(snake.SIZE);
        //System.out.println(snake.apple.toString());
        bg = new BGPanel(snake);
        frame.add(bg);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        gamePlay();
    }

    public void gamePlay() {
        timer = new Timer(10, this);
        timer.start();
        score = 0;
        snake.direction = UP;
    }

    public static void main(String[] args) {
        SnakeMain snakeGame = new SnakeMain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tick++;
        if (tick % 20 == 0) {
            bg.repaint();
            snake.munch();
            snake.incr();
            System.out.println("tick");
            //System.out.println(snake.head.toString());   ////
            //System.out.println(snake.getBod().toString()); /////
            if (snake.direction == UP && !(snake.head.y == 0)) {
                snake.head.y -= snake.SIZE;
            } else if (snake.direction == RIGHT && !(snake.head.x == WIDTH)) {
                snake.head.x += snake.SIZE;
            } else if (snake.direction == DOWN && !(snake.head.y == HEIGHT)) {
                snake.head.y += snake.SIZE;
            } else if (snake.direction == LEFT && !(snake.head.x == 0)) {
                snake.head.x -= snake.SIZE;
            } else {
                gameOver = true;
            }
        }

    }

    public static Point appleSetter(int size) {
        return new Point(rand.nextInt(WIDTH - size / 2) + size / 2,
                        rand.nextInt(HEIGHT - size / 2) + size / 2);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!gameOver) {
            if (e.getKeyChar() == 'w') {
                snake.direction = UP;
            } else if (e.getKeyChar() == 'd') {
                snake.direction = RIGHT;
            } else if (e.getKeyChar() == 's') {
                snake.direction = DOWN;
            } else if (e.getKeyChar() == 'a') {
                snake.direction = LEFT;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
