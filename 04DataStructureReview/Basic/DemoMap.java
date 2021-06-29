import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoMap {
  public static void demoMap1() {
    HashMap<String, List<String>> continents = new HashMap<>();
    continents.put("Asia", List.of("Việt nam", "China", "Singapore", "Indonesia", "Malaysia", "Japan", "South Korea"));
    continents.put("Europe", List.of("United Kingdom", "France", "Germany", "Italy", "Spain"));
    continents.put("Africa", List.of("Kenya", "Angola", "Tanzania", "Maroc", "Zimbabue"));

    continents.get("Asia").forEach(System.out::println);
  }

  public static void demoMap2() {
    HashMap<String, Integer> countPeopleByCoutry = new HashMap<>();
    List<Person> people = List.of(
      new Person("Tom", "USA"),
      new Person("Ziang", "China"),
      new Person("Lee", "China"),
      new Person("Xiang Cai", "China"),
      new Person("Harry", "UK"),
      new Person("Toàn", "Vietnam"),
      new Person("Long", "Vietnam"),
      new Person("Kim", "Korea")
    );

    people.stream().forEach(person -> {
      Integer count = countPeopleByCoutry.get(person.getNationality());
      if (count == null) {
         countPeopleByCoutry.put(person.getNationality(), 1);
      } else {
        countPeopleByCoutry.put(person.getNationality(), count + 1);
      } 
    });

    for (Map.Entry<String,Integer> entry : countPeopleByCoutry.entrySet()) {
      System.out.println(entry.getKey() + " : "+ entry.getValue());
    }
  }


}


