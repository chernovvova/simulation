package main.java.ru.simulation.creatures;

public class Herbivore extends Creature{
    public Herbivore(int x, int y, int health, int speed) {
        super(x, y, health, speed);
        this.setEntityType("Herbivore");
    }

}
