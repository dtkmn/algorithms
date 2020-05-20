package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://codeforces.com/problemset/problem/977/A

public class WrongSubtraction {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);


        int input = Integer.parseInt(st.nextToken());
        int steps = Integer.parseInt(st.nextToken());

        int count = 0;
        while (++count <= steps) {
            if (input % 10 == 0) input /= 10;
            else input -= 1;
        }

        System.out.println(input);
    }

}
