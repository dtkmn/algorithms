package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSortCountingInversions {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());
        for(int i=0; i<d; i++) {
            count = 0;
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n];
            StringTokenizer row = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int value = Integer.parseInt(row.nextToken());
                list[j] = value;
            }
            int[] aux = list.clone();
            System.out.println(mergeSort(list, 0, n-1, aux));
        }

    }

    static int count = 0;
    static long mergeSort(int[] array, int start, int end, int[] aux) {
        if(end<=start) return 0;
        int mid = start + (end - start) / 2;
        long count = 0;
        count += mergeSort(aux, start, mid, array);
        count += mergeSort(aux, mid+1, end, array);
        count += merge(array, start, mid, end, aux);
        return count;
    }

    // merge 2 ordered sub array
    static long merge(int[] array, int lo, int mid, int hi, int[] aux) {
        long count = 0;
        int i=lo, j=mid+1;
        for(int k=lo; k<=hi; k++) {
            if(i > mid) array[k] = aux[j++];
            else if(j > hi) array[k] = aux[i++];
            else if(aux[i]<=aux[j]) array[k] = aux[i++];
            else {
                array[k] = aux[j++];
                // When left and right subarrays are sorted,
                // so all the remaining elements in left subarray will be greater than right!
                count += mid + 1 - i;
            }
        }
        return count;
    }

}
