/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;
//import Question_1.LinkedList;

//import Question_1.Node;
//import java.util.LinkedList;
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
        this.speed = 400;
        this.timer = speed;

        for (int i = 0; i < init_snake.length(); i++) {
            eat(new SnakeBody(init_snake.charAt(i)));
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
        //make body follow the prev node;
//        int prevX = head.getX();
//        int prevY = head.getY();

        Point prevPoint = head.getLocation();

        SnakeBody currentBody = head.getNext();
        while (currentBody != null) {
//
//            int tempX = currentBody.getX();
//            int tempY = currentBody.getY();

            Point tempLocation = currentBody.getLocation();

            currentBody.setLocation(prevPoint.x, prevPoint.y);
//            currentBody.setX(prevX);
//            currentBody.setY(prevY);

            prevPoint = tempLocation;
//            prevX = tempX;
//            prevY = tempY;

            currentBody = currentBody.getNext();
        }
        // move the head
        switch (this.direction) {
            case 0: // right
                head.setLocation(head.getLocation().x + 10, head.getLocation().y);
                break;
            case 1: // left
                head.setLocation(head.getLocation().x - 10, head.getLocation().y);
//                head.setX(head.getX() - 10);
                break;
            case 2: // up
                head.setLocation(head.getLocation().x, head.getLocation().y - 10);
//                head.setY(head.getY() - 10);
                break;
            case 3: // down
                head.setLocation(head.getLocation().x, head.getLocation().y + 10);
//                head.setY(head.getY() + 10);
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
//            food.setLocation(tail.getLocation().x, tail.getLocation().y);
//            food.setX(tail.getX());
//            food.setY(tail.getY());
        }
        this.size++;
    }

    public void hitsNumber(SnakeBody number) {
        // remove the Tail if the number bigger than length of snake
        int index = Integer.parseInt(String.valueOf(number.getBody()));
        System.out.println("index is: " + index);
        
        if (index >= this.size - 1) {
            this.removeFromTail();
        } else {
            // remove the body at index number
            this.remove(index);
        }
        this.size--;
    }

    public void setBounder() {
        // set the bounder for snake, if snake hits the bounder it goes to the other
        if (head.getLocation().x > 780) {
            head.setLocation(20, head.getLocation().y);
        }
        if (head.getLocation().x < 20) {
            head.setLocation(780, head.getLocation().y);

        }
            if(head.getLocation().y > 780)
        {
             head.setLocation(head.getLocation().x, 20);

        }
        if (head.getLocation().y < 0) {
            head.setLocation(head.getLocation().x, 780);
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
        if(position > size){
            removeFromTail();
        }else{
            this.removeByIndex(head, position);
        }
    }

    private void removeByIndex(SnakeBody node, int position) {
        if (position > 0) {
            this.removeByIndex(head.getNext(), --position);
        } else {
            head.setNext(head.getNext().getNext());
        }
    }

    public void removeFromTail() {
        // remove the tail
        if (head == null) {
            size = 0;
        } else {
            SnakeBody tail = this.getTail();
            tail.getPrev().setNext(null);
            tail.setPrev(null);
            size--;
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
