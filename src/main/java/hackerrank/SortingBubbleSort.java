package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SortingBubbleSort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer row = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int value = Integer.parseInt(row.nextToken());
            list[i] = value;
        }

        int total = 0;
        for(int i=0; i<n; i++) {
            int numSwaps = 0;
            for(int j=0; j<n-1; j++) {
                if(list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    numSwaps++;
                }
            }
            if(numSwaps == 0) break;
            total += numSwaps;
        }

        System.out.println("Array is sorted in " + total + " swaps.");
        System.out.println("First Element: " + list[0]);
        System.out.println("Last Element: " + list[n-1]);

    }

}
