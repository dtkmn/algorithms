package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LuckBalance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer nAndK = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nAndK.nextToken());
        int K = Integer.parseInt(nAndK.nextToken());
        int totalLuck = 0;
        List<Integer> importantContest = new ArrayList<>();
        for(int i=0; i<N; i++) {
            StringTokenizer lAndT = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(lAndT.nextToken());
            int T = Integer.parseInt(lAndT.nextToken());
            if(T == 1) {
                importantContest.add(L);
            } else {
                totalLuck += L;
            }
        }
        Collections.sort(importantContest);
        int diff = importantContest.size()-K;
        for(int j=1; j<=importantContest.size(); j++) {
            if(j <= diff) {
                totalLuck -= importantContest.get(j-1);
            } else {
                totalLuck += importantContest.get(j-1);
            }
        }
        System.out.println(totalLuck);

    }

}
