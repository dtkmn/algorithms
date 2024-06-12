package leetcode;

/**
 * <a href="https://leetcode.com/problems/k-th-symbol-in-grammar/">...</a>
 */
public class KthSymbolInGrammar {

    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        String prevRow = "0";
        for (int i = 2; i <= n; i++) {
            StringBuilder currentRow = new StringBuilder();
            for (int j = 0; j < prevRow.length(); j++) {
                char c = prevRow.charAt(j);
                if (c == '0') currentRow.append('0').append('1');
                else currentRow.append('1').append('0');
            }
            prevRow = currentRow.toString();
        }
        return prevRow.charAt(k - 1) - 48;
    }

    /**
     *
     * @param n
     * @param k
     * @return
     */
    public int kthGrammar_dfs(int n, int k) {
        return dfs(n, k, 0);
    }

    private int dfs(int n, int k, int rootValue) {
        if (n == 1) return rootValue;
        int total = (int)Math.pow(2, n - 1);
        if (k > (total / 2)) {
            int value = rootValue == 0? 1: 0;
            return dfs(n - 1, k - (total / 2), value);
        } else {
            int value = rootValue == 0? 0: 1;
            return dfs(n - 1, k, value);
        }
    }


    /**
         0123456789
     1   0
     2   01
     3   0110
     4   01101001
     5   0110100110010110
     6   01101001100101101001011001101001
     */
    public static void main(String[] args) {
        System.out.println(
            new KthSymbolInGrammar().kthGrammar(1, 1)
        );
        System.out.println(
            new KthSymbolInGrammar().kthGrammar(2, 1)
        );
        System.out.println(
            new KthSymbolInGrammar().kthGrammar_dfs(30, 434991989)
        );
    }

}
