package topcoder;

/**
 * Created by dtkmn on 10/08/2015.
 */
public class AccountBalance {

    public static void main(String[] args) {
//        int startingBalance = 100;
//        String[] transactions = {"C 1000", "D 500", "D 350"};
        int startingBalance = 53874;
        String[] transactions = {"D 1234", "C 987", "D 2345", "C 654", "D 6789", "D 34567"};
        System.out.println(new AccountBalance().processTransactions(startingBalance, transactions));
    }

    public int processTransactions(int startingBalance, String[] transactions) {
        for(int i=0; i<transactions.length; i++) {
            String[] inputs = transactions[i].split(" ");
            if("C".equals(inputs[0])) startingBalance += Integer.parseInt(inputs[1]);
            if("D".equals(inputs[0])) startingBalance -= Integer.parseInt(inputs[1]);
        }
        return startingBalance;
    }

}
