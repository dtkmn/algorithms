package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpingOnTheClouds {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        int[] clouds = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            clouds[i] = Integer.parseInt(st.nextToken());
        }
        int seq = 0, jumps = 0;
        for(int j=0; j<n; j++) {
            if(clouds[j] == 0) {
                if(seq == 1) {
                    seq = 0;
                    jumps++;
                } else {
                    seq++;
                }
            } else {
                seq = 0;
                jumps++;
            }
        }
        System.out.println(jumps);
    }

}
