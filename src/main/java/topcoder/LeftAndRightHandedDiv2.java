package topcoder;

/**
 * Created by dtkmn on 10/08/2015.
 */
public class LeftAndRightHandedDiv2 {

    public static void main(String[] args) {
//        String S = "LRLRLR";
//        String S = "RLRLRL";
        String S = "RRLLLRRRLRLLLRLLRRRLRLRRRRRRRRRRLRRLRLRRLLRLR";
        System.out.println(new LeftAndRightHandedDiv2().count(S));
    }

    public int count(String S) {
        int collisions = 0;
        while(S.indexOf("RL") != -1) {
//            S = S.replaceFirst("RL", "");
            S = S.substring(S.indexOf("RL")+2);
            collisions++;
        }

        return collisions;
    }

}
