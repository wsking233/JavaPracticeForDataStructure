/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;
//import Question_1.LinkedList;
//import Question_1.Node;

import java.util.LinkedList;


/**
 *
 * @author xhu
 */
public class Snake {
    
    private LinkedList<Character> snake;
    private int headX;
    private int headY;
    
    public Snake(String init_snake, int x, int y)
    {
        this.snake = new LinkedList<>();
        this.headX = x;
        this.headY = y;
    }       

    public void run()
    {
       
    }   
    
    public void eat(char food){
        this.snake.add(food);
    }
    
    public void hitsNumber(int number){
        if(number <= snake.size()){
            this.snake.remove(number-1);
        }else{
            this.snake.removeLast();
        }
    }
    
    public String getSnak(){
       String body = snake.toString();
       return body;
    }
    
    public int getLength(){
        return this.snake.size();
    }
}
