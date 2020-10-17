package pl.sda.zdjavapol19.comparing;

import java.util.Arrays;
import java.util.Comparator;

public class StudentCompRunner {

    public static void main(String[] args) {
        Student s1 = new Student("Markowski", 5, 4.25);
        Student s2 = new Student("Gawkowski", 5, 3.9);
        Student s3 = new Student("Piotrkowski", 3, 5.0);
        Student s4 = new Student("Berent", 2, 2.75);
        Student s5 = new Student("Wybiciak", 1, 6.0);

        Student[] students = {s1, s2, s3, s4, s5};
        System.out.println("Nasze studenciaki: ");
        System.out.println(Arrays.toString(students));

        System.out.println("Studenci posortowani po nazwisku: ");
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        System.out.println("Studenci posortowani po ocenach, malejaco: ");
        Arrays.sort(students, new StudentByAvgMarkDescComparator());
        System.out.println(Arrays.toString(students));
    }

    public static class StudentByAvgMarkDescComparator implements Comparator<Student> {
        //malejaco - czyli najwieksze cyfry na poczatek
        //czyli sortowanie ze "najmniejsza cyfra jest najwieksza"
        @Override
        public int compare(Student o1, Student o2) {
            return Double.compare(o2.getAvgMark(), o1.getAvgMark());
        }
    }


}
