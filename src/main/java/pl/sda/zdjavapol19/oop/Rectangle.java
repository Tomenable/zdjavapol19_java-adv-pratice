package pl.sda.zdjavapol19.oop;

public class Rectangle extends Shape {

    private double a, b;

    public Rectangle(double a, double b, String color) {
        super(color);   //wywolanie super ZAWSZE jako pierwsze
        this.a = a;
        this.b = b;
    }

    @Override
    public double calcArea() {
        return a * b;
    }

    @Override
    public String toString() {
        return String.format("Kwadrat o wymiarach %f x %f" + super.toString(), a, b);
    }
}
