package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/07/2015.
 */
public class EquivalentStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();

        if(first.length()%2 != 0) {
            System.out.println(first.equals(second)?"YES":"NO");
        } else {

            String firstHalf = first.substring(0, first.length()/2);
            String firstOther = first.substring(first.length()/2);

//            System.out.println(firstHalf + ":" + firstOther);

            String secondHalf = second.substring(0, second.length()/2);
            String secondOther = second.substring(second.length()/2);


//            System.out.println(secondHalf + ":" + secondOther);
            // firstHalf == secondHalf
            // firstOther == secondOther
            if(compare(firstHalf, secondHalf) && compare(firstOther, secondOther)) {
                System.out.println("YES");
                return;
            }

            // firstHalf == secondOther
            // firstOther == secondHalf
            if(compare(firstHalf, secondOther) && compare(firstOther, secondHalf)) {
                System.out.println("YES");
                return;
            }

            System.out.println("NO");


        }

    }

    static boolean compare(String first, String second) {
        for(int i=0; i<first.length(); i++) {
            char c = first.charAt(i);
            if(second.indexOf(c) != -1) {
                second = second.replace(c+"", "");
//                System.out.println(second);
            }
        }
        if(second.length() == 0) {
            return true;
        }
        return false;
    }

}
