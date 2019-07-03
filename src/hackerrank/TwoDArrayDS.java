package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoDArrayDS {

    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;;
        for (int i=0; i<=3; i++) {
            for (int j=0; j<=3; j++) {
                int sum = sumOfHourglass(arr, i, j);
                if(sum > max) max = sum;
            }
        }
        return max;
    }

    static int sumOfHourglass(int[][] inputs, int istart, int jstart) {
        int sum = 0, count = 0;
        for (int i=istart; i<istart+3; i++) {
            for (int j=jstart; j<jstart+3; j++) {
                if (count != 3 && count != 5) {
                    int val = inputs[i][j];
                    sum += val;
                }
                count++;
            }
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
