package pl.sda.zdjavapol19.oop;

public class MovableCircle implements Movable {

    private MovablePoint center;
    private int radius;

    public MovableCircle() {
        this.center = new MovablePoint();   //(0,0,1,1)
        this.radius = 1;
    }

    public MovableCircle(MovablePoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
