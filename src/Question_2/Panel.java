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
    private char food;
    private int foodx;
    private int foody;
    


    public Panel()
    {    
        //init snake
        this.snake = new Snake("@abcd", 100, 100);
        this.food = 'e';
        this.foodx = 200;
        this.foody = 200;

    }
    
    public void start(){
        //start the game

    }

    public void paint(Graphics g)
    {
        paintComponent(g);

        //draw the snake
        SnakeBody body = this.snake.getHead();
        while(body != null){
            g.drawString(String.valueOf(body.getBody()), body.getX(), body.getY());

            body = body.getNext();
        }

        g.drawRect(snake.getHead().getX(), snake.getHead().getY(), 10, 10);

        g.drawString(String.valueOf(this.food), this.foodx, this.foody);

        //HUI: score and snake body info
        g.drawString("Score: " + String.valueOf(snake.getScore()), 700, 50);
        g.drawString(snake.toString(), 100, 700);

        snake.run();
        updateUI();
    }

    public void drawSnakeBody(Graphics g){
        //put each snake body into a reactangle
        SnakeBody body = this.snake.getHead();
        while(body != null){
            g.drawRect(body.getX(), body.getY(), 10, 10);

            body = body.getNext();
        }
        
        
    }

    public void randomFood(){
        //generate a random food
        // System.out.println("random food: " + this.food);
        this.food = (char)('a' + (int)(Math.random() * 26));
        this.foodx = (int)(Math.random() * 80) * 10;
        this.foody = (int)(Math.random() * 80) * 10;
    }

    public void collisionDectect(){

        //detect collision with food
        SnakeBody head = this.snake.getHead();
        if(head.getX() == this.foodx && head.getY() == this.foody){
            //eat the food
            this.snake.eat(this.food);
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
