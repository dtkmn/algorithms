/**
 * Created by datse on 2/06/2015.
 */
public class Graph {

    private int V;
    private int E;
    private Bag<Integer>[] adj;

    // Create a V-vertex graph with no edges
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    // Read a graph from input stream in
    public Graph(In in) {
        this(in.readInt());         // Read V and construct this graph
        int E = in.readInt();       // Read E.
        for(int i = 0; i < E; i++) {
            // Add an edge
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    // number of vertices
    public int V() {
        return V;
    }
    // number of edges
    public int E() {
        return E;
    }
    // add v-w edge to this graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    // vertices adjacent to v
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

    // compute the degree of v
    public static int degree(Graph G, int v) {
        int degree = 0;
        for(int w: G.adj(v)) degree++;
        return degree;
    }

    // compute maximum degree
    public static int maxDegree(Graph G) {
        int max = 0;
        for(int v = 0; v < G.V(); v++) {
            if(degree(G, v) > max)
                max = degree(G, v);
        }
        return max;
    }

    // compute average degree
    public static int avgDegree(Graph G) {
        return 2 * G.E()/ G.V();
    }

    // count self-loops
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for(int v = 0; v < G.V(); v++) {
            for(int w : G.adj(v)) {
                if(v == w) count++;
            }
        }
        return count / 2;   // each edge count twice
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        System.out.println(G);


        System.out.println("adj of 3");
        Iterable<Integer> integers = G.adj(3);
        for(Integer i: integers) {
            System.out.println(i);
        }

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(G, 0);
        System.out.println("Count: " + depthFirstSearch.count());

    }




}
