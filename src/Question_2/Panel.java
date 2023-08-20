/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 *
 * @author xhu
 */
public class Panel extends JPanel implements KeyListener{
    
    private Snake snake;
    private SnakeBody food;
    private SnakeBody[] numbers;
    


    public Panel()
    {    
        //init snake 
        this.snake = new Snake("@abcd", 100, 100);
        this.food = randomFood();
        this.numbers = new SnakeBody[10];
        randomNumbers();
    }
    
    public void start(){
        //start the game

    }

    public void paint(Graphics g)
    {
        paintComponent(g);

        //draw the snake
        drawSnake(g);
        // g.drawString(snake.getHead().getNext().toString(), snake.getHead().getNext().getX() , snake.getHead().getNext().getY());
        //draw the food
        g.drawString(String.valueOf(food.getBody()), food.getX(), food.getY());

        //draw the numbers
        // drawNumbers(g);
        // g.drawString(String.valueOf(this.numbers[0]), RandomUtils.getRandomX(), RandomUtils.getRandomY());

        //HUI: score and snake body info
        drawHUI(g);

        snake.run();
        repaint();
    }

    public void drawNumbers(Graphics g){
        //draw the numbers
    //    if(numbers.length < 10){
    //        for(int i = 0; i < 10; i++){
    //            g.drawString(String.valueOf(this.numbers[i]), RandomUtils.getRandomX(), RandomUtils.getRandomY());
    //        }
    //    }
    }

    public void drawSnake(Graphics g){
        //draw each part of the snake body
        SnakeBody body = this.snake.getHead();
     
        while(body != null){
            g.drawString(body.toString(), body.getX(), body.getY());
            body = body.getNext();
        }
    }

    public void drawHUI(Graphics g){
        //draw the score and snake body info
        g.drawString("Score: " + String.valueOf(snake.getScore()), 700, 50);
        g.drawString("Snake body:"+snake.toString(), 50, 50);
    }

    public SnakeBody randomFood(){
        //generate a random food
        // System.out.println("random food: " + this.food);
        char temp = 'a';
        if(Math.random() < 0.5){
            temp = (char)(Math.random() * 26 + 'a');
        }else{
            temp = (char)(Math.random() * 26 + 'A');
        }

        int x = RandomUtils.getRandomX();
        int y = RandomUtils.getRandomY();
        SnakeBody body = new SnakeBody(temp, x, y);
        // body.setNext(null);
        // body.setPrev(null);
        this.food = body;

        return body;
    }

    public void randomNumbers(){
        //generate a random number
        // System.out.println("random number: " + this.numbers);
        System.out.print("The numbers are: ");
        for(int i = 0; i < 10; i++){
            this.numbers[i].setBody((char)(Math.random() * 10 + '0'));
            System.out.print(String.valueOf(numbers[i].getBody()) + " ");
        }
    }

    public void collisionDectect(){
        //detect if the snake hits the food
        if(this.snake.getHead().getX() == this.food.getX() && this.snake.getHead().getY() == this.food.getY()){
            System.out.println("hit food");
            this.snake.eat(food);
            randomFood();
        }
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
        switch(e.getKeyCode()){
            case 37: //left
                // System.out.println("left");
                this.snake.setDircetion(1);
                break;
            case 38: //up
                // System.out.println("up");
                this.snake.setDircetion(2);
                break;
            case 39: //right
                // System.out.println("right");
                this.snake.setDircetion(0);
                break;
            case 40: //down
                // System.out.println("down");
                this.snake.setDircetion(3);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
