package main.java.ru.simulation.map;

import java.util.HashMap;

import main.java.ru.simulation.Entity;

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public HashMap<Coordinates, Entity> getCells() {
        return cells;
    }

    public void setCells(HashMap<Coordinates, Entity> cells) {
        this.cells = cells;
    }

    public boolean checkCoordinate(Coordinates coordinates) {
        if(coordinates.getX() >= 0 && coordinates.getX() < width 
            && coordinates.getY() >= 0 && coordinates.getY() < height) {
                return true;
            }
        return false;
    }
}
