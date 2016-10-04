package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperReducedString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String S = br.readLine();
        if(S.length() == 1) {
            System.out.println(S);
        } else {
            for(int i=1; i<S.length(); i++) {
                if(S.charAt(i-1) == S.charAt(i)) {
                    S = S.substring(0, i-1) + S.substring(i+1);
                    i=0;
                }
            }
            System.out.println(S.length()==0?"Empty String":S);
        }
    }

}
