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
    final double G = 9.80665;

    Vector2D position, velocity, acceleration;
    double mass;
    String name;

    public Particle() {
        position = new Vector2D();
        velocity = new Vector2D();
        acceleration = new Vector2D();
    }

    public Particle(Vector2D r, Vector2D v) {
        position = r;
        velocity = v;
        acceleration = new Vector2D();
    }

    /**
     * Get the current position.
     */
    public Vector2D getPosition() {
        Vector2D pos = new Vector2D(position.x, position.y);
        return pos;
    }
    
    /**
     * Add a force and calculate the acceleration.
     */
    void addForce(Vector2D f) {
        acceleration.add(times(f, 1 / mass));
    }

    /**
     * Advance a time dt (by second).
     */
    void advance(double dt) {
        // calculate next position and velocity
        position.add(Vector2D.times(velocity, dt));
        velocity.add(Vector2D.times(acceleration, dt));

        // clear acceleration for next calculation
        acceleration.x = 0.0;
        acceleration.y = 0.0;
    }

    /**
     * Calculates the gravity between two particles.
     * @return A vector that points to the second given paritcle.
     */
    public static Vector2D gravity(Particle a, Particle b) {
        double d = Vector2D.distance(a.position, b.position);
        double force = G * a.mass * b.mass / d;
        Vector2D dir = Vector2D.substract(b, a);
        return dir.times(force / d);
    }
}
