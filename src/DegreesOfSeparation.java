/**
 * Created by datse on 5/06/2015.
 */
public class DegreesOfSeparation {

    public static void main(String[] args) {
        String filename     = args[0];
        String delimiter    = args[1];
        String source       = args[2];

        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.G();

        if(!sg.contains(source)) {
            System.out.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        In in = new In(filename);
        while(!in.isEmpty()) {
            String sink = in.readLine();
            if(sg.contains(sink)) {
                int t = sg.index(sink);
                if(bfs.hasPathTo(t)) {
                    for(int v : bfs.pathTo(t)) {
                        System.out.println(" " + sg.name(v));
                    }
                } else {
                    System.out.println("Not connected");
                }
            } else {
                System.out.println("Not in database.");
            }
        }

    }

}
