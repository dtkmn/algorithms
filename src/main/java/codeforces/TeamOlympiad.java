package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 1/08/2015.
 */
public class TeamOlympiad {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] students = new int[n+1];
        int[] count = new int[4];
        count[0] = -1;
        for(int i=1; i<=n; i++) {
            int subject = in.nextInt();
            students[i] = subject;
            count[subject]++;
        }

        Arrays.sort(count);
        System.out.println(count[1]);
        // number of teams
        int teams = count[1];
        int[][] teamarray = new int[teams][3];
        int count1 = 0, count2 = 0, count3 = 0;
        for(int m=1; m<=n; m++) {
            if(students[m] == 1) {
                if(count1 < teams)
                    teamarray[count1++][0] = m;
            } else if(students[m] == 2) {
                if(count2 < teams)
                    teamarray[count2++][1] = m;
            } else if(students[m] == 3) {
                if(count3 < teams)
                    teamarray[count3++][2] = m;
            }
        }

        for(int p=0; p<teams; p++) {
            System.out.print(teamarray[p][0] + " ");
            System.out.print(teamarray[p][1] + " ");
            System.out.print(teamarray[p][2]);
            System.out.println();
        }

    }

}
