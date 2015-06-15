/**
 * Created by dtkmn on 2/06/2015.
 */
public class DepthFirstSearch {

    private boolean[] marked;       // has dfs() been called for this vertex?
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for(int w: G.adj(v)) {
            if(!marked[w]) dfs(G, w);
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }



}
