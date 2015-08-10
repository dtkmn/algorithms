package topcoder;

/**
 * Created by datse on 10/08/2015.
 */
public class ArrayHash {

    public static void main(String[] args) {
//        String[] input = {"CBA", "DDD"};
        String[] input = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ"};
        System.out.println(new ArrayHash().getHash(input));
    }

    public int getHash(String[] input) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int sum = 0;
        for(int i=0; i<input.length; i++) {
            for(int j=0; j<input[i].length(); j++) {
                char c = input[i].charAt(j);
                sum += (alpha.indexOf(c) + i + j);
            }
        }
        return sum;
    }

}
