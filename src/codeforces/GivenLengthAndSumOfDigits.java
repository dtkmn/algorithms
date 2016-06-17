package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/489/C
public class GivenLengthAndSumOfDigits {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        if(s == 0) {
            if(m == 1) System.out.println(0 + " " + 0);
            else System.out.println(-1 + " " + -1);
            return;
        } else if(s/9.0 > m) {
            System.out.println(-1 + " " + -1);
            return;
        } else if(s/9 == m) {
            // fill in all 9
            for(int i=0;i<m;i++)
                System.out.print(9);
            System.out.print(" ");
            for(int i=0;i<m;i++)
                System.out.print(9);
            return;
        }

        String minResult = "";
        if(m != 1) {
            int numberOfNine = s/9;
            int remainSum = s%9;
            if(remainSum != 0) {
                if(numberOfNine+1 == m) {
                    minResult += remainSum;
                    for (int i = 0; i < numberOfNine; i++)
                        minResult += "9";
                } else {
                    minResult += 1;
                    for (int i = 0; i < m-2-numberOfNine; i++)
                        minResult += "0";
                    minResult += remainSum-1;
                    for (int i = 0; i < numberOfNine; i++)
                        minResult += "9";
                }
            } else {
                if(numberOfNine == m) {
                    for (int i = 0; i < numberOfNine; i++)
                        minResult += "9";
                } else {
                    minResult += 1;
                    for (int i = 0; i < m-1-numberOfNine; i++)
                        minResult += "0";
                    minResult += 8;
                    for (int i = 0; i < numberOfNine-1; i++)
                        minResult += "9";
                }
            }
        } else {
            // only one digit
            System.out.print(s%9 + " " + s%9);
            return;
        }

        System.out.print(minResult + " ");
        char[] maxResult = minResult.toCharArray();
        for(int i=0; i<maxResult.length-1; i++) {
            for(int j=i+1; j<maxResult.length; j++) {
                if(maxResult[i] < maxResult[j]) {
                    char temp = maxResult[i];
                    maxResult[i] = maxResult[j];
                    maxResult[j] = temp;
                }
            }
        }

        for(int i=0; i<maxResult.length-1; i++) {
            for(int j=i+1; j<maxResult.length; j++) {
                while(Character.getNumericValue(maxResult[i])<9 && Character.getNumericValue(maxResult[j])>0) {
                    maxResult[i]++; maxResult[j]--;
                }
            }
        }

        for(char c: maxResult) {
            System.out.print(c);
        }

    }

}
