package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SaveThePrisoner {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            StringTokenizer params = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(params.nextToken());
            int M = Integer.parseInt(params.nextToken());
            int S = Integer.parseInt(params.nextToken());
            int result = (S+M-1)%N;
            System.out.println(result==0?N:result);
        }

    }

}
