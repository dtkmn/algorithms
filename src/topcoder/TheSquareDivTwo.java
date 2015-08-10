package topcoder;

import java.util.Arrays;

/**
 * Created by datse on 10/08/2015.
 */
public class TheSquareDivTwo {

    public static void main(String[] args) {
//        String[] board = {"..", "C."};
        String[] board = {".C..",
                "CC.C",
                "..C.",
                "CCCC"};
        System.out.println(Arrays.toString(new TheSquareDivTwo().solve(board)));
    }

    public String[] solve(String[] board) {
        int[] rowCount = new int[board.length];
        int cExtra = 0, dotExtra = 0;
        for(int i=0; i<board.length; i++) {
            String r = board[i];
            int count = 0;
            for(int j=0; j<r.length(); j++) {
                char c = r.charAt(j);
                if(c == 'C') count++;
            }
            rowCount[i] = count;
        }

        System.out.println(Arrays.toString(rowCount));
        System.out.println();

        for (int j=0; j<board[0].length(); j++) {
            int count = 0;
            for(int i=0; i<board.length; i++) {
                if(board[i].charAt(j) == 'C') {
                    count++;
                }
            }
            System.out.println("COUNTING...");
            System.out.println(count);
            System.out.println();
            // when column count is less than as expected, we need more 'C'
            if(rowCount[j] > count) {
//                while(rowCount[j] > count) {
                    for (int i = 0; i < board.length; i++) {
                        if(rowCount[j] > count) {
                            if (board[i].charAt(j) == '.') {
                                board[i] = board[i].substring(0, j) + 'C' + board[i].substring(j + 1);
                                count++;
                            }
                        } else {
                            break;
                        }
                    }
//                }
            // when column count is more than as expected, we need more '.'
            }
            else if(rowCount[j] < count) {
                for (int i = 0; i < board.length; i++) {
                    if(rowCount[j] < count) {
                        if (board[i].charAt(j) == 'C') {
                            board[i] = board[i].substring(0, j) + '.' + board[i].substring(j + 1);
                            count--;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return board;
    }

}
