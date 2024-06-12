import java.util.Stack;

/**
 * Created by dtkmn on 2/06/2015.
 */
public class DepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        // used to save the direction between 2 points
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for(int w: G.adj(v)) {
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }


    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        System.out.println(G);

        System.out.println();

        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(G, 0);
        Iterable<Integer> iterable = depthFirstPaths.pathTo(8);
        if(iterable != null) {
            for (int e : iterable) {
                System.out.print(e + ".");
            }
        } else {
            System.out.println("No path to...");
        }

    }

}
