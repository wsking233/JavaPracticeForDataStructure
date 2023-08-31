package Question_2;

import java.awt.Point;


/*
 * @author William Wang
 * @studnetID 18017970
* this class is used to represent the body of the snake
* it contains the body character, the x and y coordinates of the body
* and the previous and next body
* 
*/

public class SnakeBody {

    // the previous and next body of the snake
    private char body;
    private SnakeBody prev;
    private SnakeBody next;
    private Point location;     // the location of the body

    public SnakeBody(char body){
        this.body = body;
    }
    
    public SnakeBody(char body, Point location){
        this.body = body;
        this.location = location;
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
    
    public void setLocation(int x, int y){
        this.location.x = x;
        this.location.y = y;
    }
    public void setLocation(Point point){
        this.location = point;
    }
    
    public void setX(int x){
        this.location.x = x;
    }
    
    public void setY(int y){
        this.location.y = y;
    }
    
    public Point getLocation(){
        return this.location;
    }

    @Override
    public String toString() {
        return String.valueOf(this.body);
    }

}
