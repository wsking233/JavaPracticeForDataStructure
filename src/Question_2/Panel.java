/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 *
 * @author xhu
 */
public class Panel extends JPanel implements KeyListener {

    private Snake snake;
    private SnakeBody food;
    private SnakeBody[] numbers;

    public Panel() {
        // init snake
        this.snake = new Snake("@abcdefg", 100, 100);
        randomFood(); // init food
        this.numbers = new SnakeBody[10];
        randomNumbers();
    }

    public void start() {
        // start the game

    }

    public void paint(Graphics g) {
        paintComponent(g);

        if(this.snake.getSize() <= 0){
            System.out.println("Game Over!");            
            System.exit(0);
        }

        // draw the snake
        drawSnake(g);

        // draw the food
        drawFood(g);

        // detect if the snake hits the food
        collisionDectect();

        // draw the numbers
        drawNumbers(g);

        // HUD: score and snake body info
        drawHUD(g);

        snake.run();
        repaint();
    }

    public void drawNumbers(Graphics g) {
        // draw the numbers
        for (int i = 0; i < 10; i++) {
            String body = String.valueOf(numbers[i].getBody());
            int x = numbers[i].getLocation().x;
            int y = numbers[i].getLocation().y;
            g.drawString(body, x, y);
        }
    }

    public void drawSnake(Graphics g) {
        // draw each part of the snake body
        SnakeBody body = this.snake.getHead();

        while (body != null) {
            g.drawString(body.toString(), body.getLocation().x, body.getLocation().y);
            body = body.getNext();
        }
    }

    public void drawFood(Graphics g) {
        // draw the food
        g.drawString(String.valueOf(food.getBody()), food.getLocation().x, food.getLocation().y);
    }

    public void drawHUD(Graphics g) {
        // draw the score and snake body info
        g.drawString("Score: " + String.valueOf(snake.getScore()), 700, 50);
        g.drawString("Snake body:" + snake.toString(), 50, 50);
    }

    public SnakeBody randomFood() {
        // generate a random food
        // System.out.println("random food: " + this.food);
        char temp = 'a';
        if (Math.random() < 0.5) {
            temp = (char) (Math.random() * 26 + 'a');
        } else {
            temp = (char) (Math.random() * 26 + 'A');
        }

        SnakeBody body = new SnakeBody(temp, RandomUtils.getRandomPoint());
        this.food = body;
        System.out.println("this Food is: " + this.food.getBody() + " location at: " + this.food.getLocation());
        return body;
    }

    public void randomNumbers() {
        // generate a random number
        // System.out.println("random number: " + this.numbers);
        System.out.print("The numbers are: ");
        for (int i = 0; i < 10; i++) {
            SnakeBody num = new SnakeBody((char) (Math.random() * 10 + '0'), RandomUtils.getRandomPoint());
            this.numbers[i] = num;
            System.out.print(String.valueOf(numbers[i].getBody()) + " ");
        }
    }

    public void collisionDectect() {
        // detect if the snake hits the food
        int range = 10;
        if (distanceDectect(this.snake.getHead().getLocation(), this.food.getLocation()) < range) {
            System.out.println("collision detect: " + this.food);
            this.snake.eat(this.food);
            this.randomFood();
            // this.randomNumbers();
        }

        // detect if the snake hits the numbers
        for(int i = 0; i < numbers.length; i++){
            if (distanceDectect(this.snake.getHead().getLocation(), this.numbers[i].getLocation()) < range) {
                System.out.println("collision detect: " + this.numbers[i]);
                this.snake.hitsNumber(numbers[i]);
                SnakeBody temp = new SnakeBody((char) (Math.random() * 10 + '0'), RandomUtils.getRandomPoint());
                this.numbers[i] = temp;
            }
        }

    }

    private double distanceDectect(Point p1, Point p2) {
        // detect the distance between two points
        double x = Math.pow(p1.x - p2.x, 2);
        double y = Math.pow(p1.y - p2.y, 2);
        double distance = Math.sqrt(x + y);
        return distance;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
        // System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
            case 37: // left
                // System.out.println("left");
                this.snake.setDircetion(1);
                break;
            case 38: // up
                // System.out.println("up");
                this.snake.setDircetion(2);
                break;
            case 39: // right
                // System.out.println("right");
                this.snake.setDircetion(0);
                break;
            case 40: // down
                // System.out.println("down");
                this.snake.setDircetion(3);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'keyReleased'");
    }
}
