package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by datse on 26/08/2015.
 */
public class SortTheArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] original = new int[size];
        for(int i=0; i<size; i++) {
            original[i] = in.nextInt();
        }

        int pre = original[0];
        int prePos = 0;
        int startDesPos = -1;
        int startIncPos = -1;
        int count = 0;
        int resetCount = 0;
        String output = "";
        for(int i=1; i<size; i++) {
            if(original[i] < pre && startDesPos == -1) {
                startDesPos = prePos;
            } else if(startDesPos != -1 && original[i] > pre){
                // one of the minimum point here
                if(original[startDesPos] < original[i]) {
                    if(++count > 1) {
                        System.out.println("no");
                        return;
                    } else {
                        output = (startDesPos+1) + " " + (prePos+1);
                        startDesPos = -1;
                        resetCount++;
                    }
                } else {
                    System.out.println("no");
                    return;
                }
            }
//            else if(i == size-1 && startDesPos != -1) {
//                // decreasing till the end
//                output = (startDesPos+1) + " " + (i+1);
//            }
            pre = original[i];
            prePos = i;
        }

        System.out.println("yes");
        if(resetCount == 0 && startDesPos == -1) {
            // keep increasing, no decreasing
            System.out.println("1 1");
        } else if(startDesPos != -1) {
            System.out.println((startDesPos+1) + " " + (size));
        } else {
            System.out.println(output);
        }
    }

}
