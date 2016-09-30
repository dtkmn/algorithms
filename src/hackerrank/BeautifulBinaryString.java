package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeautifulBinaryString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String B = br.readLine();
        int count = 0;
        while(B.contains("010")) {
            B = B.replaceFirst("010", "011");
            count++;
        }
        System.out.println(count);
    }

}
