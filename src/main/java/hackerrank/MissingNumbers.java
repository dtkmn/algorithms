package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MissingNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            list1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list1);
        int m = Integer.parseInt(br.readLine());
        int[] list2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<m; j++) {
            list2[j] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list2);
        int prev = 0;
        int a=0, b=0;
        for(;a<n && b<m;) {
            if(list1[a] == list2[b]) {
                a++; b++;
            } else if(list1[a] > list2[b]) {
                if(list2[b] != prev)
                    System.out.print(list2[b] + " ");
                prev = list2[b];
                b++;
            } else {
                if(list1[a] != prev)
                    System.out.print(list1[a] + " ");
                prev = list1[a];
                a++;
            }
        }

        prev = 0;
        if(a == n) {
            for(int x=b; x<m; x++) {
                if(list2[x] != prev) {
                    System.out.print(list2[x] + " ");
                    prev = list2[x];
                }
            }
        } else {
            for(int x=a; x<n; x++) {
                if(list1[x] != prev) {
                    System.out.print(list1[x] + " ");
                    prev = list1[x];
                }
            }
        }

    }

}
