/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author xhu
 */
public class Panel extends JPanel implements KeyListener {

    int number_ship = 20;
    boolean program_starts = false;
    Ship[] ships = new Ship[number_ship];
    Port port;

    Image ship_image;
    Image island_image;
    Image boat_island_image;

    JToggleButton syncSwitch;
    boolean sync = true;
    Thread[] threads = new Thread[number_ship];

    public Panel() {
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setBackground(Color.WHITE);
        port = new Port(900, 500);

        for (int i = 0; i < number_ship; i++) {

            ships[i] = new Ship(20, i * 50, port);
            threads[i] = new Thread(ships[i]);
            threads[i].start();
        }

        ship_image = new ImageIcon("boat.png").getImage();
        island_image = new ImageIcon("land.png").getImage();
        boat_island_image = new ImageIcon("boat_land.png").getImage();

        // initialize the switch button
        syncSwitch = new JToggleButton("Unsync/Sync");
        syncSwitch.setSelected(false);

        // add listeners to buttons
        syncSwitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchSync();
            }
        });

        // add the switch to panel
        this.setLayout(new BorderLayout());
        this.add(syncSwitch, BorderLayout.SOUTH);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Monospaced", Font.BOLD, 20));
        g.drawString("Type \"SPACE\" to start/pause game", 300, 50);

        g.drawImage(island_image, port.x, port.y, this);
    
        // draw ships
        for(Ship ship: ships){
            g.drawImage(ship_image, ship.x, ship.y, this);
        }

        //start the threads
        if (this.program_starts) {
            for (int i = 0; i < number_ship; i++) {
                if (sync) {
                    synchronized (port) {
                        port.notifyAll();
                        try {
                            port.wait();
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }

                    }
                } else {
                    notifyAll();
                }
            }
        }

        repaint();
    }


    private void switchSync() { // switch the sync flag
        this.sync = !this.sync;
    }

    @Override
    public void keyTyped(KeyEvent ke) { // switch the program_starts flag
        System.out.println("\"" + ke.getKeyChar() + "\" is typed.");
        this.program_starts = !this.program_starts;
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}
