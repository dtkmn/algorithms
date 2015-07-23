package codechef;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/07/2015.
 */
public class ATM {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int withdraw = in.nextInt();
        double balance = in.nextDouble();

        if(withdraw % 5 != 0 || (withdraw + 0.5) > balance) {
            System.out.printf("%.2f", balance);
        } else  {
            System.out.printf("%.2f", balance - withdraw - 0.5);
        }

    }

}
