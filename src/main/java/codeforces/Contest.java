package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dtkmn on 17/08/2015.
 */
public class Contest {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String inputs = in.readLine();
        String[] integers = inputs.split(" ");
        int mishaPoint = Integer.parseInt(integers[0]);
        int vasyaPoint = Integer.parseInt(integers[1]);
        int mishaMinutes = Integer.parseInt(integers[2]);
        int vasyaMinutes = Integer.parseInt(integers[3]);

        int mishaResult = Math.max(3 * mishaPoint / 10, mishaPoint - mishaPoint / 250 * mishaMinutes);
        int vasyaResult = Math.max(3 * vasyaPoint / 10, vasyaPoint - vasyaPoint / 250 * vasyaMinutes);

        if(mishaResult > vasyaResult) {
            System.out.println("Misha");
        } else if(mishaResult < vasyaResult) {
            System.out.println("Vasya");
        } else if(mishaResult == vasyaResult) {
            System.out.println("Tie");
        }

    }

}
