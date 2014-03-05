public class RandomWalkers {
    final static int[] dx = RandomWalker.dx;
    final static int[] dy = RandomWalker.dy;
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        
        int sum = 0;
        for (int i = 0; i < T; i++) {
            int x = 0, y = 0;
            for (int j = 0; j < N; ++j) {
                int d = (int) (Math.random() * 4);
                x += dx[d]; y += dy[d];
            }
            sum += x * x + y * y;
        }
        double mean = (double) sum / T;
        System.out.println("mean squared distance = " + mean);
    }
}
