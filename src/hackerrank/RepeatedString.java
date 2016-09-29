package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class RepeatedString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s = br.readLine();
        long n = Long.parseLong(br.readLine());
        int len = s.length();
        long count = 0;
        if(n <= len) {
            for(int i=0; i<n; i++) {
                if('a' == s.charAt(i)) count++;
            }
        } else {
            int countEachPair = 0;
            for(int i=0; i<len; i++) {
                if('a' == s.charAt(i)) countEachPair++;
            }
            long restStringNumber = n%len;
            for(int j=0; j<restStringNumber; j++) {
                if('a' == s.charAt(j)) count++;
            }
            count += countEachPair*(n/len);
        }

        System.out.println(count);
    }

}
