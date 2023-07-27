/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

/**
 *
 * @author xhu
 */


public class Node <E> {
    
    E data;
    Node <E> next;
    
    public boolean equals(Node node)
    {
        return false;
    }
    
    public int compareTo(Node node)
    {
        return 0;
    }
    
    public String toString(){
        return "Data: " + data + " ";
    }
}
