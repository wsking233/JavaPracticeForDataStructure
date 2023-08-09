/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

import Question_1.LinkedList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author xhu
 */
public class Panel extends JPanel implements KeyListener{
    
    private Snake snake;
    private LinkedList<Integer> numbers;
    private Random rand;
    private char food;
    private int foodx;
    private int foody;


    public Panel()
    {
        snake = new Snake("@ABC", getRandomX(), getRandomY());
        this.addKeyListener(this);     
        this.setFocusable(true);       
        numbers = new LinkedList<>();
        rand = new Random();
        food = this.getRandomFood();
        foodx = this.getRandomX();
        foody = this.getRandomY();
    }
    
    public void newNumbers(){
       while(numbers.size <= 10){
           numbers.add((int) (Math.random() * 10));
       }
    }
    
    public int getRandomX(){
       return rand.nextInt(1000);
    }
    
    public int getRandomY(){
        return rand.nextInt(1000);
    }
    
    public char getRandomFood(){
        if(rand.nextInt(10) <=5){
            return (char)(rand.nextInt(26)+'A');
        }else{
            return (char)(rand.nextInt(26)+'a');
        }
    }
   
    public void paint(Graphics g)
    {
        paintComponent(g);
        
        //put your rendering code here
//        g.drawString(String.valueOf(food), foodx, foody);
        g.drawString(snake.getSnak(), foodx, foody);
        

        repaint();
    }


    @Override
    public void keyTyped(KeyEvent ke) {
        

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //example code of getting the pressed key
//        System.out.println("\""+ke.getKeyChar()+"\" is typed.");
        // Write your code here to control your snake
        System.out.println("\""+ke.getKeyCode()+"\" is typed.");
      switch(ke.getExtendedKeyCode()){
          case 38:
              System.out.println("Up is typed");
              foody--;
              break;
          case 40:
              System.out.println("Down is typed");
              foody++;
              break;
          case 37:
              System.out.println("Left is typed");
              foodx--;
              break;
          case 39:
              System.out.println("Right is typed");
              foodx++;
              break;
      }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }    
}
