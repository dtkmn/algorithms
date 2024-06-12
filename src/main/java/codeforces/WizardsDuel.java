package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// http://codeforces.com/problemset/problem/591/A
public class WizardsDuel {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());
        double t = d*1.0/(p+q);
        System.out.println(p*t);
    }

}
