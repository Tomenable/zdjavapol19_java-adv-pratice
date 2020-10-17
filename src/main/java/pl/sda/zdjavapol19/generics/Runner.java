package pl.sda.zdjavapol19.generics;

public class Runner {

    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair("Warsaw", 1800000);

        Employee e1 = new Employee("Przemek");
        Pair<Employee, Double> p2 = new Pair(e1, 10000);
    }

}
