package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class Sortness {

    public static void main(String[] args) {
        int[] a = {3,2,1,4,6,7,5,8};
        System.out.println(new Sortness().getSortness(a));
    }

    public double getSortness(int[] a) {
        double sum = 0.0;
        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a.length; j++) {
                if(i != j) {
                    if(i < j && a[j] < a[i]) {
                        sum++;
                    } else if(i > j && a[j] > a[i]) {
                        sum++;
                    }
                }
            }
        }
        return sum/a.length;
    }

}
