package pl.sda.zdjavapol19.comparing;

public class Student implements Comparable<Student> {

    private String lastName;
    private int year;
    private double avgMark;

    public Student(String lastName, int year, double avgMark) {
        this.lastName = lastName;
        this.year = year;
        this.avgMark = avgMark;
    }

    //po nazwisku alfabetycznie - lexicographical order
    @Override
    public int compareTo(Student o) {
        return this.lastName.compareTo(o.lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public int getYear() {
        return year;
    }

    public double getAvgMark() {
        return avgMark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", year=" + year +
                ", avgMark=" + avgMark +
                '}';
    }
}
