package Question_2;

import java.awt.Point;


/*
*  @author William Wang
*
* this class is used to represent the body of the snake
* it contains the body character, the x and y coordinates of the body
* and the previous and next body
* 
*/

public class SnakeBody {

    // the previous and next body of the snake
    private SnakeBody prev;
    private char body;
    private SnakeBody next;
    // the x and y coordinates of the body
//    private int x;
//    private int y;
    private Point location;

    public SnakeBody(char body){
        this.body = body;
    }

    public SnakeBody(char body, int x, int y) {
        this.body = body;
        this.location.x = x;
        this.location.y = y;
//        this.x = x;
//        this.y = y;
       
    }

    public SnakeBody getPrev() {
        return prev;
    }

    public void setPrev(SnakeBody prev) {
        this.prev = prev;
    }

    public char getBody() {
        return body;
    }

    public void setBody(char body) {
        this.body = body;
    }

    public SnakeBody getNext() {
        return next;
    }

    public void setNext(SnakeBody next) {
        this.next = next;
    }

    public void setX(int i) {
//        this.x = i;
        this.location.x = i;
    }

    public void setY(int i) {
//        this.y = i;
        this.location.y = i;
    }
    
    public void setLocation(int x, int y){
        this.location.x = x;
        this.location.y = y;
    }
    
    public int getX() {
        return this.location.x;
    }

    public int getY() {
        return this.location.y;
    }
    public Point getLocation(){
        return this.location;
    }

    public String toString() {
        return String.valueOf(this.body);
    }

}
