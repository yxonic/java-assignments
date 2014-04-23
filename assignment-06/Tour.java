public class Tour {
    private int sz = 0;
    private class Node {
        private Point p;
        private Node next;
        Node(Point p, Node next) {
            this.p = p; this.next = next;
        }
    }
    private Node head;

    public Tour() {
    }

    public Tour(Point a, Point b, Point c, Point d) {
        insertNearest(a);
        insertNearest(b);
        insertNearest(c);
        insertNearest(d);
    }

    public void show() {
        Node n = head;
        for (int i = 0; i < sz; i++) {
            StdOut.println(n.p);
            n = n.next;
        }
        StdOut.println(head.p);
    }
    
    public void draw() {
        Node n = head;
        for (int i = 0; i < sz - 1; i++) {
            n.p.drawTo(n.next.p);
            n = n.next;
        }
        n.p.drawTo(head.p);
    }

    public int size() {
        return sz;
    }

    public double distance() {
        Node n = head;
        double dist = 0.0;
        for (int i = 0; i < sz - 1; i++) {
            dist += n.p.distanceTo(n.next.p);
            n = n.next;
        }
        dist += n.p.distanceTo(head.p);
        return dist;
    }

    public void insertNearest(Point p) {
        if (head == null) {
            head = new Node(p, null);
            ++sz;
            return;
        }
        Node min_pos = head;
        Node n = head;
        
        for (int i = 1; i < sz; ++i) {
            n = n.next;
            if (n.p.distanceTo(p) < min_pos.p.distanceTo(p))
                min_pos = n;
        }
        Node x = new Node(p, min_pos.next);
        min_pos.next = x;
        ++sz;
    }

    double delta(Node pos, Point p) {
        if (pos.next == null)
            return pos.p.distanceTo(p) + p.distanceTo(head.p) - 
                head.p.distanceTo(pos.p);
        else
            return pos.p.distanceTo(p) + pos.next.p.distanceTo(p) -
                pos.p.distanceTo(pos.next.p);
    }

    public void insertSmallest(Point p) {
        if (head == null) {
            head = new Node(p, null);
            ++sz;
            return;
        }
        Node min_pos = head;
        Node n = head.next;
        for (int i = 1; i < sz; ++i) {
            if (delta(n, p) < delta(min_pos, p))
                min_pos = n;
            n = n.next;
        }
        Node x = new Node(p, min_pos.next);
        min_pos.next = x;
        ++sz;
    }

    public static void main(String[] args) {
        // define 4 points forming a square
        Point a = new Point(100.0, 100.0);
        Point b = new Point(500.0, 100.0);
        Point c = new Point(500.0, 500.0);
        Point d = new Point(100.0, 500.0);
        
        // Set up a Tour with those four points
        // The constructor should link a->b->c->d->a
        Tour squareTour = new Tour(a, b, c, d);
        
        // Output the Tour
        squareTour.show();   
    }
}
