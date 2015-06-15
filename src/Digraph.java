/**
 * Created by datse on 10/06/2015.
 */
public class Digraph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    // Read a graph from input stream in
    public Digraph(In in) {
        this(in.readInt());         // Read V and construct this graph
        int E = in.readInt();       // Read E.
        for(int i = 0; i < E; i++) {
            // Add an edge
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    // Directed graph has only one direction each time
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    // String representation
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for(int v = 0; v < V; v++) {
            s += v + ": ";
            for(int w: this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    // Return a copy with all its edges reversed?
    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for(int v = 0; v < V; v++) {
            for(int w: adj(v)) {
                // v and w is swapped here for reverse direction
                R.addEdge(w, v);
            }
        }
        return R;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph DG = new Digraph(in);
        System.out.println(DG);
        System.out.println("****************");
        System.out.println(DG.reverse());

    }

}
