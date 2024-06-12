package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 20/07/2015.
 */
public class StringTask {

//    Vowels are letters "A", "O", "Y", "E", "U", "I", and the rest are consonants.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        char[] chars = input.toCharArray();
        for(int i=0; i<chars.length; i++) {
            char c = chars[i];
            if(!(c == 65 || c==69 || c==73 || c==79 || c==85 || c==89 ||
                    c==97 || c==101 || c==105 || c==111 || c==117 || c==121)) {
                System.out.print('.');
                System.out.print(Character.isUpperCase(c)?Character.toLowerCase(c):c);
            }
        }

    }

}
