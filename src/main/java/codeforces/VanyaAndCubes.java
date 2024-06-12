package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 23/07/2015.
 */
public class VanyaAndCubes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cubes = in.nextInt();
        int height = 0;
        int num = 1;
        int require = 1;
        while(cubes >= require) {
            cubes -= require;
            height++;
//            System.out.println(cubes + ":" + require + ":" + height);
            require += (++num);
        }
        System.out.println(height);

    }

}
