package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 14/08/2015.
 */
public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            int money = in.nextInt();
            int choco = in.nextInt();
            int wrapper = in.nextInt();
            int bought = 0;
            int getWrapper = 0;
            bought += money/choco;
            getWrapper += money/choco;
            while(getWrapper >= wrapper) {
                int extra = getWrapper/wrapper;
                getWrapper = getWrapper%wrapper;
                bought += extra;
                getWrapper += extra;
            }
            System.out.println(bought);
        }
    }

}
