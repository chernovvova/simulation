package main.java.ru.simulation.objects;

import main.java.ru.simulation.Entity;

public class Rock extends Entity{
    public Rock(final int x, final int y) {
        super(x, y);
        this.setEntityType("rock");
    }
}
