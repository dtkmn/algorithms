package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 7/08/2015.
 */
public class ValeraAndX {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] inputs = new String[n];

        for(int i=0; i<n; i++) {
            inputs[i] = in.next();
        }

        char x = ' ', rest = ' ';
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j || i+j==n-1) {
                    if(x == ' ') x = inputs[i].charAt(j);
                    else {
                        if(x != inputs[i].charAt(j)) {
                            System.out.println("NO");
                            return;
                        }
                    }
                } else {
                    if(rest == ' ') rest = inputs[i].charAt(j);
                    else {
                        if(rest != inputs[i].charAt(j)) {
                            System.out.println("NO");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(x != rest?"YES":"NO");
    }

}
