package edx.ALGS200x;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PointsAndSegments {

  private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {

    // Create segments array to save all start and end point within each segments, also points too
    Segment[] segments = new Segment[starts.length * 2 + points.length];

    // Loop through each start/end point pair on segments
    for (int m = 0, n = 0; m < starts.length; m++) {
      Segment start = new Segment();
      start.value = starts[m];
      start.type = 's';
      segments[n++] = start;
      Segment end = new Segment();
      end.value = ends[m];
      end.type = 'e';
      segments[n++] = end;
    }

    // Loop through each point and put it in segment array
    for (int p = 0, q = starts.length*2; p < points.length; p++) {
      Segment point = new Segment();
      point.value = points[p];
      point.type = 'p';
      point.index = p;
      segments[q++] = point;
    }

    System.out.println(Arrays.toString(segments));

    int[] cnt = new int[points.length];
    Arrays.sort(segments, new Comparator<Segment>() {
      @Override
      public int compare(Segment s1, Segment s2) {
        if (s1.value != s2.value) return s1.value - s2.value;
        else {
          // when type order should be 's', 'p', 'e'
          return s2.type - s1.type;
        }
      }
    });

    System.out.println(Arrays.toString(segments));

    int count = 0;
    for (Segment s: segments) {
      if (s.type == 's') count++;
      if (s.type == 'e') count--;
      if (s.type == 'p') s.count = count;
    }

    Arrays.sort(segments, new Comparator<Segment>() {
      @Override
      public int compare(Segment s1, Segment s2) {
        return s2.index - s1.index;
      }
    });

    System.out.println(Arrays.toString(segments));

    int index = 0;
    for (int s=0; s<segments.length; s++) {
      if (segments[s].type == 'p' && segments[s].index >= 0) {
        cnt[index++] = segments[s].count;
      }
    }

    return cnt;
  }

  static class Segment {
    int value;
    char type;
    int count;
    int index = -1;

    @Override
    public String toString() {
      return "Segment{" +
              "value=" + value +
              ", type=" + type +
              ", count=" + count +
              ", index=" + index +
              '}';
    }

  }

  private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
    int[] cnt = new int[points.length];
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < starts.length; j++) {
        if (starts[j] <= points[i] && points[i] <= ends[j]) {
          cnt[i]++;
        }
      }
    }
    return cnt;
  }



  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n, m;
    n = scanner.nextInt();
    m = scanner.nextInt();
    int[] starts = new int[n];
    int[] ends = new int[n];
    int[] points = new int[m];

    for (int i = 0; i < n; i++) {
      starts[i] = scanner.nextInt();
      ends[i] = scanner.nextInt();
    }
    for (int i = 0; i < m; i++) {
      points[i] = scanner.nextInt();
    }
    //use fastCountSegments
    int[] cnt = fastCountSegments(starts, ends, points);
    for (int x : cnt) {
      System.out.print(x + " ");
    }
  }

}
