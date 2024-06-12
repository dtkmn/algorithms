package topcoder;

import java.util.Arrays;

/**
 * Created by dtkmn on 9/08/2015.
 *
 * http://community.topcoder.com/stat?c=problem_statement&pm=13195
 */
public class CostOfDancing {

    public static void main(String[] args) {
        int K = 2;
        int[] danceCost = {1, 5, 3, 4};
        System.out.println(new CostOfDancing().minimum(K,
                danceCost));
    }

    public int minimum(int K, int[] danceCost) {
        Arrays.sort(danceCost);
        int sum = 0;
        for(int i=0; i<K; i++) {
            sum += danceCost[i];
        }
        return sum;
    }

}
