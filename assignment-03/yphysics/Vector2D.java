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
public class Vector2D implements Vector {

    // two coordinates
    private double x = 0.0, y = 0.0;
    
    /**
     * Create a null vector.
     */
    public Vector2D() {
    }
    
    /**
     * Create a vector with given coodinates.
     */
    public Vector2D(double... x) {
        this.x = x[0]; this.y = x[1];
    }

    /**
     * @return A null Vector2D.
     */
    public Vector2D nullVector() {
        return new Vector2D();
    }

    /**
     * @return The length of this vector.
     */
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Compare two vectors.
     * @return True if two vectors identify.
     */
    public boolean equals(Vector vec) {
        Vector2D v = (Vector2D) vec;
        return x == v.x && y == v.y;
    }

    /**
     * Add up two vectors.
     */
    public Vector2D add(Vector vec) {
        Vector2D v = (Vector2D) vec;
        return new Vector2D(x + v.x, y + v.y);
    }

    /**
     * Substract two vectors.
     */
    public Vector2D substract(Vector vec) {
        Vector2D v = (Vector2D) vec;
        return new Vector2D(x - v.x, y - v.y);
    }

    /**
     * Times a real number.
     */
    public Vector2D times(double k) {
        return new Vector2D(x * k, y * k);
    }

    /**
     * Calculate the Eculidian distance.
     * @return The distance.
     */
    public double distance(Vector vec) {
        Vector2D v = (Vector2D) vec;
        return substract(v).length();
    }

    /**
     * @return The dot product of two vectors.
     */
    public double dot(Vector vec) {
        Vector2D v = (Vector2D) vec;
        return x * v.x + y * v.y;
    }

    /**
     * @return The value with a format like 'x,y'
     */
    public String toString() {
        return ((Double)x).toString() + ',' + y;
    }

    /**
     * @return The coodinates packed in an array.
     */
    public double[] toDouble() {
        double[] ans = new double[2];
        ans[0] = x; ans[1] = y;
        return ans;
    }
}
