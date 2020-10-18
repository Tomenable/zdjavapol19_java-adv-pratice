package pl.sda.zdjavapol19.java8;

import java.time.LocalDate;

public class User {

    private String name;
    private String lastName;
    private LocalDate brithday;
    private double salary;
    private CivicState cs;
    private int children;

    public User(String name, String lastName, LocalDate brithday, double salary, CivicState cs, int children) {
        this.name = name;
        this.lastName = lastName;
        this.brithday = brithday;
        this.salary = salary;
        this.cs = cs;
        this.children = children;
    }

    @Override
    public String toString() {
        return name + " " + lastName + ": {" +
                "brithday=" + brithday +
                ", salary=" + salary +
                ", cs=" + cs +
                ", children=" + children +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBrithday() {
        return brithday;
    }

    public double getSalary() {
        return salary;
    }

    public CivicState getCs() {
        return cs;
    }

    public int getChildren() {
        return children;
    }
}
