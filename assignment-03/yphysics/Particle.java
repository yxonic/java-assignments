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
public class Particle<T extends Vector> {

    // constant G under MKS
    final double G = 9.80665;

    T position, velocity, acceleration;
    double mass;
    String name;

    public Particle() {
        position = new T();
        velocity = new T();
        acceleration = new T();
    }

    public Particle(T r, T v) {
        position = r;
        velocity = v;
        acceleration = new T();
    }

    /**
     * Get the current position.
     */
    public T getPosition() {
        T pos = new T();
        pos.copy(position);
        return pos;
    }
    
    /**
     * Add a force and calculate the acceleration.
     */
    void addForce(T f) {
        acceleration.add(times(f, 1 / mass));
    }

    /**
     * Advance a time dt (by second).
     */
    void advance(double dt) {
        // calculate next position and velocity
        position.add(T.times(velocity, dt));
        velocity.add(T.times(acceleration, dt));

        // clear acceleration for next calculation
        acceleration.x = 0.0;
        acceleration.y = 0.0;
    }

    /**
     * Calculates the gravity between two particles.
     * @return A vector that points to the second given paritcle.
     */
    public static T gravity(Particle a, Particle b) {
        double d = T.distance(a.position, b.position);
        double force = G * a.mass * b.mass / d;
        T dir = T.substract(b, a);
        return dir.times(force / d);
    }
}
