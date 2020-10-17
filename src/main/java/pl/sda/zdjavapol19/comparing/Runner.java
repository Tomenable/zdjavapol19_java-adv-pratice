package pl.sda.zdjavapol19.comparing;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        String[] companies = {"Tesla", "BMW", "Daimler", "Apple", "Google", "Microsoft", "IBM", "Oracle"};
        Arrays.sort(companies);
        System.out.println("Companies sorted by natural order: " + Arrays.toString(companies));
        int tabLen = companies.length;
        System.out.println("Ostatnia pozycja: " + companies[tabLen - 1]);
        int daimlerLastIndexOf = Arrays.asList(companies).lastIndexOf("Daimler");    //ostatnie (gdyby byly powtorzenia) polozenie 'Daimler' w tablicy
        System.out.println("Daimler - index " + daimlerLastIndexOf);

        //jakim kluczem sa zapisane grupy wiekowe?
        int[] ages = new int[100];
        for(int i = 0; i < 100; i++)
            ages[i] = (int)(Math.random() * 100);

        Arrays.sort(ages);  //ages rosnaco

        Map<AgeGroup, List<Integer>> ageGroupMap = new LinkedHashMap<>();
        for(int age : ages) {
            AgeGroup ag = map(age);
            //dany AgeGroup key istnieje w mapie - dodac kolejne entry do listy
            if(ageGroupMap.containsKey(ag)) {
                List<Integer> agesListforAgeGroup = ageGroupMap.get(ag);
                agesListforAgeGroup.add(age);
                ageGroupMap.put(ag, agesListforAgeGroup);
            //nie istnieje - dodac taki key wraz z pierwszym entry
            } else {
                List<Integer> agesList = new ArrayList<>();
                agesList.add(age);
                ageGroupMap.put(ag, agesList);
            }
        }

        ageGroupMap.forEach((key, value) -> System.out.println(key + ":" + value));

    }

    private static AgeGroup map(int age) {
        if(age < 1)
            return AgeGroup.TODDLERS;
        if(age < 10)
            return AgeGroup.CHILDREN;
        if(age < 18)
            return AgeGroup.TEENAGERS;
        if(age < 60)
            return AgeGroup.ADULTS;
        return AgeGroup.SENIORS;
    }

}
