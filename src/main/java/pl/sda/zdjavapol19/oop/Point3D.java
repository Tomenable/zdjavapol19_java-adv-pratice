package pl.sda.zdjavapol19.oop;

import pl.sda.zdjavapol19.exceptions.MethodDisabledException;

public class Point3D extends Point2D {

    private int z;

    //(0, 0, 0)
    public Point3D() {
        super();
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(Point2D pt2d, int z) {
        super(pt2d.x, pt2d.y);
        this.z = z;
    }

    //on plane - 2D calculations
    public double distanceOnPlane() {
        return super.distance();
    }

    public double distanceOnPlane(int x, int y) {
        return super.distance(x, y);
    }

    public double distanceOnPlane(Point2D pt2d) {
        return super.distance(pt2d);
    }

    //3D calculations
    public double distance(int x, int y, int z) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2) + Math.pow(this.z - z, 2));
    }

    @Override
    public double distance() {
        return distance(0, 0, 0);
    }

    public double distance(Point3D pt3d) {
        return distance(pt3d.x, pt3d.y, pt3d.z);
    }

    //obsluzenie pozostalych metod 'distance' odziedziczonych z Point2D
    /*@Override
    public double distance(int x, int y) {
        throw new MethodDisabledException("Please call distanceOnPlane(int, int).");
    }

    @Override
    public double distance(Point2D pt2d) {
        throw new MethodDisabledException("Please call distanceOnPlane(Point).");
    }*/

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", x, y, z);
    }

    public void setXYZ(int x, int y, int z) {
        super.setXY(x, y);  //odwolanie do metody klasy rodzica
        setZ(z);
    }

    public int[] getXYZ() {
        int[] tab = {x, y, z};
        return tab;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
