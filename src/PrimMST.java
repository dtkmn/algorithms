/**
 * Created by datse on 16/06/2015.
 */
public class PrimMST {

    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
//    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for(int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
//        pq = new IndexMinPQ<Double>(G.V());



    }

}
