public class NearestInsertion {
    public static void main(String[] args) {
        int w = StdIn.readInt();
        int h = StdIn.readInt();
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);
        
        StdDraw.show(0);

        Tour tour = new Tour();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            Point p = new Point(x, y);
            tour.insertNearest(p);
        }
        tour.draw();
        StdDraw.show(0);
        StdOut.printf("Tour distance = %.4fn", tour.distance());
        StdOut.printf("Number of points = %d\n", tour.size());
        tour.show();
    }
}
