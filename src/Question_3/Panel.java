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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

/**
 *
 * @author William Wang
 * @studnetID 18017970
 */
public class Panel extends JPanel implements KeyListener, ActionListener {

    int number_ship = 20;
    boolean program_starts = false;
    Ship[] ships = new Ship[number_ship];
    Port port;

    Image ship_image;
    Image island_image;
    Image boat_island_image;

    // JToggleButton syncSwitch;
    Thread[] threads = new Thread[number_ship];
    JButton syncButton = new JButton("Sync Mode");
    JButton unyncButton = new JButton("Unsync Mode");

    public Panel() {
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setBackground(Color.WHITE);
        port = new Port(900, 500);

        for (int i = 0; i < number_ship; i++) {

            ships[i] = new Ship(20, i * 50, port);
            threads[i] = new Thread(ships[i]);
        }

        ship_image = new ImageIcon("boat.png").getImage();
        island_image = new ImageIcon("land.png").getImage();
        boat_island_image = new ImageIcon("boat_land.png").getImage();

        // initialize the buttons
        syncButton.addActionListener(this);
        unyncButton.addActionListener(this);
        this.add(syncButton, BorderLayout.CENTER);
        this.add(unyncButton, BorderLayout.CENTER);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw the ships
        for (Ship ship : ships) {
            g.drawImage(ship_image, ship.x, ship.y, this);
        }
        // draw island
        if (port.occupied) {
            g.drawImage(boat_island_image, port.x, port.y, this);
        } else {
            g.drawImage(island_image, port.x, port.y, this);
        }

        drawNotification(g);

        // set button invisible after the game starts
        hidButton();

        repaint();
    }

    private void hidButton() {
        if (program_starts) {
            syncButton.setVisible(false);
            unyncButton.setVisible(false);
        } else {
            syncButton.setVisible(true);
            unyncButton.setVisible(true);
        }
    }

    public void drawNotification(Graphics g) {
        // check if ships are crashed
        int arrived_ship = 0;
        for (int i = 0; i < number_ship; i++) { // first check if the ship is moving
            for (int j = i + 1; j < number_ship; j++) {
                if (i != j && !ships[i].arrived && !ships[j].arrived) { // avoid checking the same ship, and the ships
                                                                        // already arrived
                    if (ships[i].x == ships[j].x && ships[i].y == ships[j].y) {
                        // draw notification when the ship is crashed
                        g.setFont(new Font("Monospaced", Font.BOLD, 30));
                        g.drawString("Crashed!", ships[i].x, ships[i].y - 50);
                    }
                }
            }
            if (ships[i].arrived) {
                arrived_ship++;
            }
        }

        // draw notification when all ships arrived
        if (arrived_ship == number_ship) {
            g.setFont(new Font("Monospaced", Font.BOLD, 30));
            g.drawString("Game Over", 400, 500);
        }
    }

    private void startGame(boolean syncMode) {
        for (int i = 0; i < number_ship; i++) {
            ships[i].syncMode = syncMode;
            threads[i].start();
        }
        program_starts = true;
        // this.requestFocusInWindow(); // Set focus on the panel to receive key events
        // if (!program_starts) {
        // }
    }

    // button listener
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == syncButton) {
            startGame(true);
        } else if (e.getSource() == unyncButton) {
            startGame(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) { // switch the program_starts flag
        System.out.println("\"" + ke.getKeyChar() + "\" is typed.");
        // this.program_starts = !this.program_starts;
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}
