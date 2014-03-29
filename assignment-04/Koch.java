public class Koch {
    static final double h = Math.sqrt(3) / 2.0;
    static final double w = 1.0 / 2.0;
    
    static void triangle(double x, double y, double dx, double dy) {
        StdDraw.setPenRadius(.005);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.line(x, y, x + dx, y + dy);
        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.line(x, y, x + dx * w - dy * h, y + dx * h + dy * w);
        StdDraw.line(x + dx * w - dy * h, y + dx * h + dy * w,
                     x + dx, y + dy);
    }

    static void koch(int n, double x1, double y1, double x2, double y2) {
        if (n <= 0) return;
        double d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        d = Math.sqrt(d);
        double dx = x2 - x1, dy = y2 - y1;
        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.line(x1, y1, x2, y2);
        triangle(x1 + dx / 3, y1 + dy / 3, dx / 3, dy / 3);
        koch(n - 1, x1, y1, x1 + dx / 3, y1 + dy / 3);
        koch(n - 1, x1 + dx / 3, y1 + dy / 3,
             x1 + (dx + w * dx - h * dy) / 3,
             y1 + (dy + h * dx + w * dy) / 3);
        koch(n - 1, x1 + (dx + w * dx - h * dy) / 3,
             y1 + (dy + h * dx + w * dy) / 3,
             x1 + dx * 2 / 3, y1 + dy * 2 / 3);
        koch(n - 1, x1 + dx * 2 / 3, y1 + dy * 2 / 3,
             x2, y2);
    }

    public static void main(String[] args) {
        int n;
        if (args.length == 0)
            n = 4;
        else
            n = Integer.parseInt(args[0]);
        StdDraw.setXscale(-0.1, 1.1);
        StdDraw.setYscale(0, 1.2);
        koch(n, 0, h, 1, h);
        koch(n, 1, h, w, 0);
        koch(n, w, 0, 0, h);
    }
}
