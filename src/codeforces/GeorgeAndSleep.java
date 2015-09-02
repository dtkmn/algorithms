package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 2/09/2015.
 */
public class GeorgeAndSleep {

    // 00 <= hh <= 23
    // 00 <= mm <= 59
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String wokeupTime = in.next();
        String sleepingTime = in.next();

        String[] hhmmWokeupTime = wokeupTime.split(":");
        int wokeupValue = Integer.valueOf(hhmmWokeupTime[0]) * 100 +
                Integer.valueOf(hhmmWokeupTime[1]);
        String[] hhmmSleepingTime = sleepingTime.split(":");
        int sleepingValue = Integer.valueOf(hhmmSleepingTime[0]) * 100 +
                Integer.valueOf(hhmmSleepingTime[1]);

        int resultValue = wokeupValue - sleepingValue;
        int hh = resultValue/100;
        int mm = Math.abs(resultValue%100);

        System.out.println(resultValue);
        System.out.println(hh + " " + mm);

//         00:00
//         13:12
        // -----
        // 10:48
        if(resultValue < 0) {
            if(hh != 0) {
                hh = 24 + hh;
                mm = 60 + mm;
            } else {
                hh = sleepingValue/100;
                mm = 60 + mm;
            }
            // When mins sum is equal to 60, can minus 1 to current hour value
//            if(mm + sleepingValue%100 == 60) {
//                hh--;
//            }
            System.out.println( (hh<10?"0"+hh:hh) + ":" + (mm<10?"0"+mm:mm) );
        } else {
            System.out.println( (hh<10?"0"+hh:hh) + ":" + (mm<10?"0"+mm:mm) );
        }
    }

}
