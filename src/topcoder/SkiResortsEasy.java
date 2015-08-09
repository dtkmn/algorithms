package topcoder;

/**
 * Created by dtkmn on 10/08/2015.
 */
public class SkiResortsEasy {

    public static void main(String[] args) {
//        int[] altitude = {6, 8, 5, 4, 7, 4, 2, 3, 1};
//        int[] altitude = {749, 560, 921, 166, 757, 818, 228, 584, 366, 88};
        int[] altitude = {712, 745, 230, 200, 648, 440, 115, 913, 627, 621, 186, 222, 741, 954, 581, 193, 266, 320, 798, 745};
        System.out.println(new SkiResortsEasy().minCost(altitude));
    }

    public int minCost(int[] altitude) {
        int current = altitude[0];
        int cost = 0;
        for(int i=1; i<altitude.length; i++) {
            if(current < altitude[i]) {
                cost += (altitude[i] - current);
            }
            if(altitude[i] < current) {
                current = altitude[i];
            }
        }
        return cost;
    }

}
