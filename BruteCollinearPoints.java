import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.*;

public class BruteCollinearPoints {

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
        for (int i = 0; i < points.length - 3; i++) {
            Comparator<Point> linear = points[i].slopeOrder();
            for (int j = i + 1; j < points.length - 2; j++) {
                mainloop : for (int k = j + 1; k < points.length - 1; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                            Point a1 = points[i];
                            Point b = points[j];
                            Point c = points[k];
                            Point d = points[l];
                            if (a1.slopeTo(b) == a1.slopeTo(c) && a1.slopeTo(c) == a1.slopeTo(d)) {
                                Point[] segmental = new Point[4];
                                segmental[0] = a1;
                                segmental[1] = b;
                                segmental[2] = c;
                                segmental[3] = d;
                                Arrays.sort(segmental);
                                a = new LineSegment(segmental[0], segmental[3]);
                                allSegments.add(a);
                                break mainloop;
                            }
                    }
                }

            }
        }
    }   // finds all line segments containing 4 points


    public int numberOfSegments() {
        return allSegments.size();
    }       // the number of line segments


    public LineSegment[] segments() {
        LineSegment[] returner = allSegments.toArray(new LineSegment[allSegments.size()]);
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
