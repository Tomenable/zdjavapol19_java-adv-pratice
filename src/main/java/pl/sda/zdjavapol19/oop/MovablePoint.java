package pl.sda.zdjavapol19.oop;

public class MovablePoint implements Movable {

    //package-private - dostepne tylko wew pakietu - na potrzeby testow
    int x, y, xSpeed, ySpeed;

    public MovablePoint() {
        this.x = 0;
        this.y = 0;
        this.xSpeed = 1;
        this.ySpeed = 1;
    }

    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
        this.xSpeed = 1;
        this.ySpeed = 1;
    }

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    @Override
    public void moveUp() {
        this.y += ySpeed;
    }

    @Override
    public void moveDown() {
        this.y -= ySpeed;
    }

    @Override
    public void moveRight() {
        this.x += xSpeed;
    }

    @Override
    public void moveLeft() {
        this.x -= xSpeed;
    }
}
