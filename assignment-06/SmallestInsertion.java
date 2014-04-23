public class SmallestInsertion {
    public static void main(String[] args) {
        int w = StdIn.readInt();
        int h = StdIn.readInt();
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);
        
        Tour tour = new Tour();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            Point p = new Point(x, y);
            tour.insertSmallest(p);
        }
        tour.draw();
        StdDraw.show();
                
        StdOut.printf("Tour distance = %.4f\n", tour.distance());
        StdOut.printf("Number of points = %d\n", tour.size());
        tour.show();
    }
}
