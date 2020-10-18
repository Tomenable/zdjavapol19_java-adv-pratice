package pl.sda.zdjavapol19.java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsersStreamsOperations {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User u1 = new User("Jan", "Kowalski",
                LocalDate.of(1985, 2, 20),
                3500.0,
                CivicState.FREE,
                1);
        User u2 = new User("Julia", "Konradcka",
                LocalDate.of(1987, 3, 20),
                10000.0,
                CivicState.OCCUPIED,
                2);
        User u3 = new User("Konrad", "Karwowski",
                LocalDate.of(1992, 10, 22),
                2500.0,
                CivicState.FREE,
                0);
        User u4 = new User("Norbert", "Urbanski",
                LocalDate.of(1972, 5, 6),
                7500.0,
                CivicState.OCCUPIED,
                3);
        User u5 = new User("Ula", "Gwozdz",
                LocalDate.of(1967, 12, 5),
                6500.0,
                CivicState.OCCUPIED,
                4);
        User u6 = new User("Janek", "Poranek",
                LocalDate.of(1998, 2, 5),
                8500.0,
                CivicState.FREE,
                0);
        User u7 = new User("Karol", "Bobko",
                LocalDate.of(1928, 1, 25),
                2500.0,
                CivicState.OCCUPIED,
                5);
        User u8 = new User("Marek", "Starek",
                LocalDate.of(1978, 2, 5),
                18500.0,
                CivicState.OCCUPIED,
                10);
        User u9 = new User("Marek", "Warek",
                LocalDate.of(2010, 6, 7),
                0.0,
                CivicState.FREE,
                0);
        User u10 = new User("Zbyszek", "Kiszek",
                LocalDate.of(1948, 12, 23),
                500.0,
                CivicState.FREE,
                2);

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        users.add(u6);
        users.add(u7);
        users.add(u8);
        users.add(u9);
        users.add(u10);

        //START HERE!
        //wypisac osoby zarabiające powyżej 5000 PLN -> sout

        //zwrocic liczba osób w związku, -> count

        //wypisac osoby z dziećmi w stanie wolnym,
        System.out.println("Oto osoby z dziećmi, ale w stanie wolnym: ");
        users.stream()
                .filter(u -> u.getCs().equals(CivicState.FREE))
                .filter(u -> u.getChildren() > 0)
                .forEach(System.out::println);

        //zwrocic liczbę dzieci osób w wieku powyżej 30 lat,

        //wypisac dane osoby mającej największą pensję, -> posortowac i wybrac max element

        //wypisac posortowaną listę osób wg wieku rosnąco. -> Comparable<User> lub Comparator
    }

}
