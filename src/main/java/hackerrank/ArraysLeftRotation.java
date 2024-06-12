package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ArraysLeftRotation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer nAndD = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nAndD.nextToken());
        int d = Integer.parseInt(nAndD.nextToken());

        StringTokenizer values = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for(int i=0; i<array.length; i++) {
            array[i] = Integer.parseInt(values.nextToken());
        }

        for(int j=d; j<d+n; j++) {
            System.out.print(array[j%n] + " ");
        }

    }

}
