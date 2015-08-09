package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class WhiteCells {

    public static void main(String[] args) {
//        String[] board = {"FFFFFFFF",
//                "FFFFFFFF",
//                "FFFFFFFF",
//                "FFFFFFFF",
//                "FFFFFFFF",
//                "FFFFFFFF",
//                "FFFFFFFF",
//                "FFFFFFFF"};
        String[] board = {".F.F...F",
                "F...F.F.",
                "...F.F.F",
                "F.F...F.",
                ".F...F..",
                "F...F.F.",
                ".F.F.F.F",
                "..FF..F."};
        System.out.println(new WhiteCells().countOccupied(board));
    }

    public int countOccupied(String[] board) {
        int occupied = 0;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length(); j++) {
                if(((i%2==0&&j%2==0) || (i%2!=0&&j%2!=0)) &&
                        board[i].charAt(j) == 'F') {
                    occupied++;
                }
            }
        }
        return occupied;
    }

}
