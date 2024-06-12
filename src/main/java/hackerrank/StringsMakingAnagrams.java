package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringsMakingAnagrams {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int[] a1 = new int[26];
        for(int i=0; i<a.length(); i++) {
            char c = a.charAt(i);
            a1[c-97]++;
        }
        int[] a2 = new int[26];
        for(int i=0; i<b.length(); i++) {
            char c = b.charAt(i);
            a2[c-97]++;
        }

        int o = 0;
        for(int k=0; k<26; k++) {
            o += Math.abs(a1[k]-a2[k]);
        }

        System.out.println(o);

    }

}
