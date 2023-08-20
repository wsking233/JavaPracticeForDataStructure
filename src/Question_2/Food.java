/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_2;

/**
 *
 * @author wskin
 */
public class Food {

    private char letter;
    private int x;
    private int y;

    public Food(char letter) {
        this.letter = letter;
        randomPosition();
    }

    public void randomPosition() {
        this.x = RandomUtils.getRandomInt(700);
        this.y = RandomUtils.getRandomInt(700);
    }

    public char getLetter() {
        return letter;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

}
