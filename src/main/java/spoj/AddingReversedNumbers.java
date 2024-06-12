package spoj;

import java.util.Scanner;

/**
 * Created by dtkmn on 26/07/2015.
 */
public class AddingReversedNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i=0; i<N; i++) {
            String a = in.next();
            String b = in.next();
            int sum = reverse(a) + reverse(b);
            System.out.println(reverse(sum+""));
        }
    }

    static int reverse(String n) {
        String reverse = "";
        for(int i=n.length()-1; i>=0; i--) {
            reverse += n.charAt(i);
        }
        return Integer.valueOf(reverse);
    }

}
