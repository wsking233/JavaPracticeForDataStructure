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

    static boolean shipMoving = false;

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
            }
        } else {
            updateStatus();
        }
    }

    public void move() {
        //before moving, check if the port is occupied
        shipMoving = true;
        this.target.occupied = false;
        System.out.println(Thread.currentThread().getName() + " is moving");
        
        // move the ship to the port
        while (x != target.x || y != target.y) {    // if the ship has not arrived
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
                Thread.sleep(2);    //slow down the speed
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void relasePort() {
        // after the ship arrives
        shipMoving = false;
        this.arrived = true;
        this.target.occupied = true;
        System.out.println(Thread.currentThread().getName() + " has arrived at the port");

        try {
            Thread.sleep(1000);     // wait for 1 sec when the ship arrives
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // release the port after 1sec the ship arrives
        this.target.occupied = false;
    }

    private void updateStatus() {

        while (!this.arrived) { // if the ship has not arrived, keep moving
            if (!shipMoving) { // check if other ships are moving
                move();
            }
            if(x == target.x && y == target.y){
                relasePort();
            }
        }
    }
}

