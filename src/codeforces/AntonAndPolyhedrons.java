package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://codeforces.com/problemset/problem/785/A

public class AntonAndPolyhedrons {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            countMap.put(line, countMap.getOrDefault(line, 0) + 1);
        }

        int total = 0;
        total += countMap.getOrDefault("Tetrahedron", 0) * 4;
        total += countMap.getOrDefault("Cube", 0) * 6;
        total += countMap.getOrDefault("Octahedron", 0) * 8;
        total += countMap.getOrDefault("Dodecahedron", 0) * 12;
        total += countMap.getOrDefault("Icosahedron", 0) * 20;

        System.out.println(total);
    }

}
