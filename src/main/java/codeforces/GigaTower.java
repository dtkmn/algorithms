package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 20/08/2015.
 */
public class GigaTower {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int process = input;
        boolean found = false;
        while(!found) {
            process++;
            String v = String.valueOf(process);
            for(int i=0; i<v.length(); i++) {
                if(v.charAt(i) == '8') {
                    found = true;
                    break;
                }
            }
        }
        System.out.println(process-input);
    }

}
