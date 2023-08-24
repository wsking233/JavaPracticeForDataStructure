/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;
//import Question_1.LinkedList;

//import Question_1.Node;
import java.awt.Point;

/**
 *
 * @author xhu
 */
public class Snake {

    private SnakeBody head;
    private int direction;
    private int score;
    private int speed;
    private int timer;
    private int size;

    public Snake(String init_snake, int x, int y) {
        // init snake with init_snake
        this.direction = 0;
        this.size = 0;
        this.score = 0;
        this.speed = 300;
        this.timer = speed;

        this.head = new SnakeBody(init_snake.charAt(0), new Point(x, y));

        for (int i = 1; i < init_snake.length(); i++) {
            this.eat(new SnakeBody(init_snake.charAt(i)));
            this.score--;    //init score to 0
        }
    }

    public void run() {
        // move the snake
        if (timer == 0) {
            timer = speed;
            move();
        } else {
            timer--;
        }
    }

    public void move() {
        // System.out.println("the head location is: " + head.getLocation());

        // make body follow the prev node;
        // Point prevLocation = head.getLocation();
        Point prevLocation = new Point(head.getLocation());
        SnakeBody currentBody = head.getNext();
        while (currentBody != null) {
            // Point tempLocation = currentBody.getLocation();
            Point tempLocation = new Point(currentBody.getLocation());

            currentBody.setLocation(prevLocation);
            prevLocation = tempLocation;

            currentBody = currentBody.getNext();
        }

        // move the head
        switch (this.direction) {
            case 0: // right
                // head.setX(head.getX() + 10);
                head.setLocation(head.getLocation().x + 10, head.getLocation().y);
                break;
            case 1: // left
                // head.setX(head.getX() - 10);
                head.setLocation(head.getLocation().x - 10, head.getLocation().y);

                break;
            case 2: // up
                // head.setY(head.getY() - 10);
                head.setLocation(head.getLocation().x, head.getLocation().y - 10);

                break;
            case 3: // down
                // head.setY(head.getY() + 10);
                head.setLocation(head.getLocation().x, head.getLocation().y + 10);

                break;
        }

    }

    public void eat(SnakeBody food) {
        // add a new body at the end of snake body
        if (head == null) {
            head = food;
        } else {
            SnakeBody tail = this.getTail();
            tail.setNext(food);
            food.setPrev(tail);
            food.setLocation(tail.getLocation());

        }

        this.score++;
        this.size++;
    }

    public void hitsNumber(SnakeBody number) {
        // remove the Tail if the number bigger than length of snake
        int index = Integer.parseInt(String.valueOf(number.getBody()));
        System.out.println("index is: " + index);
        
        if(index <= 0 || index >= size){
            this.removeFromTail();
        }else{
            this.remove(index --);
        }
        
    }

    public void setBounder() {
        // set the bounder for snake, if snake hits the bounder it goes to the other
        // side
        // get bounder
        if (head.getLocation().x > 790) {
            head.setX(0);
        }
        if (head.getLocation().x < 0) {
            head.setX(790);
        }
        if (head.getLocation().y > 790) {
            head.setY(0);
        }
        if (head.getLocation().y < 0) {
            head.setY(790);
        }
    }

    // snake methods until here.
    // ------------------------------------
    // linked list methods from here:
    public SnakeBody getTail() {
        return this.getTail(head);
    }

    private SnakeBody getTail(SnakeBody node) {
        if (node.getNext() == null) {
            return node;
        } else {
            return this.getTail(node.getNext());
        }
    }

    public void remove(int position) {
        // remove the body at index number
        if(position > size -1){
            removeFromTail();
        }else{
            this.removeByIndex(head, position);
        }
    }

    private void removeByIndex(SnakeBody node, int position) {
        // remove the body at index number
        if (position > 0) {
            this.removeByIndex(node.getNext(), --position);
        } else {
            // remove the node
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            
        }
    }

    private void removeFromTail() {
        // remove the tail
        if (head == null) {
            size = 0;
        } else {
            SnakeBody tail = this.getTail();
            tail.getPrev().setNext(null);
            tail.setPrev(null);
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setDircetion(int direction) {
        this.direction = direction;
    }

    public int getScore() {
        return this.score;
    }

    public int getSize() {
        return this.size;
    }

    public String toString() {
        // return the snake body
        String result = "";
        SnakeBody body = this.head;
        while (body != null) {
            result += body.getBody();
            body = body.getNext();
        }
        return result;
    }

    public SnakeBody getHead() {
        return this.head;
    }

}
