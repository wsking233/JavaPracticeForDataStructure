/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
Which object have you chosen as a monitor object to synchronize your code?



Why did you choose that object as a monitor oject to synchronize your code?


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

    public Ship(int x, int y, Port port) {
        this.x = x;
        this.y = y;
        this.target = port;
    }

    public void move() {
        // move the ship to the port
        if (this.x < target.x) {
            this.x++;
        } else if (this.x > target.x) {
            this.x--;
        }
        // if (this.y < target.y) {
        //     this.y++;
        // } else if (this.y > target.y) {
        //     this.y--;
        // }

    }

    @Override
    public void run() {
        while (!arrived) {
            move();
            System.out.println("Thread: " + Thread.currentThread().getName() + " is running");
            if(x == target.x && y == target.y){
                Thread.currentThread().interrupt();
                arrived = true;
            }

            // try {
            //     Thread.sleep(100);
            // } catch (InterruptedException e) {
            //     System.out.println(e.getMessage());
            // }
        }
    }
}
