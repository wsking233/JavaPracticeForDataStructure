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
public class Ship implements Runnable{
    int x;
    int y;
    String name = "Ship";
    Port targePort;
    boolean moving = false;
    boolean arraived = false;
    boolean syncMode = false;
    
    public Ship(int x, int y, Port port)
    {
        this.x = x;
        this.y = y;
        this.targePort = port;
    }    

    public void move(){
        //move the ship to the target port location
        //go left
        if(this.x < targePort.x){
            this.x++;
        }
        if(this.y < targePort.y){
            this.y++;
        }
        //go right
        if(this.x > targePort.x){
            this.x--;
        }
        if(this.y > targePort.y){
            this.y--;
        }
    }

    @Override
    public void run() {
        while(true){
            if(syncMode){
                synchronized(targePort){
                    move();
                    if(this.x == targePort.x && this.y == targePort.y){
                        //if the ship is at the port, then notify other ships
                        //that the port is available
                        targePort.notifyAll();
                    }
                }
            }else{
                move();
            }
        }
    }
}
