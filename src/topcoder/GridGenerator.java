package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class GridGenerator {

    public static void main(String[] args) {
//        int[] row = {1,0,3,4,1};
//        int[] col = {1,4,1,0,3};

        int[] row = {9,9,9,9,9,9,9,9,9,9};
        int[] col = {9,9,9,9,9,9,9,9,9,9};

        System.out.println(new GridGenerator().generate(row, col));
    }

    public int generate(int[] row, int[] col) {
        int[][] matrix = new int[row.length][col.length];
        matrix[0] = row;
        for(int i=0; i<col.length; i++) {
            matrix[0][i] = row[i];
        }
        for(int i=0; i<row.length; i++) {
            matrix[i][0] = col[i];
        }
        for(int i=1; i<row.length; i++) {
            for(int j=1; j<col.length; j++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1] + matrix[i-1][j-1];
            }
        }
        return matrix[row.length-1][col.length-1];
    }

}
