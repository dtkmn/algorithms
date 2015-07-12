package hackerrank;

import java.util.*;

/**
 * Created by dtkmn on 10/07/2015.
 */
public class EvenTree {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // number of vertices
        int M = in.nextInt(); // number of edges

        int[] edges = new int[N+1];

        Map<Integer, List<Integer>> maps = new HashMap<>();

        for(int i=0; i<M; i++) {

            int vi = in.nextInt();
            int ui = in.nextInt();

            edges[ui]++;
            edges[vi]++;

            List<Integer> lists = maps.get(ui);
            if(lists == null) {
                lists = new ArrayList<>();
            }
            lists.add(vi);
            maps.put(ui, lists);


        }

        int root = 1;
        marked = new boolean[N+1];
        dfs(maps, root);


//        int count = 0;
//        for(int j=1; j<=N; j++) {
//            List<Integer> l = maps.get(j);
//            if(l != null) {
//                System.out.println(j + ":" + l.size());
//                if(l.size() % 2 == 0) {
//                    count++;
//                }
//            } else {
//                System.out.println(j + ":0");
//            }
//
//        }

        System.out.println(result-1);

    }

    private static boolean[] marked;

    private static int globalCount = 0;
    private static int result = 0;

    private static void dfs(Map<Integer, List<Integer>> maps, int v) {

        marked[v] = true;

        // all children of current node

        int childCount = 0;

        List<Integer> integerList = maps.get(v);
        childCount = maps.get(v)==null?0:maps.get(v).size();
//        System.out.println("Node " + v + " has " + childCount + " child");
        if(integerList != null) {
            for (int w : maps.get(v)) {
                childCount++;

                if (!marked[w]) {
                    dfs(maps, w);
                }
            }

//            System.out.println("Node " + v);
            System.out.println("global count on " + v + " : " + globalCount);
            if((globalCount + 1) % 2 == 0) {
                System.out.println("should Reset count here!! " + v + " :" + (globalCount+1));
                globalCount=0;
                result++;
            }


        } else {
//            System.out.println("Node " + v + " has 0 child");
        }
        globalCount++;


    }

}
