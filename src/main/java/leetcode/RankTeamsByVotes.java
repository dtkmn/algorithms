package leetcode;


import java.util.*;

/*
    https://leetcode.com/problems/rank-teams-by-votes/
 */
public class RankTeamsByVotes {

    Map<Character, int[]> mapCount;

    public String rankTeams(String[] votes) {
        if (votes.length == 0) return "";

        int voteslength = votes[0].length();
        mapCount = new HashMap<>();
        for (String vote: votes) {
            char[] carray = vote.toCharArray();
            for (int i = 0; i < carray.length; i++) {
                int[] teamVote = mapCount.getOrDefault(carray[i], new int[voteslength]);
                teamVote[i]++;
                mapCount.put(carray[i], teamVote);
            }
        }
        List<Map.Entry<Character, int[]>> entries = new ArrayList<>(mapCount.entrySet());
        entries.sort(entryComparator);
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, int[]> entry : entries) {
            ans.append(entry.getKey());
        }
        System.out.println(ans.toString());
        return ans.toString();
    }

    Comparator<Map.Entry<Character, int[]>> entryComparator = (e1, e2) -> {
        int[] countArray1 = e1.getValue();
        int[] countArray2 = e2.getValue();
        for (int i = 0; i < countArray1.length; i++) {
            if (countArray1[i] != countArray2[i]) return Integer.compare(countArray2[i], countArray1[i]);
        }
        return e1.getKey().compareTo(e2.getKey());
    };

    public static void main(String[] args) {
        new RankTeamsByVotes().rankTeams(new String[] {
            "ABC","ACB","ABC","ACB","ACB"
        });
        new RankTeamsByVotes().rankTeams(new String[] {
            "WXYZ","XYZW"
        });
    }



}
