package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class FlatlandSpaceStations {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer nAndM = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nAndM.nextToken());
        int m = Integer.parseInt(nAndM.nextToken());

        StringTokenizer cities = new StringTokenizer(br.readLine());
        List<Integer> spaceStations = new ArrayList<>();
        boolean first = false, last = false;
        for(int i=0; i<m; i++) {
            int city = Integer.parseInt(cities.nextToken());
            if(city == 0) first = true;
            if(city == n-1) last = true;
            spaceStations.add(city);
        }
        Collections.sort(spaceStations);
        int prev = spaceStations.get(0), max = 0;
        if(!first) {
            max = Math.max(max, spaceStations.get(0) - 0);
        }
        for(int j=1; j<spaceStations.size(); j++) {
            int v = spaceStations.get(j);
            max = Math.max(max, (v-prev)/2);
            prev = v;
        }
        if(!last) {
            max = Math.max(max, n - 1 - spaceStations.get(m-1));
        }
        System.out.println(max);
    }

}
