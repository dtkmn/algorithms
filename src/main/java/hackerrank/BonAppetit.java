package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BonAppetit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer nAndK = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nAndK.nextToken());
        int k = Integer.parseInt(nAndK.nextToken());
        int actualCharged = 0;
        StringTokenizer itemCharges = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int cost = Integer.parseInt(itemCharges.nextToken());
            if(i != k) actualCharged += cost;
        }
        actualCharged /= 2;
        int b = Integer.parseInt(br.readLine());
        System.out.println(b == actualCharged?"Bon Appetit":b-actualCharged);
    }

}
