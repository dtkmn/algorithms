package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dtkmn on 17/08/2015.
 */
public class RegistrationSystem {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Map<String, Integer> test = new HashMap<>();
        for(int i=0; i<N; i++) {
            String name = in.readLine();
            if(!test.containsKey(name)) {
                test.put(name, 0);
                System.out.println("OK");
            } else {
                int count = test.get(name);
                test.put(name, ++count);
                System.out.println(name+count);
            }
        }
    }

}
