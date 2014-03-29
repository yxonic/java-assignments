public class Sierpinski {
    static final double h = Math.sqrt(3) / 2;
    static final double w = 1.0 / 2.0;
    
    static void filledTriangle(double x, double y, double s) {
        double[] xx = {x, x - s * w, x + s * w};
        double[] yy = {y, y + s * h, y + s * h};
        StdDraw.filledPolygon(xx, yy);
    }

    static void sierpinski(int n, double x, double y, double s) {
        if (n <= 0) return;
        filledTriangle(x + s * w, y, s * w);
        sierpinski(n - 1, x, y, s * w);
        sierpinski(n - 1, x + s * w, y, s * w);
        sierpinski(n - 1, x + s * w * w, y + s * h * w, s * w);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);            
        StdDraw.line(0, 0, w, h);
        StdDraw.line(w, h, 1, 0);
        StdDraw.line(0, 0, 1, 0);
        sierpinski(n, 0, 0, 1);
    }
}
