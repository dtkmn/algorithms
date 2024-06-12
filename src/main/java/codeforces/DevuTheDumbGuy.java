package codeforces;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by datse on 25/08/2015.
 */
public class DevuTheDumbGuy {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int subjectCount = in.nextInt();
        int learningTime = in.nextInt();
        int[] subjects = new int[subjectCount];
        for(int i=0; i<subjectCount; i++) {
            subjects[i] = in.nextInt();
        }
        Arrays.sort(subjects);

        BigInteger time = BigInteger.valueOf(0);
        for(int i=0; i<subjectCount; i++) {
//            time += subjects[i] * learningTime;
            time = time.add(BigInteger.valueOf(subjects[i] * learningTime));
            if(learningTime>1) learningTime--;
        }
        System.out.println(time);

//        System.out.println();
//        System.out.println(Long.MAX_VALUE);
    }

}

/*
161958119012589
9223372036854775807
 */