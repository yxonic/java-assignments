/**
 * @file    NBody.java
 * @author  Yin Yu <yxonic@gmail.com>
 * @version 1.0
 *
 * @section LICENSE
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of
 * the License, or（at your option）any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details at
 * http://www.gnu.org/copyleft/gpl.html
 */

import yphysics.*;
import java.util.List;

class DrawUniverse {
    ParticleSystem universe = new ParticleSystem();
    double R, T, dt;
    // directory of source files
    final String src = "nbody/";

    public DrawUniverse(double scale, double time, double dt) {
        R = scale; T = time;
        this.dt = dt;
    }
    
    public void start() {
        StdAudio.play(src + "2001.mid");
        StdDraw.setXscale(-R, R);
        StdDraw.setYscale(-R, R);
        ParticleSystemListener l = new ParticleSystemListener() {
                private int skip = 0;
                private final int step = 500;
                public void onStart() {}
                public void onUpdate() { /*draw();*/ }
                public void onFinish() { log(); }
                public void onQuickUpdate() {
                    skip++;
                    if (skip == step) {
                        skip = 0;
                        draw(); 
                    }
                }
            };
        universe.addListener(l);
        universe.loop(dt, T);
    }

    void draw() {
        List<Particle> list = universe.getAllParticles();
        StdDraw.picture(0, 0, src + "starfield.jpg");
        for (Particle p : list) {
            Vector2D v = (Vector2D)p.getPosition();
            double[] pos = v.toDouble();
            StdDraw.filledCircle(pos[0], pos[1], 5e9);
            StdDraw.picture(pos[0], pos[1], src + p.getId() + ".gif");
        }
        StdDraw.show(10);
    }

    void log() {
        List<Particle> list = universe.getAllParticles();
        for (Particle p : list) {
            Vector2D v = (Vector2D)p.getPosition();
            double[] pos = v.toDouble();
            System.out.println(p.getId() + ":\t" + pos[0] + "\t" + pos[1]);
        }
    }

}

public class NBody {
    public static void main(String[] args) {
        double T, dt;
        T = Double.parseDouble(args[0]);
        dt = Double.parseDouble(args[1]);
        
        int N = StdIn.readInt();
        double R = StdIn.readDouble();
        
        DrawUniverse U = new DrawUniverse(R, T, dt);
        
        for (int i = 0; i < N; i++) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            double vx = StdIn.readDouble();
            double vy = StdIn.readDouble();
            Vector2D r = new Vector2D(x, y);
            Vector2D v = new Vector2D(vx, vy);
            
            double mass = StdIn.readDouble();

            String name = StdIn.readString().split("\\.")[0];

            Particle p = new Particle(r, v, mass, name);
            U.universe.addParticle(p);
        }
        U.start();
    }
}
