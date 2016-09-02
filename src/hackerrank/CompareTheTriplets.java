package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CompareTheTriplets {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer alice = new StringTokenizer(br.readLine());
        StringTokenizer bobs = new StringTokenizer(br.readLine());
        int aScore = 0, bScore = 0;
        for(int i=0; i<3; i++) {
            int a  = Integer.parseInt(alice.nextToken());
            int b = Integer.parseInt(bobs.nextToken());
            if(a > b) aScore++;
            else if(a < b) bScore++;
        }
        System.out.println(aScore + " " + bScore);
    }

}
