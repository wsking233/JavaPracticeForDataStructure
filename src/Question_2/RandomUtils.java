/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_2;

import java.awt.Point;
import java.util.Random;

/**
 * @author William Wang
 * @studnetID 18017970
 */
public class RandomUtils {

    private static final Random RAND = new Random();
    private static final int MAX_SIZE = 700;

    public static int getRandomInt(int bound) {

        return RAND.nextInt(bound);
    }

    public static Point getRandomPoint() {
        int x = getRandomIntInRange(0, MAX_SIZE);
        int y = getRandomIntInRange(0, MAX_SIZE);
        Point point = new Point(x, y);
        return point;
    }

    public static int getRandomIntInRange(int min, int max) {
        int randomNumberInRange = RAND.nextInt(max - min + 1) + min;
        return roundToNearestMultipleOfTen(randomNumberInRange);
    }

    private static int roundToNearestMultipleOfTen(int number) {
        return (int) Math.round(number / 10.0) * 10;
    }

}
