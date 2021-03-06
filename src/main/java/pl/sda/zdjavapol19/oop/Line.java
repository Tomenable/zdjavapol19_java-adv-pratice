package pl.sda.zdjavapol19.oop;

public class Line { //extends java.lang.Object - stad metoda toString()

    private Point2D begin, end;

    public Line(int x1, int y1, int x2, int y2) {
        this.begin = new Point2D(x1, y1);
        this.end = new Point2D(x2, y1);
    }

    public Line(Point2D begin, Point2D end) {
        this.begin = begin;
        this.end = end;
    }

    @Override   //przesloniecie; overloading - przeciazanie (vide metoda Point::distance)
    public String toString() {
        return String.format("Odcinek: [początek=%s, koniec=%s]", begin, end);
    }

    public double getLength() {
        return begin.distance(end);
    }

    //analogicznie dla punktu end
    public int getBeginX() {
        return begin.getX();
    }

    public int getBeginY() {
        return begin.getY();
    }

    public int[] getBeginXY() {
        return begin.getXY();
    }

    public void setBeginX(int x) {
        begin.setX(x);
    }

    public void setBeginY(int y) {
        begin.setY(y);
    }

    public void setBeginXY(int x, int y) {
        begin.setXY(x, y);
    }

    public Point2D getBegin() {
        return begin;
    }

    public void setBegin(Point2D begin) {
        this.begin = begin;
    }

    public Point2D getEnd() {
        return end;
    }

    public void setEnd(Point2D end) {
        this.end = end;
    }
}
