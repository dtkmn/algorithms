package leetcode;

/**
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 *
 */
public class AngleBetweenHandsOfAClock {

    public static double angleClock(int hour, int minutes) {
        // double hourPtr = 360 / 12.0 * (hour % 12) + 30.0 * minutes / 60;
        // double minPtr = 360 / 60.0 * minutes;
        double hourPtr = 30.0 * (hour % 12) + minutes / 2.0;
        double minPtr = 6.0 * minutes;
        double diff = Math.abs(hourPtr - minPtr);
        return Math.min(diff, 360 - diff);
    }

    public static void main(String[] args) {
        System.out.println(angleClock(3, 15));
        System.out.println(angleClock(4, 50));
    }

}
