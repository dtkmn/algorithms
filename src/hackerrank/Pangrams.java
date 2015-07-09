package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by dtkmn on 9/07/2015.
 */
public class Pangrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.trim().toLowerCase().replace(" ","");
        char[] chars = str.toCharArray();
        Set<Character> seq = new HashSet<>();

        for(char c: chars) {
            if(c >= 97 && c <= 122) {
                seq.add(c);
            }
        }

        if(seq.size() == 26) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }

}
