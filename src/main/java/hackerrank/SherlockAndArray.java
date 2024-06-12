package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SherlockAndArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] array = new int[N];
            int[] dp = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                array[j] = Integer.parseInt(st.nextToken());
                if(j == 0) dp[j] = array[j];
                else dp[j] = dp[j-1]+array[j];
            }

            if(N == 1) {
                System.out.println("YES");
                continue;
            } else if(N == 2) {
                System.out.println("NO");
                continue;
            }

            int mid = N/2; int d = 0;
            boolean found = false;
            while(mid > 0 && mid <array.length-1) {
                int totalLeft = dp[mid-1];
                int totalRight = dp[array.length-1] - dp[mid];
                if(totalLeft == totalRight) {
                    found = true;
                    break;
                }
                if(d == 0) {
                    if (totalLeft > totalRight) {
                        mid = mid - 1; d = -1;
                    }
                    else {
                        mid = mid + 1; d = 1;
                    }
                } else if(d == 1) mid = mid + 1;
                else mid = mid - 1;
            }
            System.out.println(found?"YES":"NO");
        }
    }

}
