package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 20/07/2015.
 */
public class Taxi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] index = new int[5];

        for(int i=0; i<n; i++) {
            index[in.nextInt()]++;
        }

        int taxi = index[4];

        if(index[3] > 0) {
            if(index[1] == 0) {
                taxi += index[3];
            } else {
                if(index[3] >= index[1]) {
                    int num1 = index[1];
                    taxi += num1;
                    index[1] = 0;
                    taxi += (index[3] - num1);
                } else {
                    int num3 = index[3];
                    taxi += num3;
                    index[1] = index[1] - num3;
                }
            }
        }

        if(index[2] > 0) {
            int num2 = index[2];
            while (num2 * 2 / 4 > 0) {
                num2 = num2 - 2;
                taxi++;
            }
            index[2] = num2;
        }

        int last = index[2] * 2 + index[1];
        if(last%4==0) {
            taxi += last / 4;
        } else {
            taxi += (last / 4 + 1);
        }

        System.out.println(taxi);

    }

}
