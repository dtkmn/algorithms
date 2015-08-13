package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 13/08/2015.
 */
public class Lecture {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfWord = in.nextInt();
        int numberOfWordEach = in.nextInt();
        String[] words = new String[numberOfWordEach*2];
        for(int i=0; i<words.length; i++) {
            words[i] = in.next();
        }
        for(int j=0; j<numberOfWord; j++) {
            String word = in.next();
            for(int i=0; i<words.length; i++) {
                if(word.equals(words[i])) {
                    if(i%2 == 0) {
                        if(words[i].length() <= words[i+1].length()) {
                            System.out.print(words[i] + " ");
                        } else {
                            System.out.print(words[i+1] + " ");
                        }
                    } else {
                        if(words[i].length() >= words[i-1].length()) {
                            System.out.print(words[i-1] + " ");
                        } else {
                            System.out.print(words[i] + " ");
                        }
                    }
                }
            }
        }
    }

}
