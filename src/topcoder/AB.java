package topcoder;

/**
 * Created by dtkmn on 19/07/2015.
 */
public class AB {


    public static void main(String[] args) {
        System.out.println(createString(10, 12));
        System.out.println(createString(3, 2));
        System.out.println(createString(2, 0));
        System.out.println(createString(5, 8));
    }

    /*
        N 2-50 inclusive
        K 0-N(N-1)/2 inclusive
     */
    public static String createString(int N, int K) {

        int max = max(N);

        if(max < K) {
            return "";
        }

        char[] result = new char[N];
        for(int i=0; i<N; i++) {
            result[i] = 'A';
        }


        int putPos = -1, putPosN = -1;
        for(int j=0,k=N; j<N; j++,k--) {
            if(max(k) == K) {
                putPos = j;
                putPosN = k;
                break;
            } else {
                result[j] = 'B';
            }
        }

        for(int x=putPos,y=putPosN/2; x<N; x++,y--) {
            if(y > 0) result[x] = 'A';
            else result[x] = 'B';
        }



        return new String(result);

    }

    static int max(int N) {
        return (N/2)*(N-N/2);
    }

}
