package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 16/08/2015.
 */
public class BerlandNationalLibrary {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String readers = "";
        int requiredRooms = 0;
        int currentRooms = 0;
        for (int i = 0; i < N; i++) {
            String operation = in.next();
            int registrationNumber = in.nextInt();
            if ("+".equals(operation)) {
                readers += registrationNumber + ":";
                if (currentRooms == 0) {
                    requiredRooms++;
                } else {
                    currentRooms--;
                }
            } else if ("-".equals(operation)) {
                if (readers.indexOf(registrationNumber + ":") == -1) {
                    requiredRooms++;
                    currentRooms++;
                } else {
                    currentRooms++;
                    readers = readers.replaceFirst(registrationNumber + ":", "");
                }
            }
        }
        System.out.println(requiredRooms);
    }

}
