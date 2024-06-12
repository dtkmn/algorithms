import java.util.Stack;

/**
 * Created by datse on 10/06/2015.
 */
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    // vertices on a cycle (if one exists)
    private Stack<Integer> cycle;
    // vertices on recursive call stack
    private boolean[] onStack;

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for(int v=0; v<G.V(); v++) {
            if(!marked[v]) dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for(int w: G.adj(v)) {
            if(this.hasCycle()) return;
            else if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if(onStack[w]) {
                // Remember it is called recursive
                // and onStack include the current path vertices!
                cycle = new Stack<>();
                for(int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                System.out.println("v " + v);
                System.out.println("w " + w);
                System.out.println(cycle);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));

        DirectedCycle directedCycle = new DirectedCycle(G);

        if(directedCycle.hasCycle()) {
            System.out.println("Graph has cycle!");
            for(int i: directedCycle.cycle()) {
                System.out.print(i + " ");
            }
        }
    }

}
