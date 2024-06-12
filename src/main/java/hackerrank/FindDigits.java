package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 9/07/2015.
 */
public class FindDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] inputs = new int[N];
        for(int i=0; i<N; i++) {
            inputs[i] = in.nextInt();
        }

        for(int i=0; i<N; i++) {
            int count = 0;
            int d = inputs[i];
            while(d != 0) {
                int x = d%10;
                if(x!=0 && inputs[i]%x == 0) count++;
                d /= 10;
            }
            System.out.println(count);
        }
    }

}
