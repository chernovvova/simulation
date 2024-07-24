package main.java.ru.simulation.map;

import java.util.HashMap;
import java.util.Map;

import main.java.ru.simulation.Entity;

public class SimulationMap {
    private final int width;
    private final int height;

    private HashMap<Coordinates, Entity> cells;

    public SimulationMap(int width, int height) {
        this.width = width;
        this.height = height;

        cells = new HashMap<>();
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return cells.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return cells.get(coordinates);
    }

    public void putEntity(Coordinates coordinates, Entity entity) {
        cells.put(coordinates, entity);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Coordinates, Entity> getCells() {
        return cells;
    }

    public boolean checkCoordinate(Coordinates coordinates) {
        if(coordinates.getX() >= 0 && coordinates.getX() < width 
            && coordinates.getY() >= 0 && coordinates.getY() < height) {
                return true;
            }
        return false;
    }
}
