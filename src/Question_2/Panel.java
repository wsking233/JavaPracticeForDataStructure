/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

import Question_1.LinkedList;
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
    
    
    private LinkedList<Integer> numbers;
    private char food;


    public Panel()
    {
        this.addKeyListener(this);     
        this.setFocusable(true);         
        numbers = new LinkedList<>();
        food = 'c';
    }
    
    public void newNumbers(){
       while(numbers.size <= 10){
           numbers.add((int) (Math.random() * 10));
       }
    }
    
    public int randomX(){
       return 0;
    }
   
    public void paint(Graphics g)
    {
        paintComponent(g);
        
        //put your rendering code here
        g.drawString(String.valueOf(food), 100, 100);
        

        repaint();
    }


    @Override
    public void keyTyped(KeyEvent ke) {
        

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //example code of getting the pressed key
        System.out.println("\""+ke.getKeyChar()+"\" is typed.");
        // Write your code here to control your snake
    
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }    
}
