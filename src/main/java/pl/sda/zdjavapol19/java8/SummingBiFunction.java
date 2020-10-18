package pl.sda.zdjavapol19.java8;

import java.util.function.BiFunction;

public class SummingBiFunction implements BiFunction<Integer, Integer, Integer> {

    @Override
    public Integer apply(Integer integer, Integer integer2) {
        return integer + integer2;
    }

}
