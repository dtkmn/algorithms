/**
 * Created by datse on 4/06/2015.
 */
public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for(int s = 0; s < G.V(); s++) {
            if(!marked[s])
                dfs(G, s, s);
        }
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for(int w: G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w, v);
            } else if(w != u){
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        Cycle cycle = new Cycle(G);
        System.out.println(cycle.hasCycle());

    }

}
