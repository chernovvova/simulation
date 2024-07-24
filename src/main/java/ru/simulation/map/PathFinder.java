package main.java.ru.simulation.map;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import main.java.ru.simulation.creatures.Creature;
import main.java.ru.simulation.creatures.Herbivore;
import main.java.ru.simulation.creatures.Predator;
import main.java.ru.simulation.objects.Grass;

public class PathFinder {
    private SimulationMap map;
    private Coordinates closestTargetCoordinates;

    public PathFinder(SimulationMap map) {
        this.map = map;
    }

    public Coordinates[] findPath(Coordinates coordinates, Creature creature) {
        Queue<Coordinates> queue = new ArrayDeque<>();
        Coordinates[] paths = new Coordinates[map.getHeight() * map.getWidth()];
        closestTargetCoordinates =  null;
        
        queue.add(coordinates);
        while(!queue.isEmpty()) {
            Coordinates currentCoordinates = queue.remove();

            if(isTarget(currentCoordinates, creature)) {
                closestTargetCoordinates = currentCoordinates;
                break;
            }

            List<Coordinates> neighbours = getNeighbours(currentCoordinates);

            for (Coordinates neighbour : neighbours) {
                if(isTarget(neighbour, creature)) {
                    int neighbourIndex = getIndex(neighbour);
                    if (paths[neighbourIndex] == null) {
                        queue.add(neighbour);
                        paths[neighbourIndex] = currentCoordinates;
                    }
                }
            }
        }

        return paths;
    }

    public boolean isTarget(Coordinates coordinates, Creature creature) {
        if(creature instanceof Herbivore && map.getEntity(coordinates) instanceof Grass 
            || creature instanceof Predator && map.getEntity(coordinates) instanceof Herbivore) {
                return true;
            }
        return false;
    }

    public List<Coordinates> getNeighbours(Coordinates coordinates) {
        //смещения клеток карты
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        List<Coordinates> neighbours = new ArrayList<>();

        for(int k = 0; k < dx.length; k++) {
            Coordinates neighbour = new Coordinates(coordinates.getX() + dx[k], coordinates.getY() + dy[k]);
            if(map.checkCoordinate(neighbour)) {
                neighbours.add(neighbour);
            }
        }

        return neighbours;
    }

    public int getIndex(Coordinates coordinates) {
        return coordinates.getY() * map.getHeight() + coordinates.getX();
    }

    public Coordinates findNextMove(Coordinates coordinates, Coordinates[] path) {
        Coordinates target = closestTargetCoordinates;

        if(target == null) {
            return coordinates;
        }

        Coordinates prev = null;
        while(target != coordinates) {
            prev = target;
            target = path[getIndex(target)];
        }

        return prev;
    }
}
