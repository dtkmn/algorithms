package codechef;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class LifeTheUniverseAndEverything {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            int input = in.nextInt();
            if(input != 42) {
                System.out.println(input);
            } else {
                break;
            }
        }
    }

}
