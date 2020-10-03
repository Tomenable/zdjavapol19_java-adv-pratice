package pl.sda.zdjavapol19.oop;

public class Triangle extends Shape {

    private double a, h;

    public Triangle(double a, double h, String color) {
        super(color);   //wywolanie super ZAWSZE jako pierwsze
        this.a = a;
        this.h = h;
    }

    @Override
    public double calcArea() {
        return 0.5 * a * h;
    }

    @Override
    public String toString() {
        return String.format("Trojkat o podstawie %f i wysokosci %f" + super.toString(), a, h);
    }
}
