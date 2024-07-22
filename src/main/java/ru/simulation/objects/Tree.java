package main.java.ru.simulation.objects;

import main.java.ru.simulation.Entity;

public class Tree extends Entity{
    public Tree(final int x, final int y) {
        super(x, y);
        this.setEntityType("tree");
    }
}
