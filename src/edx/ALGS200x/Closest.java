package edx.ALGS200x;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Closest {

    static class Point implements Comparable<Point> {

        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }

    }

    private static double distance(Point[] points, int low, int high) {
        return Math.sqrt(
                Math.pow((points[low].x - points[high].x), 2) +
                        Math.pow((points[low].y - points[high].y), 2));
    }

    static double minimalDistance(int[] x, int[] y) {

        Point[] points = new Point[x.length];
        for (int a = 0; a < x.length; a++) {
            points[a] = new Point(x[a], y[a]);
        }

        // Sorting x coordinates
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x > p2.x) return 1;
                if (p1.x == p2.x) return 0;
                return -1;
            }
        });

        return minimalDistance(points, 0, x.length - 1);

    }

    private static double minimalDistance(Point[] points, int low, int high) {

        double ans = Double.POSITIVE_INFINITY;
        // Base case
        if (low >= high) return Double.POSITIVE_INFINITY;
        if (high - low == 1) return distance(points, low, high);

        // should be based on array index or the x values ?
        int mid = (low + high) / 2;
        double d1 = minimalDistance(points, low, mid);
        double d2 = minimalDistance(points, mid + 1, high);
        double d = Math.min(d1, d2);

        ans = Math.min(ans, d);

        long midXval = points[mid].x;
        for (int i = low; i <= high; i++) {
            if (Math.abs(points[i].x - midXval) < d) {
                for (int j = i + 1; j <= high; j++) {
                    if (Math.abs(points[j].x - midXval) < d && Math.abs(points[i].y - points[j].y) < d) {
                        double distance = distance(points, i, j);
                        ans = Math.min(ans, distance);
                    }
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

}
