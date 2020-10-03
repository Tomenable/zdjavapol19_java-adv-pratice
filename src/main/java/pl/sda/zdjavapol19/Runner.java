package pl.sda.zdjavapol19;

import pl.sda.zdjavapol19.oop.*;

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

        Triangle t1 = new Triangle(15, 3, "yellow");
        System.out.println(t1);
        System.out.println("Powierzchnia t1 = " + t1.calcArea());

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        Account a1 = new Account("1", "pw", 5000);
        Account a2 = new Account("2", "ew", 2500);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println("Credit 500 to a2");
        a2.credit(500);
        System.out.println(a2);
        System.out.println("Debit 4000 from a1");
        a1.debit(4000);
        System.out.println(a1);
        System.out.println("Transfer 2000 from a2 to a1");
        a2.transferTo(a1, 2000);
        System.out.println(a2);
        System.out.println(a1);
    }
}
