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

    public DrawUniverse(double scale, double time, double dt) {
        R = scale; T = time;
        this.dt = dt;
    }
    
    public void start() {
        //StdDraw.setXscale(-R, R);
        //StdDraw.setYscale(-R, R);
        ParticleSystemListener l = new ParticleSystemListener() {
                public void onUpdate() {
                    draw();
                    log();
                }
            };
        universe.addListener(l);
        universe.loop(dt, T);
    }

    void draw() {
        //StdDraw.show(30);
    }

    void log() {
        List<Particle> list = universe.getAllParticles();
        for (Particle p : list) {
            Vector2D v = (Vector2D)p.getPosition();
            System.out.println(v);
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
