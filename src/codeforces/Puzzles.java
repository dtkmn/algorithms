package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 22/07/2015.
 */
public class Puzzles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int students = in.nextInt();
        int puzzlesCount = in.nextInt();
        int[] puzzles = new int[puzzlesCount];
        // save it to array
        for(int i=0; i<puzzles.length; i++) {
            puzzles[i] = in.nextInt();
        }
        //sort it
        for(int x=0; x<puzzles.length-1; x++) {
            for(int y=x+1; y<puzzles.length; y++) {
                if(puzzles[x] > puzzles[y]) {
                    int temp = puzzles[x];
                    puzzles[x] = puzzles[y];
                    puzzles[y] = temp;
                }
            }
        }


        // check every range (num of students)
        int minRange = 1000;
        for(int p=0; p<puzzles.length; p++) {
            if((p + students - 1)<puzzles.length) {
                int range = Math.abs(puzzles[p] - puzzles[p + students - 1]);
                if(range < minRange) {
                    minRange = range;
                }
            }
        }
        System.out.println(minRange);

    }

}
