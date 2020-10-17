package pl.sda.zdjavapol19.oop;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

/*
    A...B
    D...C
    Jak okreslic, ze punkty tworza prostokat:
    1. Obliczyc odleglosc poszczegolnych odcinkow tworzacych prostokat. Odcinki lezace na przeciwko siebie musza miec taka sama dlugosc.
    AB == DC && AD == BC
    2. Obliczyc odleglosc punktow tworzacych przekatna prostokata np AC
    3. Sprawdzic, czy przekatna razem z bokami AD i DC tworzy trojkat wg wzoru pitagorasa:
        AC^2 = AD^2 + DC^2
 */
public class MovableRectangle implements Movable {

    Point2D[] points = new Point2D[4];
    int rectXSpeed = 1;
    int rectYSpeed = 1;

    //TO-DO: korzystac z 'deep copy' argumentow Point2D - implementacja metody Object#copy
    public MovableRectangle(Point2D a, Point2D b, Point2D c, Point2D d) {
        if(isValid(a, b, c, d)) {
            try {
                points[0] = (Point2D) a.clone();
                points[1] = (Point2D) b.clone();
                points[2] = (Point2D) c.clone();
                points[3] = (Point2D) d.clone();
            }
            catch(CloneNotSupportedException ex) {
                System.out.println(ex);
            }
        }
        else {
            throw new RectangleConstructionException();
        }
    }

    public MovableRectangle(Point2D a, Point2D b, Point2D c, Point2D d, int rectXSpeed, int rectYSpeed) {
        this(a, b, c, d);
        this.rectXSpeed = rectXSpeed;
        this.rectYSpeed = rectYSpeed;
    }

    @Override
    public void moveUp() {
        for(Point2D pt : points)
            pt.y += rectYSpeed;
    }

    @Override
    public void moveDown() {
        for(Point2D pt : points)
            pt.y -= rectYSpeed;
    }

    @Override
    public void moveRight() {
        Arrays.stream(points)
                .forEach(pt -> pt.x += rectXSpeed);
    }

    @Override
    public void moveLeft() {
        Arrays.stream(points)
                .forEach(pt -> pt.x -= rectXSpeed);
    }

    boolean isValid(Point2D a, Point2D b, Point2D c, Point2D d) {
        return areOppositeSidesEqual(a, b, c, d) && fulfillsPitagorasRule(a, b, c, d);
    }

    private boolean fulfillsPitagorasRule(Point2D a, Point2D b, Point2D c, Point2D d) {
        double diagonal = a.distance(c);
        double ad_len = a.distance(d);
        double dc_len = d.distance(c);

        return eq(Math.pow(diagonal, 2), Math.pow(ad_len, 2) + Math.pow(dc_len, 2));
    }

    private boolean areOppositeSidesEqual(Point2D a, Point2D b, Point2D c, Point2D d) {
        Line ab = new Line(a, b);
        Line dc = new Line(d, c);
        Line ad = new Line(a, d);
        Line bc = new Line(b, c);

        return areLinesLengthEqual(ab, dc) && areLinesLengthEqual(ad, bc);
    }

    private boolean areLinesLengthEqual(Line l1, Line l2) {
        return eq(l1.getLength(), l2.getLength());
    }

    //klasa wewnetrzna
    public class RectangleConstructionException extends RuntimeException {
        public RectangleConstructionException() {
            super("Cannot construct rectangle out of given points");
        }
    }

    private boolean eq(double a, double b){
        return Math.abs(a-b)<0.00005;
    }

}
