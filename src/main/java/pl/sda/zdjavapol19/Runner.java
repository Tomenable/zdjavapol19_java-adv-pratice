package pl.sda.zdjavapol19;

import pl.sda.zdjavapol19.oop.Line;
import pl.sda.zdjavapol19.oop.Point;
import pl.sda.zdjavapol19.oop.Rectangle;

public class Runner {
    public static void main(String[] args) {
        Point pt1 = new Point();
        Point pt2 = new Point(7, 7);

        System.out.printf("Odleglosc pomiedzy %s a %s wynosi %f\n", pt1, pt2, pt1.distance(pt2));
        System.out.printf("Odleglosc pomiedzy %s a %s wynosi %f\n", pt2, pt1, pt2.distance(pt1));
        System.out.printf("Odleglosc pomiedzy %s a (0, 0) wynosi %f\n", pt2, pt2.distance(0,0));
        System.out.printf("Odleglosc pomiedzy %s a poczatkiem ukladu wspolrzednych wynosi %f\n", pt2, pt2.distance());
        System.out.printf("Odleglosc pomiedzy %s a poczatkiem ukladu wspolrzednych wynosi %f\n", pt1, pt1.distance());

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        Line l1 = new Line(pt1, pt2);
        System.out.println(l1);
        System.out.println("Dlugosc linii l1 = " + l1.getLength());

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        Rectangle r1 = new Rectangle(5, 7, "red");
        System.out.println(r1);
        System.out.println("Powierzchnia r1 = " + r1.calcArea());
    }
}
