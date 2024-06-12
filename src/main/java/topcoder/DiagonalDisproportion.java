package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class DiagonalDisproportion {

    public static void main(String[] args) {

//        String[] matrix = {"190","828","373"};
        String[] matrix = {"9000","0120","0000","9000"};
        System.out.println(new DiagonalDisproportion().getDisproportion(matrix));

    }

    public int getDisproportion(String[] matrix) {
        int sumMainDiagonal = 0;
        int sumCollateralSiagonal = 0;
        for(int i=0; i<matrix.length; i++) {
            String input = matrix[i];
            for(int j=0; j<input.length(); j++) {
                if(i == j) {
                    int v = Character.getNumericValue(input.charAt(j));
                    sumMainDiagonal += v;
                }

                if(i + j == matrix.length-1) {
                    int v = Character.getNumericValue(input.charAt(j));
                    sumCollateralSiagonal += v;
                }

            }
        }
        return sumMainDiagonal - sumCollateralSiagonal;
    }


}
