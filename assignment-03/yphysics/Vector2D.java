/**
 * @file    Vector2D.java
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
 * A simple 2-dimentional vector, with some common operations.
 */
class Vector2D {

    // two coordinates
    double x = 0.0, y = 0.0;
    
    /**
     * Create a null vector
     */
    Vector2D() {
    }

    /**
     * Create a vector with given coodinates
     */
    Vector2D(double x, double y) {
        this.x = x; this.y = y;
    }

    /**
     * Compare two vectors.
     * @return True if two vectors identify.
     */
    boolean equals(Vector2D v) {
        return x == v.x && y == v.y;
    }

    /**
     * Add a vectors to itself.
     */
    Vector2D add(Vector2D v) {
        x += v.x;
        y += v.y;
        return this;
    }

    /**
     * Substract by a vector.
     */
    Vector2D add(Vector2D v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    /**
     * Times a real number.
     */
    Vector2D times(double k) {
        return new Vector2D(x * k, y * k);
    }

    /**
     * Add two vectors.
     */
    static Vector2D add(Vector2D v1, Vector2D v2) {
        return new Vector2D(v1.x + v2.x, v1.y + v2.y);
    }

    /**
     * Substract two vectors.
     */
    static Vector2D substract(Vector2D v1, Vector2D v2) {
        return new Vector2D(v1.x - v2.x, v1.y - v2.y);
    }

    /**
     * A vector times a real number.
     */
    static Vector2D times(Vector2D v, double k) {
        return new Vector2D(v.x * k, v.y * k);
    }

    /**
     * @return The dot product of two vectors.
     */
    static double dot(Vector2D v1, Vector2D v2) {
        return v1.x * v2.x - v1.y * v2.y;
    }

    /**
     * Calculate the Eculidian distance.
     * @return The distance.
     */
    static double distance(Vector2D v1, Vector2D v2) {
        return substract(v1, v2).length();
    }

    /**
     * @return The length of this vector.
     */
    double length() {
        return Math.sqrt(x * x + y * y);
    }
}
