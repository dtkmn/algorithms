package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/611/A
public class NewYearAndDays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        String shouldBeOf = st.nextToken();
        String weekOrMonth = st.nextToken();

        if ("week".equals(weekOrMonth)) {
            System.out.println(day == 5 || day == 6 ? 53 : 52);
        } else if ("month".equals(weekOrMonth)) {
            System.out.println(day <= 29 ? 12 : (day == 30? 11 : 7));
        }

    }

}
