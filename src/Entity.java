public abstract class Entity {
    private int x;
    private int y;
    protected String type;

    public Entity(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() { 
        return type;
    }

    public void setX() {
        this.x = x;
    }

    public void setY() {
        this.y = y;
    }

    public void setType() {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Entity type: %s. Coordinates: (%s, %s)", type, x, y);
    }
}
