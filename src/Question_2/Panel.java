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

    public Panel()
    {
        this.addKeyListener(this);     
        this.setFocusable(true);         
    }
    
    
    public void paint(Graphics g)
    {
        paintComponent(g);
        
        //put your rendering code here

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
