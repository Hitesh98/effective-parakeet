import java.util.Comparator;
import java.util.ArrayList;

import edu.princeton.cs.algs4.*;

public class BruteCollinearPoints {

    private int numberOfSegments = 0;
    private ArrayList<LineSegment> allSegments = new ArrayList<LineSegment>();
    private LineSegment a;


    public BruteCollinearPoints(Point[] points)  {
        if (points == null) {
            throw new java.lang.IllegalArgumentException("Bad Input!");
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new java.lang.IllegalArgumentException("Bad Array Of Values");
            }
        }
        for (int i = 0; i < points.length - 4; i++) {
            Comparator<Point> linear = points[i].slopeOrder();
            for (int j = i + 1; j < points.length - 3; j++) {
                if ()
                for (int k = j + 1; i < points.length - 2; i++) {
                    for (int l = k + 1; j < points.length - 1; j++) {
                        if (linear.compare(points[j], points[k]) == 0 && linear.compare(points[k], points[l]) == 0) {
                            numberOfSegments++;
                            a = new LineSegment(points[i], points[l]);
                            allSegments.add(a);
                        }
                    }
                }

            }
        }
    }   // finds all line segments containing 4 points


    public int numberOfSegments() {
        return numberOfSegments;
    }       // the number of line segments


    public LineSegment[] segments() {
        LineSegment[] returner = new LineSegment[allSegments.size()];
        int i = 0;
        for (LineSegment l : allSegments) {
            returner[i] = allSegments.get(i);
            i++;
        }
        return returner;
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }


}
