package main.java.ru.simulation.creatures;

public class Predator extends Creature {
    private int damage;

    public Predator(int x, int y, int health, int speed, int damage) {
        super(x, y, health, speed);
        this.damage = damage;
    }
}
