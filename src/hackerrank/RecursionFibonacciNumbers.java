package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursionFibonacciNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(p));
    }

    static int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibonacci(n-2) + fibonacci(n-1);
    }

}
