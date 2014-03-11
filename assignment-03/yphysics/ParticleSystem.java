/**
 * @file    ParticleSystem.java
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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Particle system simulation.
 */
public class ParticleSystem<T extends Vector> {
    Map<String, Particle<T>> objects = new HashMap<String, Particle<T>>();
    List<ParticleSystemListener> listeners =
        new List<ParticleSystemListener>();

    public ParticleSystem() {
    }

    public void addParticle(Particle<T> p) {
        objects.put(p.getId(), p);
    }

    public List<Particle<T>> getAllParticles() {
        List<Particle<T>> list = List<Particle<T>>(objects.values()))
        return Collections.unmodifiableList(list);
    }

    void advance(double T, double dt) {
        double time = 0.0;
        while (time < T) {
            for (Particle<T> obj : objects)
                for (Particle<T> i : objects)
                    if (i != obj)
                        obj.addForce(Particle.gravity(obj, i));
            for (Particle<T> obj : objects)
                obj.advance(dt);
            time += dt;
        }
    }

    public void loop(double T, double dt) {
        while (1) {
            advance(T, dt); 
            for (ParticleSystemListener listener : listeners)
                listener.onUpdate();
        }
    }

    public void addListener(ParticleSystemListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener is required");
        }
        listeners.put(listener);
    }

    public void removeListener(SpringSystemListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener is required");
        }
        listeners.remove(listener);
    }
    
    public void removeAllListeners() {
        listeners.clear();
    }
}
