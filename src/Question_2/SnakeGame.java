/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author xhu
 */
public class SnakeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        frame.add(panel);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        
        panel.setSize(frame.getWidth()-100, frame.getHeight()-100);
        panel.setBackground(Color.LIGHT_GRAY);
    }
    
}
