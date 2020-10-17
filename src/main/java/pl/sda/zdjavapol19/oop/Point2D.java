package pl.sda.zdjavapol19.oop;

import java.util.Objects;

public class Point2D implements Cloneable {
    protected int x, y;   //=0

    public Point2D() {}

    //alt+insert -> generate -> constructor
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //SRP - przekierowuje zadanie do jedynej metody odpowiadajacej za obliczenie
    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double distance() {  //0,0
        return distance(0, 0);
    }

    public double distance(Point2D pt) {
        return distance(pt.x, pt.y);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    public int[] getXY() {
        int tab[] = {x, y};
        return tab;
    }

    //SRP = Single Responsibility Principle - zasada nr 1 z SOLID
    public void setXY(int x, int y) {   //ta metoda jedynie przekierowuje zadnie do metody modyfikujacej
        setX(x);
        setY(y);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getX() {
        return x;
    }
    //tylko ta metoda FIZYCZNIE odpowiada za modyfikacje pola
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return x == point2D.x &&
                y == point2D.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
