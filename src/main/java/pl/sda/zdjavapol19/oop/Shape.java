package pl.sda.zdjavapol19.oop;

public abstract class Shape {

    protected String color; //protected zapewnia dostep w klasach podchodnych

    public Shape(String color) {
        this.color = color;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return ", koloru " + color;
    }
}
