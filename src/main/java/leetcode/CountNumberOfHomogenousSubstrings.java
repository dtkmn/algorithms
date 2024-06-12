package leetcode;

public class CountNumberOfHomogenousSubstrings {

    public int countHomogenous(String s) {
        long M = 1000000007;
        char prev = ' ';
        int count = 0;
        long ans = 0;
        for (char c: s.toCharArray()) {
            if (c != prev) {
                ans += fact(count);
                count = 1;
                prev = c;
            } else count++;
        }
        return (int) ((ans += fact(count)) % M);
    }

    public int countHomogenous_nofactorial(String s) {
        long M = 1000000007;
        char prev = ' ';
        int count = 0;
        long ans = 0;
        for (char c: s.toCharArray()) {
            if (c != prev) {
                count = 1;
                prev = c;
            } else count++;
            ans += count;
        }
        return (int) (ans % M);
    }

    public long fact(int v) {
        if (v <= 0) return 0;
        return v + fact(v - 1);
    }

    public static void main(String[] args) {
        System.out.println(new CountNumberOfHomogenousSubstrings().countHomogenous("abbcccaa"));
        System.out.println(new CountNumberOfHomogenousSubstrings().countHomogenous("zzzzz"));
    }

}
