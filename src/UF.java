/**
 * Created by datse on 17/06/2015.
 */
public class UF {

    private int[] id;
    private byte[] rank;
    private int count;

    public UF(int N) {
        if(N < 0) throw new IllegalArgumentException();
        count = N;
        id = new int[N];
        rank = new byte[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            rank[i] = 0;
        }
    }




}
