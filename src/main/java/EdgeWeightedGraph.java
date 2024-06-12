/**
 * Created by dtkmn on 14/06/2015.
 */
public class EdgeWeightedGraph {

    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for(int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }


    public EdgeWeightedGraph(In in) {
        this(in.readInt());         // Read V and construct this graph
        int E = in.readInt();       // Read E.
        for(int i = 0; i < E; i++) {
            // Add an edge
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new Edge(v, w, weight));
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<Edge>();
        for(int v = 0; v < V; v++) {
            for(Edge e: adj[v]) {
                if(e.other(v) > v)
                    b.add(e);
            }
        }
        return b;
    }


}
