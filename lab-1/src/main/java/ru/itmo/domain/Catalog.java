package ru.itmo.domain;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Planet> planets = new ArrayList<>();

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    public Planet getLastPlanet() {
        return planets.isEmpty() ? null : planets.get(planets.size() - 1);
    }

    public boolean isEmpty() {
        return planets.stream().filter(Planet::isVisible).toList().isEmpty();
    }
}
