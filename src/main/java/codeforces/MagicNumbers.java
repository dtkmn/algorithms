package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dtkmn on 24/08/2015.
 */
public class MagicNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        if(input.charAt(0) != '1') {
            System.out.println("NO");
            return;
        }

        if(input.contains("444")) {
            System.out.println("NO");
            return;
        }

        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) != '4' &&
                    input.charAt(i) != '1') {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }

}
