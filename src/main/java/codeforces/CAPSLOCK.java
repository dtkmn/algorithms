package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class CAPSLOCK {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = in.next();

        if(input.length() == 1 && Character.isLowerCase(input.charAt(0))) {
            System.out.println(input.toUpperCase());
            return;
        }

        boolean change = true;
        char[] charArray = input.toCharArray();
        for(int i=1; i<charArray.length; i++) {
            if(!Character.isUpperCase(charArray[i])) {
                change = false;
            }
        }

        if(change) {
            char c = Character.isUpperCase(input.charAt(0))?
                    Character.toLowerCase(input.charAt(0)):
                    Character.toUpperCase(input.charAt(0));
            System.out.println(c + input.substring(1).toLowerCase());
        } else {
            System.out.println(input);
        }


    }

}
