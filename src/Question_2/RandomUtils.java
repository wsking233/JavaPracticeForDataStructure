/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_2;

import java.util.Random;

/**
 *
 * @author wskin
 */
public class RandomUtils {

    private static final Random rand = new Random();

    public static int getRandomInt(int bound) {
        
        return rand.nextInt(bound);
    }

    public static int getRandomIntInRange(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

}
