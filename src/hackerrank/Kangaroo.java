package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kangaroo {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(line.nextToken());
        int v1 = Integer.parseInt(line.nextToken());
        int x2 = Integer.parseInt(line.nextToken());
        int v2 = Integer.parseInt(line.nextToken());

        if((x1>x2 && v1>v2) || (x1<x2 && v1<v2) || v1 == v2) {
            System.out.println("NO");
        } else if(x1>x2 && v1<v2){
            while(x2 <= x1) {
                if(x2==x1) {
                    System.out.println("YES");
                    break;
                }
                x2+=v2;
                x1+=v1;
            }
            if(x2>x1) System.out.println("NO");
        } else if(x1<x2 && v1>v2) {
            while(x1 <= x2) {
                if(x2==x1) {
                    System.out.println("YES");
                    break;
                }
                x2+=v2;
                x1+=v1;
            }
            if(x1>x2) System.out.println("NO");
        }

    }

}
