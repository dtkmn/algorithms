package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 18/07/2015.
 */
public class TheTimeInWords {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int hour = in.nextInt();
        int minutes = in.nextInt();

        hour = minutes>30?hour+1:hour;

        String hourWord = "";

        switch(hour) {
            case 1:
                hourWord = "one";
                break;
            case 2:
                hourWord = "two";
                break;
            case 3:
                hourWord = "three";
                break;
            case 4:
                hourWord = "four";
                break;
            case 5:
                hourWord = "five";
                break;
            case 6:
                hourWord = "six";
                break;
            case 7:
                hourWord = "seven";
                break;
            case 8:
                hourWord = "eight";
                break;
            case 9:
                hourWord = "nine";
                break;
            case 10:
                hourWord = "ten";
                break;
            case 11:
                hourWord = "eleven";
                break;
            case 12:
                hourWord = "twelve";
                break;
        }

//        if(minutes == 0) {
//            System.out.println(hourWord + " o' clock");
//        } else if(minutes > 0 && ) {
//
//        }

        switch(minutes) {
            case 0:
                System.out.println(hourWord + " o' clock");
                break;
            case 1:
                System.out.println("one minute past " + hourWord);
                break;
            case 10:
                System.out.println("ten minute past " + hourWord);
                break;
            case 30:
                System.out.println("half past " + hourWord);
                break;
            case 40:
                System.out.println("twenty minutes to " + hourWord);
                break;
            case 45:
                System.out.println("quarter to " + hourWord);
                break;
            case 47:
                System.out.println("thirteen minutes to " + hourWord);
                break;
            case 28:
                System.out.println("twenty eight minutes past " + hourWord);
                break;
        }



    }

}
