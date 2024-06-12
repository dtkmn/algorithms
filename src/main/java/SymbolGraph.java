/**
 * Created by datse on 5/06/2015.
 */
public class SymbolGraph {

    private ST<String, Integer> st;     // String -> index
    private String[] keys;              // index -> String
    private Graph G;                    // the graph

    public SymbolGraph(String stream, String sp) {
        st = new ST<>();

        In in = new In(stream);
        while(!in.isEmpty()) {
            String[] a = in.readLine().split(sp);
            for(int i = 0; i < a.length; i++) {
                if(!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }
        System.out.println("Done reading " + stream);

        keys = new String[st.size()];
        for(String name: st.keys()) {
            keys[st.get(name)] = name;
        }

        G = new Graph(st.size());
        in = new In(stream);
        while(in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);       // First item always the vertex
            for(int i = 1; i < a.length; i++) {
                int w = st.get(a[i]);
                G.addEdge(v, w);
            }
        }

    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph G() {
        return G;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.G();
        In in = new In(filename);
        while(in.hasNextLine()) {
            String source = in.readLine();
            if(sg.contains(source)) {
                int s = sg.index(source);
                for(int v: G.adj(s)) {
                    System.out.println(" " + sg.name(v));
                }
            } else {
                System.out.println("input not contain '" + source + "'");
            }
        }

    }



}
