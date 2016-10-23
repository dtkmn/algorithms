package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TimeComplexityPrimality {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());

        for(int i=0; i<p; i++) {
            boolean prime = true;
            int n = Integer.parseInt(br.readLine());
            if(n == 2) {
                prime = true;
            } else if(n == 1 || n%2 == 0) {
                prime = false;
            } else {
                for (int j = 3; j < Math.sqrt(n); j += 2) {
                    if (n % j == 0) {
                        prime = false;
                        break;
                    }
                }
            }
            System.out.println(prime?"Prime":"Not prime");
        }

    }

}
