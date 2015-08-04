package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by datse on 4/08/2015.
 */
public class VanyaAndLanterns {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] lights = new int[n];
        int length = in.nextInt();
        int diff = 0;
        for(int i=0; i<n; i++) {
            int input = in.nextInt();
            lights[i] = input;
        }

        Arrays.sort(lights);

        int pre = 0;
        boolean hasLightOnZero = false;
        for(int i=0; i<n; i++) {
            // when there is only one ...
            if(n == 1) {
                if(lights[i] == 0 || lights[i] == length) {
                    diff = 2 * length;
                } else {
                    diff = Math.max(diff, 2 * Math.abs(lights[i]));
                    diff = Math.max(diff, 2 * Math.abs(length - lights[i]));
                }
            // When it is the last one...
            } else if(i == n-1) {
                // ... and before length pos
                diff = Math.max(diff, Math.abs(lights[i] - pre));
                diff = Math.max(diff, 2 * Math.abs(lights[i] - length));
            } else {
                if(pre == 0 && !hasLightOnZero) {
                    diff = Math.max(diff, 2 * Math.abs(lights[i] - pre));
                } else {
                    diff = Math.max(diff, Math.abs(lights[i] - pre));
                }
            }
            if(lights[i] == 0) {
                hasLightOnZero = true;
            }
            pre = lights[i];
        }
        System.out.println(diff/2.0);

    }

}
