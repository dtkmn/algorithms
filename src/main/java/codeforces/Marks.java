package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 2/09/2015.
 */
public class Marks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfStudent = in.nextInt();
        int numOfSubjects = in.nextInt();

        String[] gradebooks = new String[numOfStudent];
        char[] maxScoreForSubjects = new char[numOfSubjects];
        int[] getMaxStudent = new int[numOfStudent];

        for(int i=0; i<numOfStudent; i++) {
            String grade = in.next();
            gradebooks[i] = grade;
        }

        for(int i=0; i<numOfStudent; i++) {
            for(int j=0; j<numOfSubjects; j++) {
                maxScoreForSubjects[j] = (char) Math.max(gradebooks[i].charAt(j), maxScoreForSubjects[j]);
            }
        }

        for(int i=0; i<numOfStudent; i++) {
            for (int j = 0; j < numOfSubjects; j++) {
                if(gradebooks[i].charAt(j) == maxScoreForSubjects[j]) {
                    getMaxStudent[i]++;
                }
            }
        }

        int count = 0;
        for(int i=0; i<numOfStudent; i++) {
            if(getMaxStudent[i] > 0) {
                count++;
            }
        }

        System.out.println(count);

    }

}
