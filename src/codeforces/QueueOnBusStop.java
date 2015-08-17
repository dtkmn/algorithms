package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 17/08/2015.
 */
public class QueueOnBusStop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int groups = in.nextInt();
        int busCapacity = in.nextInt();
        int bus = 0, pre = 0;
        for(int i=0; i<groups; i++) {
            int group = in.nextInt();
            if(pre + group == busCapacity) {
                bus++;
                pre = 0;
            } else if(pre + group < busCapacity) {
                pre += group;
            } else {
                bus++;
                pre = group;
            }
        }
        if(pre > 0) bus++;
        System.out.println(bus);
    }

}
