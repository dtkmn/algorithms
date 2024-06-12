package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://codeforces.com/problemset/problem/734/A

public class AntonAndDanik {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String wonlost = br.readLine();
        // Space Complexity: O(1)
        int[] count = new int[2];
        // Time Complexity: O(N) -> Length of input
        for (char r: wonlost.toCharArray()) {
            if (r == 'A') count[r - 'A']++;
            if (r == 'D') count[r - 'D' + 1]++;
        }

        if (count[0] == count[1]) {
            System.out.println("Friendship");
        } else {
            System.out.println(count[0] > count[1] ? "Anton" : "Danik");
        }

    }

}
