package org.yxonic.snake;

import java.util.*;

public class Snake {
    public static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    public final int WIDTH, HEIGHT;
    private Board board;
    private Deque<Integer> snake;
    private int direction;
    private int score, factor;

    public Snake(int f) {
        setFactor(f);
        WIDTH = 40; HEIGHT = 30;
        board = new Board(WIDTH, HEIGHT);
        snake = new ArrayDeque<Integer>();
        snake.add(566); board.block(566);
        snake.add(567); board.block(567);
        snake.add(568); board.block(568);
        snake.add(569); board.block(569);
        snake.add(570); board.block(570);
        board.generateTreasure();
        direction = 1;
    }
    
    public void setFactor(int f) {
        factor = f;
    }

    public void changeDirection(int d) {
        int pos = board.next(snake.getLast(), d);
        int back = snake.removeLast();
        if (pos == snake.getLast()) {
            snake.addLast(back);
            return;
        }
        snake.addLast(back);
        direction = d;
    }

    public boolean move() {
        int pos = board.next(snake.getLast(), direction);
        if (board.isTreasure(pos)) {
            board.generateTreasure();
            score += factor;
        } else {
            int x = snake.removeFirst();
            board.unblock(x);
        }
        if (board.isBlocked(pos))
            return false;
        snake.add(pos); board.block(pos);
        return true;
    }

    public void addMap(int[] map) {
        for (int i : map) {
            board.block(i);
        }
        board.generateTreasure();
    }

    public int[] getState() {
        int[] result = new int[WIDTH * HEIGHT];
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                int pos = i * WIDTH + j;
                if (board.isBlocked(pos))
                    result[pos] = 1;
            }
        for (int pos : snake) {
            result[pos] = 2;
        }
        result[snake.getLast()] = 3; // Head
        result[snake.getFirst()] = 4; // Tail
        result[board.getTreasure()] = 5;
        return result;
    }

    public int score() {
        return score;
    }
}
