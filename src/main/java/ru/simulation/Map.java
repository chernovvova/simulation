package main.java.ru.simulation;

import java.util.HashMap;

public class Map {
    private final int width;
    private final int height;

    private HashMap<Coordinates, Entity> cells;

    public Map(int width, int height) {
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

}
