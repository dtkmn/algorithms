package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StrangeCounter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());
        int count = 0;
        double max = 3 * Math.pow(2, count);
        while(max < t) {
            max += 3 * Math.pow(2, ++count);
        }
        System.out.println((long)(max - t + 1));
    }

}
