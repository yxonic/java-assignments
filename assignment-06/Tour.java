public class Tour {
    private double dist = 0.0;
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
            StdOut.println(n.p + "  -->  ");
            n = n.next;
        }
        StdOut.println(head.p);
    }
    
    public void draw() {
        Node n = head;
        for (int i = 0; i < sz - 1; i++) {
            n.p.draw();
            n.p.drawTo(n.next.p);
            n = n.next;
        }
        n.p.draw();
        n.p.drawTo(head.p);
    }

    public int size() {
        return sz;
    }

    public double distance() {
        return dist;
    }

    public void insertNearest(Point p) {
        if (head == null) {
            head = new Node(p, null);
            return;
        }
        Node min_pos = head;
        Node n = head;
        for (int i = 1; i < sz; ++i) {
            if (n.p.distanceTo(p) < min_pos.p.distanceTo(p))
                min_pos = n;
            n = n.next;
        }
        Node x = new Node(p, min_pos.next);
        min_pos.next = x;
        ++sz;
    }

    double delta(Node pos, Point p) {
        if (pos.next == null)
            return pos.p.distanceTo(p);
        else
            return pos.p.distanceTo(p) + pos.next.p.distanceTo(p) -
                pos.p.distanceTo(pos.next.p);
    }

    public void insertSmallest(Point p) {
        if (head == null) {
            head = new Node(p, null);
            return;
        }
        Node min_pos = head;
        Node n = head;
        for (int i = 0; i < sz; ++i) {
            if (delta(n, p) < delta(min_pos, p))
                min_pos = n;
            n = n.next;
        }
        if (p.distanceTo(head.p) < delta(min_pos, p)) {
            head = new Node(p, head);
            return;
        }
        Node x = new Node(p, min_pos.next);
        min_pos.next = x;
    }

    public static void main(String[] args) {
        return;
    }
}
