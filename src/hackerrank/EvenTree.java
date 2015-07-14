package hackerrank;

import java.util.*;

/**
 * Created by dtkmn on 10/07/2015.
 */
public class EvenTree {

    private static boolean[] marked;
    private static int result = 0;

    private static int[] childCount;
    private static int[] parentOf;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // number of vertices
        int M = in.nextInt(); // number of edges

        parentOf = new int[N+1];

        Map<Integer, List<Integer>> maps = new HashMap<>();

        for(int i=0; i<M; i++) {

            int vi = in.nextInt();
            int ui = in.nextInt();

            parentOf[vi] = ui;

            List<Integer> lists = maps.get(ui);
            if(lists == null) {
                lists = new ArrayList<>();
            }
            lists.add(vi);
            maps.put(ui, lists);

        }

        int root = 1;
        marked = new boolean[N+1];
        childCount = new int[N+1];
        dfs(maps, root);
        System.out.println(result);

    }

    private static void dfs(Map<Integer, List<Integer>> maps, int v) {

        marked[v] = true;
        List<Integer> integerList = maps.get(v);
        if(integerList != null) {
            int childs = 0;
            for (int w : maps.get(v)) {
                if (!marked[w]) {
                    dfs(maps, w);
                }
                childs += childCount[w];
            }

            childCount[v] = integerList.size() + childs;
            if((childCount[v]+1) % 2 == 0) {
                // Remove this node from maps
                int parent = parentOf[v];
                if(parent != 0) result++;
                if(maps.get(parent) != null) {
                    maps.remove(v);
                }
            }

        } else {
            childCount[v] = 0;
        }

    }

}
