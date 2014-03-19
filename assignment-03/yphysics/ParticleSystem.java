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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Particle system simulation.
 */
public class ParticleSystem {
    // set precision factor
    private final double factor = 1500.0;

    Map<String, Particle> objects = new HashMap<String, Particle>();
    List<ParticleSystemListener> listeners =
        new ArrayList<ParticleSystemListener>();

    /**
     * Add a particle to the system before the system starts.
     * @param The particle to add to this system.
     */
    public void addParticle(Particle p) {
        objects.put(p.getId(), p);
    }

    /**
     * @return A list of all present particles.
     */
    public List<Particle> getAllParticles() {
        List<Particle> list = new ArrayList<Particle>(objects.values());
        return Collections.unmodifiableList(list);
    }

    /**
     * @param T for total time and dt for step. After each step,
     * onQuickUpdate() of listeners would be called.
     */
    void advance(double T, double dt) {
        double time = 0.0;
        while (time < T) {
            for (String obj : objects.keySet())
                for (String i : objects.keySet())
                    if (!i.equals(obj)) {
                        Particle p1 = objects.get(obj);
                        Particle p2 = objects.get(i);
                        p1.addForce(Particle.gravity(p1, p2));
                    }
            for (Map.Entry<String, Particle>entry : objects.entrySet())
                entry.getValue().advance(dt);
            for (ParticleSystemListener listener : listeners)
                listener.onQuickUpdate();
            time += dt;
        }
    }

    /**
     * Start the system.
     * @param T for update step. maxT for simulation time.
     */
    public void loop(double T, double maxT) {
        // use T as step is too rough. use dt instead.
        double time = 0.0, dt = T / factor;
        for (ParticleSystemListener listener : listeners)
            listener.onStart();
        while (time < maxT) {
            time += T;
            advance(T, dt); 
            for (ParticleSystemListener listener : listeners)
                listener.onUpdate();
        }
        for (ParticleSystemListener listener : listeners)
            listener.onFinish();
    }

    /**
     * Add a listener to the system.
     */
    public void addListener(ParticleSystemListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener is required");
        }
        listeners.add(listener);
    }

}
