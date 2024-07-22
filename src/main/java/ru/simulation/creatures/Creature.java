package main.java.ru.simulation.creatures;

import main.java.ru.simulation.Entity;

public abstract class Creature extends Entity {
    private int health;
    private int speed;

    public Creature(int x, int y, int health, int speed) {
        super(x, y);
        this.health = health;
        this.speed = speed;
    }

    public abstract void makeMove();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
