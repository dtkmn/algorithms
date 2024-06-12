package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by datse on 5/08/2015.
 */
public class DesignTutorialLearnfromLife {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int capacity = in.nextInt();
        int[] people = new int[n];
        for(int i=0; i<n; i++) {
            people[i] = in.nextInt();
        }

        Arrays.sort(people);

        int time = 0;
        for(int i=0; i<n; i++) {
            if(i == 0) time += people[i];
            else {
                if(people[i] > people[i-1]) {
                    time += people[i] - people[i-1];
                }
            }
        }

        if(n > capacity) {
            for(int i=capacity; i<=n; i*=2) {

            }
        }

        System.out.println(time+people[n-1]);

    }

}
