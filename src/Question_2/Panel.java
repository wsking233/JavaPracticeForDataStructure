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

        //draw each body of the snake
        SnakeBody body = this.snake.getHead();
        while(body != null){
            g.drawString(body.toString(), body.getX(), body.getY());
            body = body.getNext();
        }          

        repaint();
    }

    public void draw(Graphics g){
        //draw the snake
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
