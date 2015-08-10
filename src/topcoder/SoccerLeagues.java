package topcoder;

import java.util.Arrays;

/**
 * Created by datse on 10/08/2015.
 */
public class SoccerLeagues {

    public static void main(String[] args) {
//        String[] matches = {"-WW", "W-W", "WW-"};
        String[] matches = {"-LWWLWDLDWWWWWWDDWDW",
                "D-WWLDDWDWDLWDDWLWDD",
                "LL-DLDWDLDLDWWWLWDDW",
                "LDD-LLLDLWLWWWWDWDWL",
                "LWWW-DWDLWDWDWWWDWDW",
                "DLLWD-WWLLDDDLWWDWWW",
                "WWLWDL-LLDWWWWWDWWLW",
                "LLLLLDW-LDLWDDLLLDWL",
                "DWWWWDDD-DWWWWDWWWDW",
                "WWWWLLLWL-LWWWWWLWWW",
                "DWWWWWWWLW-WDWWWWWWW",
                "DDDLLLDWWWL-DDWDWLDD",
                "LWLWLDLLLDLW-DDDWWDD",
                "LLWWLWDDLWLWL-WWWDLL",
                "WWWWLLDDDWLWDD-WWWLW",
                "DLDLLLWWLLLWWLW-DWLL",
                "DLWWWLDLWWDWWDWL-WWD",
                "LLDDLLWLLWLWLDLWW-WW",
                "LLWLLLWWLWLWWDWWLD-W",
                "LLWDLWDWDWLLWWDDWWL-"};
        System.out.println(Arrays.toString(new SoccerLeagues().points(matches)));
    }

    public int[] points(String[] matches) {
        int[] points = new int[matches.length];
        for(int i=0; i<matches.length; i++) {
            for(int j=0; j<matches[i].length(); j++) {
                if(matches[i].charAt(j) == 'W') {
                    points[i] += 3;
                } else if(matches[i].charAt(j) == 'D') {
                    points[i]++;
                    points[j]++;
                 } else if(matches[i].charAt(j) == 'L') {
                    points[j] += 3;
                }
            }
        }
        return points;
    }

}
