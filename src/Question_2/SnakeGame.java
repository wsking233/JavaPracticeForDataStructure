/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 *
 * @author William Wang
 * @studnetID 18017970
 */
public class SnakeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //init game frame
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setBackground(Color.BLACK);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        //init game panel
        Panel panel = new Panel();
        panel.setPreferredSize(new Dimension(800, 800));
        panel.setBackground(Color.gray);
        // panel.setFocusable(true);
        // panel.requestFocusInWindow();  

        //add panel to frame
        frame.add(panel);
        frame.addKeyListener(panel);
        frame.setVisible(true);
    
        // System.out.println(snake.toString());
    }
    
}
