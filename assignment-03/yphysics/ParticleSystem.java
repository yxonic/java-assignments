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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Particle system simulation.
 */
public class ParticleSystem {
    Map<String, Particle> objects = new HashMap<String, Particle>();

    public ParticleSystem() {
    }

    public void addParticle(Particle p) {
        
    }

    public List<Particle> getAllParticles() {
    }

    void advance(double T, double dt) {
        double time = 0.0;
        while (time < T) {
            for (Particle obj : objects)
                for (Particle i : objects)
                    if (i != obj)
                        obj.addForce(Particle.gravity(obj, i));
            for (Particle obj : objects)
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
        listeners.addListener(listener);
    }

    public void removeListener(SpringSystemListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener is required");
        }
        listeners.removeListener(listener);
    }
    
    public void removeAllListeners() {
        listeners.clear();
    }
}
