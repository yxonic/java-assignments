/**
 * @file    Particle.java
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

package yphysics;

/**
 * Simple mass point model for a real-world object.
 */
public class Particle {
    Vector2D position, velocity, acceleratation;
    double mass;
    String name;

    public Particle() {
    }

    public Particle(Vector2D r, Vector2D v) {
    }

    public void addForce(Vector2D f) {
    }

    public void advance(double dt) {
    }

    public static Vector2D gravity(Particle a, Particle b) {
    }
}
