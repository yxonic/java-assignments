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

    // constant G under MKS
    static final double G = 6.67428e-11;

    Vector position, velocity, acceleration;
    double mass;
    String name;

    public Particle(Vector r, Vector v, double m, String n) {
        position = r;
        velocity = v;
        acceleration = v.nullVector();
        mass = m;
        name = n;
    }

    /**
     * @return The unique name of this particle.
     */
    public String getId() {
        return name;
    }

    /**
     * Get the current position.
     */
    public Vector getPosition() {
        return position;
    }
    
    /**
     * Add a force and calculate the acceleration.
     */
    void addForce(Vector f) {
        acceleration = acceleration.add(f);
    }

    /**
     * Advance a time dt (by second).
     */
    void advance(double dt) {
        // calculate next position and velocity
        position = position.add(velocity.times(dt)).
            add(acceleration.times(dt * dt));
        velocity = velocity.add(acceleration.times(dt));

        // clear acceleration for next calculation
        acceleration = acceleration.nullVector();
    }

    /**
     * Calculates the gravity acceleration between two particles.
     * @return A vector that points to the second given paritcle.
     */
    static Vector gravity(Particle a, Particle b) {
        double d = a.position.distance(b.position);
        // if two objects are enough close, then see them as a whole
        if (d < 1e-10) return a.acceleration.nullVector();
        double force = G * b.mass / d / d;
        Vector dir = b.getPosition().substract(a.getPosition());
        return dir.times(force / d);
    }
}
