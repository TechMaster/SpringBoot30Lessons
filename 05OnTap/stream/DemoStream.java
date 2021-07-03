import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
public class DemoStream {

  public static ArrayList<Person> people = new ArrayList<>(List.of(
    new Person("Vinh", "Vietnam", 28),
    new Person("Lan", "Vietnam", 24),
    new Person("John", "USA", 27),
    new Person("Lee", "China", 67),
    new Person("Kim", "Korea", 22),
    new Person("Long", "Vietnam", 18),
    new Person("Jungho", "Korea", 19),
    new Person("Tian", "China", 20),
    new Person("Clara", "USA", 40),
    new Person("Mikura", "Japan", 27),
    new Person("Sony", "Japan", 29),
    new Person("Xiang", "China", 78),
    new Person("Peter", "France", 18),
    new Person("Haloy", "Malaysia", 20),
    new Person("Magie", "Malaysia", 32)
    ));

  public static void map01() {
    ArrayList<String> manNames = 
    new ArrayList<>(List.of("Thắng", "Dũng", "Trung", "Đức", "Cường"));    
    
    var result = manNames
    .stream()
    .map(element -> element.toUpperCase()) //Ánh xạ từng phần tự sang dạng UpperCase
    .collect(Collectors.toList()); //Gom nhặt phần tử, chuyển sang cấu trúc List

    result.forEach(System.out::println);
  }

  public static void map02() {
    ArrayList<String> manNames = new ArrayList<>(List.of("Thắng", "Dũng", "Trung", "Đức", "Cường"));    
    
    var result = manNames
    .stream()
    .map(String::toUpperCase) //Ánh xạ từng phần tự sang dạng UpperCase
    .collect(Collectors.toList()); //Gom nhặt phần tử, chuyển sang cấu trúc List

    result.forEach(System.out::println);
  }

  public static void map03() {
    ArrayList<String> manNames = new ArrayList<>(List.of("Thắng", "Dũng", "Trung", "Đức", "Cường"));    
    
    manNames
    .stream()
    .map(String::toUpperCase)
    .map(String::toLowerCase)
    .forEach(System.out::println);
  }

  public static void filter01() {
    ArrayList<Integer> manNames = new ArrayList<>(List.of(1, 3, 2, 4, 5, 6, 9, 2));    
    
    ArrayList<Integer> mangSoChan = new ArrayList<>();

    for (Integer e:manNames) {
      if (e % 2 == 0) {
        mangSoChan.add(e);
      }
    }

    var mangSoChan2 = manNames.stream().filter(p -> p % 2 == 0).collect(Collectors.toList());


   /* manNames
    .stream()
    .filter(p -> p % 2 == 0)  //Lọc chỉ lấy số chẵn
    .forEach(System.out::println);*/
  }

  public static void reduce01() {
    ArrayList<Integer> manNames = new ArrayList<>(List.of(1, 3, 2, 4, 5, 6, 9, 2));    
    
    Integer result = manNames
    .stream()
    .reduce(1, (a, b) -> a * b); //gập các phần tử lại để tính tổng

    System.out.println(result);
  }

  public static void summingInt() {
    ArrayList<Integer> manNames = new ArrayList<>(List.of(1, 3, 2, 4, 5, 6, 9, 2));    
    
    Integer result = manNames
    .stream()
    .collect(Collectors.summingInt(Integer::intValue));

    System.out.println(result);
  }

  public static void maxBy() {
    ArrayList<Integer> manNames = new ArrayList<>(List.of(1, 3, 2, 4, 5, 6, 9, 2));    
    
    Optional<Integer> result = manNames
    .stream()
    .collect(Collectors.maxBy(Integer::compareTo));

    System.out.println(result.get());
  }

  public static void minBy() {
    ArrayList<Integer> manNames = new ArrayList<>(List.of(1, 3, 2, 4, 5, 6, 9, 2));    
    
    Optional<Integer> result = manNames
    .stream()
    .collect(Collectors.minBy(Integer::compareTo));

    System.out.println(result.get());
  }

  public static void average() {
    ArrayList<Integer> manNames = new ArrayList<>(List.of(1, 3, 2, 4, 5, 6, 9, 2));    
    
    Double result = manNames
    .stream()
    .collect(Collectors.averagingInt(Integer::intValue));  //Tính trung bình

    System.out.println(result);
  }

  public static void distinct() {
    ArrayList<Integer> manNames = new ArrayList<>(List.of(1, 3, 2, 4, 5, 6, 9, 2));    
    
    manNames
    .stream()
    .distinct()
    .forEach(System.out::println);

  }

  public static void groupBy01() {
    Map<String, Long>result = people
    .stream()
    .collect(Collectors.groupingBy(Person::getNationality, Collectors.counting()));
    System.out.println(result);
  }

  public static void averageAge() {
    Double result = people
    .stream()
    .collect(Collectors.averagingInt(Person::getAge));
    System.out.println(result);
  }

  public static void sortByName() {
    var result = people
    .stream()
    .sorted(Comparator.comparing(Person::getName))
    .collect(Collectors.toList());
    
    result.forEach(System.out::println);
  }

  public static void sortByName02() {
    people
    .stream()
    .sorted(Comparator.comparing(Person::getName).reversed()) //Sắp xếp giảm Z-A
    .forEach(System.out::println);
  }

  public static void filterOutChinese() {
    people
    .stream()
    .filter(p -> !p.getNationality().equals("China"))
    .sorted(Comparator.comparing(Person::getName))
    .forEach(System.out::println);
  }

  //Tăng lương
  public static void peek() {
    /*people
    .stream()
    .peek(Person::increaseAge)
    .collect(Collectors.toList());*/

    people
    .stream()
    .forEach(Person::increaseAge);  //cách này tốt hơn

    people.forEach(System.out::println);
  }


  //Bài tập thực hành

  //Lọc người từ độ tuổi X -> Y

  //Tuổi trung bình

  //Tuổi trung bình theo từng quốc tịch


}
