package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://codeforces.com/contest/1030/problem/A

public class InSearchOfAnEasyProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        for (int i = 0; i < N; i++) {
            if ("1".equals(st.nextToken())) {
                System.out.println("HARD");
                return;
            }
        }

        System.out.println("EASY");
    }

}
