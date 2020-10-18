package pl.sda.zdjavapol19.java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Java8DemoRunner {

    public static void main(String[] args) {
        //R apply(T t, U u);
        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        sum.apply(15, 10);

        //klasyczna implementacja w zew klasie
        SummingBiFunction sbf = new SummingBiFunction();
        sbf.apply(15, 10);

        //lamba wewnatrz stream
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(15);

        nums.stream()
                //.reduce(Integer::sum)
                .reduce((x, y) -> x + y);

        LocalDate ld1 = LocalDate.of(1992, 5, 2);
        LocalDate ld2 = LocalDate.of(1993, 10, 3);
        LocalDate ld3 = LocalDate.of(2018, 11, 7);
        List<LocalDate> lds = List.of(ld3, ld2, ld1);
        lds.stream()
                .sorted()
                .forEach(System.out::println);

    }

}
