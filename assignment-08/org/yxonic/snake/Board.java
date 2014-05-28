package org.yxonic.snake;

public class Board {
    public static final int[] dx = {-1, 0, 1, 0};
    public static final int[] dy = {0, 1, 0, -1};
    
    public final int WIDTH, HEIGHT;

    private int treasure;
    private boolean[] blocks;

    public Board(int w, int h) {
        this.WIDTH = w;
        this.HEIGHT = h;
        blocks = new boolean[w * h];
    }

    public void generateTreasure() {
        while (true) {
            int n = (int) (Math.random() * WIDTH * HEIGHT);
            if (!blocks[n]) {
                treasure = n;
                break;
            }
        }
    }
    
    public boolean isTreasure(int pos) {
        return pos == treasure;
    }

    public int getTreasure() {
        return treasure;
    }

    public void block(int pos) {
        blocks[pos] = true;
    }
    
    public void unblock(int pos) {
        blocks[pos] = false;
    }

    public boolean isBlocked(int pos) {
        return blocks[pos];
    }

    public int next(int pos, int d) {
        int r = pos / WIDTH, c = pos % WIDTH;
        int x = (r + dx[d] + HEIGHT) % HEIGHT;
        int y = (c + dy[d] + WIDTH) % WIDTH;
        return x * WIDTH + y;
    }
}
