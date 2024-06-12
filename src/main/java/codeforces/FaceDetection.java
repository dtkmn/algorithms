package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by dtkmn on 6/08/2015.
 */
public class FaceDetection {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String inputs = in.readLine();
        String[] nm = inputs.split(" ");
        int rowsCount = Integer.parseInt(nm[0]);
        int columnsCount = Integer.parseInt(nm[1]);
        String[] rows = new String[rowsCount];
        for(int i=0; i<rowsCount; i++) {
            rows[i] = in.readLine();
        }

        int faces = 0;
        for(int i=0; i<rowsCount; i++) {
            for(int j=0; j<columnsCount; j++) {
                if(rows[i].charAt(j) != 'x') {
                    if(i+1 < rowsCount && j+1 < columnsCount) {
                        char[] checks = {rows[i].charAt(j), rows[i+1].charAt(j), rows[i].charAt(j+1), rows[i+1].charAt(j+1)};
                        Arrays.sort(checks);
                        if("acef".equals(new String(checks))) faces++;
                    }
                }
            }
        }

        System.out.println(faces);

    }

}
