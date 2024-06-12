package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 9/07/2015.
 */
public class FunnyString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            String input = in.next();
            boolean funny = true;
            char[] chars = input.toCharArray();
            for(int j=0; j<chars.length/2; j++) {
                if(! (Math.abs(chars[j]-chars[j+1])
                        == Math.abs(chars[chars.length-1-j]-chars[chars.length-1-j-1]))) {
                    funny = false;
                    break;
                }
            }
            System.out.println(funny?"Funny":"Not Funny");
        }
    }

}
