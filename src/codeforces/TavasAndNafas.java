package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// http://codeforces.com/problemset/problem/535/A
public class TavasAndNafas {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());

        String[] mappings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        if(d >= 0 && d <= 19) {
            System.out.println(mappings[d]);
        } else if(d >= 20 && d <= 29) {
            System.out.println("twenty" + (d%20==0?"":"-"+mappings[d%20]));
        } else if(d >= 30 && d <= 39) {
            System.out.println("thirty" + (d%30==0?"":"-"+mappings[d%30]));
        } else if(d >= 40 && d <= 49) {
            System.out.println("forty" + (d%40==0?"":"-"+mappings[d%40]));
        } else if(d >= 50 && d <= 59) {
            System.out.println("fifty" + (d%50==0?"":"-"+mappings[d%50]));
        } else if(d >= 60 && d <= 69) {
            System.out.println("sixty" + (d%60==0?"":"-"+mappings[d%60]));
        } else if(d >= 70 && d <= 79) {
            System.out.println("seventy" + (d%70==0?"":"-"+mappings[d%70]));
        } else if(d >= 80 && d <= 89) {
            System.out.println("eighty" + (d%80==0?"":"-"+mappings[d%80]));
        } else if(d >= 90 && d <= 99) {
            System.out.println("ninety" + (d%90==0?"":"-"+mappings[d%90]));
        }

    }

}
