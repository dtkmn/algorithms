package codeforces;

import java.util.*;

/**
 * Created by datse on 20/08/2015.
 */
public class VitaliyAndPie {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rooms = in.nextInt();
        String roomKeys = in.next();
        Map<Character, Integer> keys = new HashMap<>();
        int requiredKeys = 0;
        for(int i=0; i<roomKeys.length(); i++) {
            char c = roomKeys.charAt(i);
            if(i == 0 || i % 2 == 0) {
                keys.put(c, keys.get(c)==null?1:keys.get(c)+1);
            } else {
                int temp = keys.get(Character.toLowerCase(c))!=null?keys.get(Character.toLowerCase(c)):0;
                if(temp > 0) {
                    keys.put(Character.toLowerCase(c), temp - 1);
                } else {
                    requiredKeys++;
                }
            }
        }
        System.out.println(requiredKeys);
    }

}
