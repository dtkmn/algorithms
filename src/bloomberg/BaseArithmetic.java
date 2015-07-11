package bloomberg;

import java.util.Scanner;

/**
 * Created by dtkmn on 11/07/2015.
 */
public class BaseArithmetic {



    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        long sum = 0;
        while(stdin.hasNextLine())
        {
//            System.out.println(stdin.nextLine());
            String input = stdin.nextLine();
            char[] chars = input.trim().toLowerCase().toCharArray();
            // 97-122, a-z
            // 48-57
            int maxDigit = -1;
            int maxChar = -1;
            int finalbaseval = 0;
            for(int i=0; i<chars.length; i++) {
                if(Character.isDigit(chars[i])) {
                    if(maxDigit < (int) chars[i]) {
//                        maxDigit = (int) chars[i];
                        maxDigit = chars[i]-'0';
                    }
                } else if(Character.isAlphabetic(chars[i])) {
                    char c = chars[i];
                    int charBase = -1;
                    if(c >= 97 && c <= 102) {
                        switch (c) {
                            case 'a':
                                charBase = 11;
                                break;
                            case 'b':
                                charBase = 12;
                                break;
                            case 'c':
                                charBase = 13;
                                break;
                            case 'd':
                                charBase = 14;
                                break;
                            case 'e':
                                charBase = 15;
                                break;
                            case 'f':
                                charBase = 16;
                        }
                    }
                    if(maxChar < charBase)
                        maxChar = charBase;
                }
            }

            if(maxChar != -1) {
                finalbaseval = maxChar;
            } else {
                finalbaseval = maxDigit + 1;
            }

            long localsum = 0;
            // After found the minimum base, convert to 10
            for(int j=chars.length-1; j>=0; j--) {
                char c = chars[j];
                int value = -1;
                if(!Character.isDigit(c)) {
                    value = returnNumberVal(c);
                } else {
                    value = c - '0';
                }
                localsum += value * Math.pow(finalbaseval, (chars.length-1-j));

//                System.out.println(value + " j:" + j + ":" + (chars.length-1-j));
//                System.out.println(value * Math.pow(finalbaseval, (chars.length-1-j)));
//                System.out.println();

            }
            sum += localsum;
//            System.out.println(finalbaseval +
//                    " base with local sum: " + localsum);
        }
        stdin.close();

        System.out.println(sum);

    }

    // if alphat should be a-f only
    static int returnNumberVal(char c) {
        if(c >= 97 && c <= 102) {
            switch (c) {
                case 'a':
                    return 10;
                case 'b':
                    return 11;
                case 'c':
                    return 12;
                case 'd':
                    return 13;
                case 'e':
                    return 14;
                case 'f':
                    return 15;
            }
        }
        return -1;
    }

}
