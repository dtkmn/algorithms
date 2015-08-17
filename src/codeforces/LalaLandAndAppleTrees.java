package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 17/08/2015.
 */
public class LalaLandAndAppleTrees {

    static class Tree implements Comparable<Tree> {
        int pos;
        int apples;

        @Override
        public int compareTo(Tree that) {
            return this.pos > that.pos?1:-1;
        }

//        @Override
//        public String toString() {
//            return "Tree{" +
//                    "pos=" + pos +
//                    ", apples=" + apples +
//                    '}';
//        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int negativeCount = 0, positiveCount = 0;
        int negativeApple = 0, positiveApple = 0;

        Tree[] posList = new Tree[n];
        Tree[] negList = new Tree[n];

        for(int i=0; i<n; i++) {
            int pos = in.nextInt();
            int apples = in.nextInt();
            if(pos > 0) {
                positiveApple += apples;
                Tree t = new Tree();
                t.pos = pos;
                t.apples = apples;
                posList[positiveCount++] = t;
            }
            else {
                negativeApple += apples;
                Tree t = new Tree();
                t.pos = -pos;
                t.apples = apples;
                negList[negativeCount++] = t;
            }
        }

        Arrays.sort(posList, 0, positiveCount);
        Arrays.sort(negList, 0, negativeCount);
//        System.out.println(Arrays.toString(posList));
//        System.out.println(Arrays.toString(negList));
//        System.out.println(positiveCount);
//        System.out.println(negativeCount);

        if(positiveCount == negativeCount) {
            System.out.println(positiveApple+negativeApple);
        } else if(positiveCount > negativeCount) {
            int sum = 0;
            for(int i=0; i<negativeCount+1; i++) {
                sum += posList[i].apples;
            }
            System.out.println(sum+negativeApple);
        } else {
            int sum = 0;
            for(int i=0; i<positiveCount+1; i++) {
                sum += negList[i].apples;
            }
            System.out.println(sum+positiveApple);
        }

    }

}
