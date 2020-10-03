package pl.sda.zdjavapol19.oop;

public class Point {
    private int x, y;   //=0

    public Point() {}

    //alt+insert -> generate -> constructor
    public Point(int x, int y) {
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

    public double distance(Point pt) {
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
}
