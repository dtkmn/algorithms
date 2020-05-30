package leetcode;

public class VerifyingAnAlienDictionary {

    // Time Complexity: O(words.length x Max length of word)
    // Space Complexity: O(1)
    public static boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < words.length - 1; i++) {
            // Compare 2 words every time
            String word1 = words[i];
            String word2 = words[i + 1];


            for (int j = 0 ; j < Math.max(word1.length(), word2.length()); j++) {

                if (j >= word1.length()) break;
                if (j >= word2.length()) return false;

                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (order.indexOf(c1) > order.indexOf(c2)) return false;
                // done check in current characters
                if (order.indexOf(c1) < order.indexOf(c2)) break;

            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[] { "hello","leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
        // true
        System.out.println(isAlienSorted(new String[] { "kuvp","q" }, "ngxlkthsjuoqcpavbfdermiywz"));
    }



}
