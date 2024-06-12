package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 24/07/2015.
 */
public class Buttons {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int button = in.nextInt();
        int count = 0;
        for(int i=1; i<button; i++) {
            count += i * (button-i);
        }
        System.out.println(count+button);
    }


}
