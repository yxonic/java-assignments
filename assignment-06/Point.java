public class Point {
    double x, y;
    double r = 0.05;

    public Point() {
        this.x = this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x; this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public void draw() {
        StdDraw.filledCircle(x, y, r);
    }

    public void drawTo(Point that) {
        StdDraw.line(x, y, that.x, that.y);
    }

    public double distanceTo(Point that) {
        return Math.sqrt((x - that.x) * (x - that.x) +
                         (y - that.y) * (y - that.y));
    }

    public static void main(String[] args) {
        Point a = new Point(3, 4);
        Point b = new Point();
        StdDraw.setXscale(0, 5);
        StdDraw.setYscale(0, 5);
        a.draw();
        b.draw();
        b.drawTo(a);
        System.out.println(a.distanceTo(b));
        StdDraw.show();
    }
}
