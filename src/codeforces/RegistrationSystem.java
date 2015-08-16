package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 17/08/2015.
 */
public class RegistrationSystem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String db = "";
        for(int i=0; i<N; i++) {
            String name = in.next();
            if(db.indexOf(":" + name + ":") == -1) {
                db += ":" + name + ":";
                System.out.println("OK");
            } else {
                int count = 1;
                while(db.indexOf(":" + name + count + ":") != -1) {
                    count++;
                }
                db += ":" + name + count + ":";
                System.out.println(name + count);
            }
        }
    }

}
