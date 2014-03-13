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

public class NBodyTest {
    static Vector2D p1 = new Vector2D();
    static Vector2D p2 = new Vector2D(1.5e11,0);
    static Vector2D v1 = new Vector2D();
    static Vector2D v2 = new Vector2D(0,3e4);
    static double m1 = 2e30, m2 = 6e24;
    static Particle pt1 = new Particle(p1, v1, m1, "Pt 1");
    static Particle pt2 = new Particle(p2, v2, m2, "Pt 2");
    static class MyListener implements ParticleSystemListener {
        public void onUpdate() {
            System.out.println("HIT!");
            System.out.println(pt2.getPosition());
            System.out.println(pt2.getPosition().length());
        }
    }
    static ParticleSystem ps = new ParticleSystem();

    public static void main(String[] args) {
        ps.addParticle(pt1);
        ps.addParticle(pt2);
        ps.addListener(new MyListener());
        ps.loop(25000.0,0.01);
    }
}
