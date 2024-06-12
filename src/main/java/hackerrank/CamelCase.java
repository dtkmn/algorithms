package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CamelCase {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String input = br.readLine();
        char[] charArray = input.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] >= 65 && charArray[i] <= 90) {
                count++;
            }
        }
        System.out.println(count + 1);
    }

}
