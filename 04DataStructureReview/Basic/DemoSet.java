import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class DemoSet {
  private DemoSet() {}
  public static void demoSet1() {
    Set<String> uniqueNames = new HashSet<>();

    List<String> manNames = List.of("Thắng", "Dũng", "Trung", "Đức", "Cường", "Thắng", "Đức");
    for (String name : manNames) {
      if (uniqueNames.add(name)) {
        System.out.println("Add `" + name + "` to uniqueNames");
      } else {
        System.out.println("`" + name + "` is already in uniqueNames");
      }
    }
  }

  public static void demoTreeSet() {
    TreeSet<String> manNames = new TreeSet<>();
    manNames.addAll(List.of("John", "Arron", "Peter", "James", "Janes", "Jimy", "Carter", "Cat", "Peron"));
    manNames.forEach(System.out::println);
    NavigableSet<String> manZANames = manNames.descendingSet();
    System.out.println("----");
    manZANames.forEach(System.out::println);
  }

  public static void demoLinkedHashSet() {
    LinkedHashSet<String> manNames = new LinkedHashSet<>();
    manNames.addAll(List.of("John", "Arron", "Peter", "James", "Janes", "Jimy", "Carter", "Cat", "Peron"));
    manNames.forEach(System.out::println);
    System.out.println("----Which one preserve order?");
    HashSet<String> manNames2 = new HashSet<>();
    manNames2.addAll(List.of("John", "Arron", "Peter", "James", "Janes", "Jimy", "Carter", "Cat", "Peron"));
    manNames2.forEach(System.out::println);
   }
}
