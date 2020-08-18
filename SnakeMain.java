package personal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SnakeMain implements ActionListener, KeyListener {

    public static final int WIDTH = 400, HEIGHT = 400;

    private int tick = 0;

    private JFrame frame;

    private static Random rand;

    private boolean gameOver, typed;

    Timer timer;

    Snake snake;

    private BGPanel bg;

    private JLabel startText;

    private int score;

    private static final int POINTS = 10;

    private static final int DELAY = 20;

    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

    public SnakeMain() {
        frame = new JFrame("My Snake Game"); // set up frame
        frame.setVisible(true);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);

        snake = new Snake(WIDTH, HEIGHT);
        rand = new Random();
        snake.apple = appleSetter(snake.SIZE);
        bg = new BGPanel(snake);
        timer = new Timer(DELAY, this);

        startText = new JLabel("Press 'p' to play"); // add start menu
        startText.setForeground(BGPanel.SNAKE_COLOR);
        startText.setFont(new Font("Verdana", 1, 15));
        bg.add(startText);

        frame.add(bg);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
    }

    public void gamePlay() {
        timer.start();
        score = 0;
        snake.direction = UP;
        gameOver = false;
    }

    public static void main(String[] args) {
        SnakeMain snakeGame = new SnakeMain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tick++;
        if (tick % 20 == 0 && !gameOver) {
            bg.repaint();
            if (snake.munch()) {
                scored(timer.getDelay()); // updates score and speed
            }
            snake.incr();
            typed = false;
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
            if (snake.hasBod(snake.head)) {
                gameOver = true;
            }
        }
        if (gameOver) {
            startText.setText("GAME OVER - FINAL SCORE: " + score);
            bg.repaint();
        }
    }

    private void scored(int currDelay) {
        if (currDelay > 5 && score % (POINTS * 2) == 0) { // if player scores twice, speed increases
            if (currDelay <= DELAY / 4) {
                timer.setDelay(currDelay - 1);
            } else {
                timer.setDelay(currDelay - DELAY / 10);
            }
        }
        score += POINTS;
    }

    public static Point appleSetter(int size) {
        Point neuApp = new Point(size * rand.nextInt((WIDTH - size * 2) / size) + size, //+ size / 2),
                                size * rand.nextInt((HEIGHT - size * 2) / size) + size); //+ size / 2));
        return neuApp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!gameOver && !typed) {
            if (e.getKeyChar() == 'w') {
                if (snake.getBod().isEmpty() || !(snake.direction == DOWN)) {
                    snake.direction = UP;
                    typed = true;
                }
            } else if (e.getKeyChar() == 'd') {
                if (snake.getBod().isEmpty() || !(snake.direction == LEFT)) {
                    snake.direction = RIGHT;
                    typed = true;
                }
            } else if (e.getKeyChar() == 's') {
                if (snake.getBod().isEmpty() || !(snake.direction == UP)) {
                    snake.direction = DOWN;
                    typed = true;
                }
            } else if (e.getKeyChar() == 'a') {
                if (snake.getBod().isEmpty() || !(snake.direction == RIGHT)) {
                    snake.direction = LEFT;
                    typed = true;
                }
            } else if (e.getKeyChar() == 'q') {
                gameOver = true;
            } else if (e.getKeyChar() == 'p' && !timer.isRunning()) {
                startText.setText("");
                gamePlay();
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
