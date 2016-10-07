package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HashTablesRansomNote {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer mAndN = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(mAndN.nextToken());
        int n = Integer.parseInt(mAndN.nextToken());

        Map<String, Integer> dict = new HashMap<>();
        StringTokenizer mWords = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            String s = mWords.nextToken();
            Integer v = dict.get(s);
            if(v != null)
                dict.put(s, v+1);
            else dict.put(s, 1);
        }

        StringTokenizer nWords = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            String s = nWords.nextToken();
            int v = dict.get(s);
            if(v<=0) {
                System.out.println("No");
                return;
            } else {
                dict.put(s, v-1);
            }
        }
        System.out.println("Yes");

    }

}
