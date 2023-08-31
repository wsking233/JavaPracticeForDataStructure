/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
Which object have you chosen as a monitor object to synchronize your code?
Answer: I chose the port object as a monitor object.


Why did you choose that object as a monitor oject to synchronize your code?
Answer: Because there is only one port object instance, and all the ships need to reach the port.

*/

package Question_3;

/**
 *
 * @author xhu
 */
public class Ship implements Runnable {
    int x;
    int y;
    String name = "Ship";
    Port target;
    boolean arrived = false;
    boolean syncMode = false;

    public Ship(int x, int y, Port port) {
        this.x = x;
        this.y = y;
        this.target = port;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " is running");
        if (syncMode) { // if sync mode is on, use synchronized block
            synchronized (target) {
                updateStatus();
                // notifyAll();
            }
        } else {
            updateStatus();
        }

        // move();
        // release the port after the ship arrives
        releasePort();
    }

    public void move() {
        // move the ship to the port
        while (x != target.x || y != target.y) {
            if (this.x < target.x) {
                this.x++;
            } else if (this.x > target.x) {
                this.x--;
            }
            if (this.y < target.y) {
                this.y++;
            } else if (this.y > target.y) {
                this.y--;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        this.arrived = true;

    }

    private void updateStatus() {
        if (!this.arrived) {
            this.target.occupied = false;
            move();
        }
        this.target.occupied = true;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void releasePort() {
        this.target.occupied = false;
        this.arrived = true;
    }
}
