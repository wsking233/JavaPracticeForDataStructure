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
    
    
    private LinkedList<SnakeBody> snake;
    private int dircetion;
    private int score;
    private int speed;
    private int timer;
    
    public Snake(String init_snake, int x, int y)
    {
        //init snake with init_snake
        this.dircetion = 0;
        this.snake = new LinkedList<SnakeBody>();
        for(int i = 0; i < init_snake.length(); i++){
            snake.add(new SnakeBody(init_snake.charAt(i), x + i * 10, y));
        }
        this.score = 0;
        this.speed = 200;
        this.timer = speed;
    }

    public void run(){
        //move the snake
        if(timer == 0){
            timer = speed;
            move();
        }else{
            timer--;
        }
    }

    public void move()
    {
        //move the head
        SnakeBody head = this.snake.getFirst();
        switch(this.dircetion){
            case 0: //right
                head.setX(head.getX() + 10);
                break;
            case 1: //left
                head.setX(head.getX() - 10);
                break;
            case 2: //up
                head.setY(head.getY() - 10);
                break;
            case 3: //down
                head.setY(head.getY() + 10);
                break;
        }
        //move the body
        for(int i = 1; i < snake.size(); i++){
            SnakeBody body = snake.get(i);
            SnakeBody preBody = snake.get(i-1);
                    setBounder();

            body.setX(preBody.getX());
            body.setY(preBody.getY());
        }
        
    } 

    public void setBounder(){
        //set the bounder for snake, if snake hits the bounder it goes to the other side
        SnakeBody head = this.snake.getFirst();
        //get bounder
        if(head.getX() > 790){  //the 
            head.setX(0);
        }
        if(head.getX() < 0){
            head.setX(790);
        }
        if(head.getY() > 790){
            head.setY(0);
        }
        if(head.getY() < 0){
            head.setY(790);
        }
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public int getSpeed(){
        return this.speed;
    }
    
    public void setDircetion(int dircetion){
        this.dircetion = dircetion;
    }
    
    public void eat(char food){
        //add a new body at the end of snake body
        SnakeBody last = this.snake.getLast();
        SnakeBody newBody = new SnakeBody(food, last.getX(), last.getY());
        this.snake.add(newBody);
        this.score++;
    }
    
    public void hitsNumber(int number){
        if(number <= snake.size()){
            //remove the body at the number position
            this.snake.remove(number-1);
        }else{
            //remove the last body
            this.snake.removeLast();
        }
    }

    public int getScore(){
        return this.score;
    }
    
    public int getLength(){
        return this.snake.size();
    }

    public String toString(){
        String body = "";
        for(int i = 0; i < snake.size(); i++){
            body += snake.get(i);
        }
        return body;
    }

    public SnakeBody getHead() {
        return this.snake.getFirst();
    }
    
}
