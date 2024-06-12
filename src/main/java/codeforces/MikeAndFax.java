package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by datse on 18/08/2015.
 */
public class MikeAndFax {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int k = in.nextInt();

        if(input.length() == 1 && k == 1) {
            System.out.println("YES");
            return;
        }

        if(input.length() % k != 0 || (input.length() / k) % 2 != 0) {
            System.out.println("NO");
            return;
        }

        String[] palindrome = new String[k];
        for(int i=0; i<k; i++) {
            palindrome[i] = input.substring(i*input.length()/k, (i+1)*input.length()/k);
        }

        System.out.println(Arrays.toString(palindrome));

        for(int j=0; j<k; j++) {
            String p = palindrome[j];
            String firstHalf = p.substring(0, p.length()/2);
            String secondHalf = p.substring(p.length()/2);
            if(firstHalf.length() == secondHalf.length()) {
                for (int m = 0, n = secondHalf.length()-1; m < firstHalf.length(); m++,n--) {
                    if(firstHalf.charAt(m) != secondHalf.charAt(n)) {
                        System.out.println("NO");
                        return;
                    }
                }
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }

}
