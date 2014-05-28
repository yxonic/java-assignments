package org.yxonic.snake;

import java.awt.event.*;
import javax.swing.Timer;

public class SnakeTimer extends Timer {
    public static final int EASY = 0, NORMAL = 1, HARD = 2, INSANE = 3;
    private static final int[] delay = {300, 150, 75, 30};
    public SnakeTimer(int speed, ActionListener l) {
        super(delay[speed], l);
    }
}
