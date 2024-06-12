package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringConstruction {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            int cost = 0;
            int[] show = new int[26];
            for(int j=0; j<s.length(); j++) {
                int pos = s.charAt(j)-97;
                if(show[pos] == 0) {
                    show[pos] = 1; cost++;
                }
            }
            System.out.println(cost);
        }

    }

}
