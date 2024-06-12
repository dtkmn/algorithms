package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TriesContacts {

    static class Node {
        Node[] arrays = new Node[26];
        int count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node tries = new Node();
        for(int i=0; i<n; i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            String operation = row.nextToken();
            String word = row.nextToken();
            Node current = tries;
            if("add".equals(operation)) {
                char[] chars = word.toCharArray();
                for(char c: chars) {
                    if(current.arrays[c-'a'] == null) {
                        Node node = new Node();
                        node.count = 1;
                        current.arrays[c-'a'] = node;
                    } else {
                        current.arrays[c-'a'].count++;
                    }
                    current = current.arrays[c-'a'];
                }
            } else {
                char[] chars = word.toCharArray();
                for(int j=0; j<chars.length; j++) {
                    if(current.arrays[chars[j]-'a'] == null) {
                        System.out.println(0);
                        break;
                    } else {
                        if(j+1 == chars.length) {
                            System.out.println(current.arrays[chars[j]-'a'].count);
                            break;
                        }
                    }
                    current = current.arrays[chars[j]-'a'];
                }
            }
        }

    }

}
