public class RandomWalker {
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            int d = (int) (Math.random() * 4);
            x += dx[d]; y += dy[d];
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("squared distance = " + (x * x + y * y));
    }
}
