package codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by datse on 26/08/2015.
 */
public class KyoyaAndPhotobooks {

    /*
        or formula approach? 25*(length+1)+1
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        Set<String> lists = new HashSet<>();
        for(int i=0; i<=input.length(); i++) {
            for(char j='a'; j<='z'; j++) {
                lists.add(input.substring(0, i) + j + input.substring(i));
            }
        }
        System.out.println(lists.size());
    }

}
