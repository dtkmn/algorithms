package topcoder;

/**
 * Created by datse on 10/08/2015.
 */
public class TheBeauty {

    public static void main(String[] args) {
        int n = 123456789;
        System.out.println(new TheBeauty().find(n));
    }

    public int find(int n) {
        int unique = 0;
        int[] pos = new int[10];
        String input = new String(n+"");
        for(int i=0; i<input.length(); i++) {
            pos[Character.getNumericValue(input.charAt(i))]++;
        }
        for(int i=0; i<pos.length; i++) {
            if(pos[i] == 1) unique++;
        }
        return unique;
    }

}
