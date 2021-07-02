import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class DemoStream {
  public static void map01() {
    ArrayList<String> manNames = new ArrayList<>(List.of("Thắng", "Dũng", "Trung", "Đức", "Cường"));    
    
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
    .forEach(System.out::println);
  }

  public static void filter01() {
    ArrayList<Integer> manNames = new ArrayList<>(List.of(1, 3, 2, 4, 5, 6, 9, 2));    
    
    manNames
    .stream()
    .filter(p -> p % 2 == 0)  //Lọc chỉ lấy số chẵn
    .forEach(System.out::println);
  }

  public static void reduce01() {
    ArrayList<Integer> manNames = new ArrayList<>(List.of(1, 3, 2, 4, 5, 6, 9, 2));    
    
    Integer result = manNames
    .stream()
    .reduce(0, (a, b) -> a + b); //gập các phần tử lại để tính tổng

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


}
