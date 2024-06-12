package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 6/08/2015.
 */
public class FedorAndNewGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int typeOfSoliders = in.nextInt();
        int players = in.nextInt() + 1;
        int mostDiff = in.nextInt();
        int fedor = 0;
        int[] friends = new int[players];
        for(int i=1; i<=players; i++) {
            if(i == players) {
                fedor = in.nextInt();
            } else {
                friends[i] = in.nextInt();
            }
        }
        String me = Integer.toBinaryString(fedor);
        int friendNum = 0;
        for(int i=1; i<players; i++) {
            String compare = Integer.toBinaryString(friends[i]);
            if(me.length() > compare.length()) {
                compare = generateZero(me.length()-compare.length()) + compare;
            } else if(me.length() < compare.length()){
                me = generateZero(compare.length()-me.length()) + me;
            }
            // Doing comparison here
            int count = 0;
            for(int m=0; m<me.length(); m++) {
                if(me.charAt(m) != compare.charAt(m)) {
                    count++;
                }
            }
            if(count <= mostDiff) friendNum++;
        }
        System.out.println(friendNum);

    }

    static String generateZero(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

}
