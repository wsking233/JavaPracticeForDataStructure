/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

/**
 * @author William Wang
 * @studnetID 18017970
 */
public class Port {
    
    int x;
    int y;
    String name = "Port";
    boolean occupied;   //if a ship already arrived, occupied
    
    public Port(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.occupied = false;
        
    }
}
