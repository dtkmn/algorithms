package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *  https://codeforces.com/contest/1354/problem/A
 *
 */

public class AlarmClock {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(-1);
        }

        // Time Complexity: O(N)
        // Implementation
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long totalSleepRequired = Long.parseLong(st.nextToken());
            long firstSleep = Long.parseLong(st.nextToken());
            long everySleep = Long.parseLong(st.nextToken());
            long fallSleepRequired = Long.parseLong(st.nextToken());

            if (firstSleep >= totalSleepRequired) {
                System.out.println(firstSleep);
            } else {
                if (fallSleepRequired >= everySleep) {
                    System.out.println(-1);
                } else {
                    long sleepNeed = totalSleepRequired - firstSleep;
                    long qualitySleep = everySleep - fallSleepRequired;
                    long periods = (long) Math.ceil(1.0 * sleepNeed / qualitySleep);
                    System.out.println(firstSleep + periods * everySleep);
                }
            }
        }
    }

}
