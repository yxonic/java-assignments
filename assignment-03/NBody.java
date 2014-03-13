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


public class NBody {
    static Vector2D p = new Vector2D();
    static Vector2D v = new Vector2D();
    static Vector2D p2 = new Vector2D(1.5e11, 0.0);
    static Vector2D v2 = new Vector2D(0.0, 3e4);
    static Particle pt = new Particle(p, v, 2e30, "pt1");
    static Particle pt2 = new Particle(p2, v2, 6e24, "pt2");
    static ParticleSystem ps = new ParticleSystem();

    static class Listener implements ParticleSystemListener {
        public void onUpdate() {
            System.out.println("Hit!");
            System.out.println(pt2.getPosition().toDouble()[0]);
        }
    }


    public static void main(String[] args) {
        ps.addParticle(pt);
        ps.addParticle(pt2);
        Listener ls = new Listener();
        ps.addListener(ls);
        ps.loop(157788000000.0, 100000);
    }
}
