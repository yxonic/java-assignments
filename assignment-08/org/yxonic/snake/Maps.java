package org.yxonic.snake;

import java.util.*;

public class Maps {
    public static final int[] NONE = {},
        BOX = new int[136], 
        LINES = new int[40],
        HALL = new int[56],
        ROOMS = new int[97];
    static {
        for (int i = 0; i < 40; ++i) {
            BOX[i] = i;
            BOX[i + 40] = i + 1160;
        }
        for (int j = 0; j < 28; ++j) {
            BOX[j + 80] = (j + 1) * 40;
            BOX[j + 108] = (j + 2) * 40 - 1;
        }
        for (int i = 0; i < 20; ++i) {
            LINES[i] = 210 + i;
            LINES[i + 20] = 970 + i;
        }
        for (int i = 0; i < 18; ++i) {
            HALL[i] = 211 + i;
            HALL[i + 18] = 971 + i;
        }
        for (int i = 0; i < 5; ++i) {
            HALL[i + 36] = 130 + i * 40;
            HALL[i + 41] = 149 + i * 40;
            HALL[i + 46] = 890 + i * 40;
            HALL[i + 51] = 909 + i * 40;
        }
        for (int i = 0; i < 35; ++i) {
            int vx = 0, vy = 0;
            if (i >= 30) vx = 5;
            if (i >= 12) vy = 5;
            ROOMS[i] = 440 + i + vx;
            ROOMS[i + 35] = 720 + i + vy;
        }
        for (int i = 0; i < 11; ++i)
            ROOMS[i + 70] = 40 * i + 20;
        for (int i = 0; i < 8; ++i) {
            ROOMS[i + 81] = (i + 19) * 40 + 11;
            ROOMS[i + 89] = (i + 22) * 40 + 30;
        }
    }
}
