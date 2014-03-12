/**
 * @file    Vector.java
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

public class Vector {
    public double x;
    public Vector() { this.x = 0.0; }
    public Vector(double x) { this.x = x; }
    public double length() { return Math.abs(x); }
    public void copy(Vector v) { x = v.x; }
    public boolean equals(Vector v) { return x == v.x; }
    public Vector add(Vector v) { x += v.x; return this; }
    public Vector substract(Vector v) { x -= v.x; return this; }
    public Vector times(double k) { x *= k; return this; }
    public static Vector nullVector() {
        return new Vector();
    }
    public static Vector add(Vector v1, Vector v2) {
        return new Vector(v1.x + v2.x);
    }
    public static Vector substract(Vector v1, Vector v2) {
        return new Vector(v1.x - v2.x);
    }
    public static Vector times(Vector v, double k) {
        return new Vector(v.x * k);
    }
    public static double dot(Vector v1, Vector v2) {
        return v1.x * v2.x;
    }
    public static double distance(Vector v1, Vector v2) {
        return Math.abs(v1.x - v2.x);
    }
}
