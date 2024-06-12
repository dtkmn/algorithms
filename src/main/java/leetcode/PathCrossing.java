package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/problems/path-crossing/">...</a>
 */
public class PathCrossing {

    public boolean isPathCrossing(String path) {
        Map<Character, int[]> directions = Map.of(
                'N', new int[]{ 1, 0 },
                'E', new int[]{ 0, 1 },
                'S', new int[]{ -1, 0 },
                'W', new int[]{ 0, -1 }
        );
        Map<String, Integer> visited = new HashMap<>();
        int[] current = new int[] { 0, 0 };
        visited.put(Arrays.toString(current), 1);
        for (char c: path.toCharArray()) {
            int[] d = directions.get(c);
            current[0] += d[0];
            current[1] += d[1];
            if (visited.containsKey(Arrays.toString(current))) return true;
            visited.put(Arrays.toString(current), 1);
        }
        return false;
    }

    public static void main(String[] args) {
        PathCrossing system = new PathCrossing();
        System.out.println(system.isPathCrossing("NESWW"));
    }
}
