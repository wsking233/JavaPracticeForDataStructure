/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_2;

import javax.swing.JFrame;

/**
 *
 * @author wskin
 */
public class SnakeFrame extends JFrame {

    public SnakeFrame() {
        //init game frame
        super("Snake");
        this.setSize(500, 500);
        this.setTitle("Snake Game - COMP610 Assignment 1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //init game panel
        Panel panel = new Panel();
        add(panel);
    }
    
}
