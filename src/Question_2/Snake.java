/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;
import Question_1.LinkedList;

/**
 *
 * @author xhu
 */
public class Snake {
    
    private LinkedList<Character> snak;
    private int headX;
    private int headY;
    
    public Snake(String init_snake, int x, int y)
    {
        this.snak = new LinkedList<>();
        this.headX = x;
        this.headY = y;
    }       

    public void run()
    {
       
    }   
    
    public void eat(char food){
        this.snak.add(food);
    }
    
    public void hitsNumber(int number){
        if(number <= snak.size){
            this.snak.remove(number-1);
        }else{
            this.snak.removeFromTail();
        }
    }
    
    public LinkedList<Character> getSnak(){
        return this.snak;
    }
}
