/**
 * Created by dtkmn on 14/06/2015.
 */
public class LazyPrimMST {

    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<>();
        visit(G, 0);
        while(!pq.isEmpty()) {
            // Remove the lowest weight from pq
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            // The edge for v and w had been visited
            if(marked[v] && marked[w]) continue;
            mst.enqueue(e);
            if(!marked[v]) visit(G, v);
            if(!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for(Edge e: G.adj(v)) {
            if(!marked[e.other(v)]) {
                // Just adding every adjacent in pq to sort automatically (lazy mode)
                pq.insert(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for(Edge e: this.edges()) {
            weight += e.weight();
        }
        return weight;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        LazyPrimMST mst =  new LazyPrimMST(G);
        for(Edge e: mst.edges()) {
            System.out.println(e);
        }
//        System.out.printf("$.5f", mst.weight());
        System.out.println("Weight required: " + mst.weight());
    }

}
