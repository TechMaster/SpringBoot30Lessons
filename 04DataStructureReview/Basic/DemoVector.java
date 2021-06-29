import java.util.List;
import java.util.Vector;

public class DemoVector {
  private DemoVector() {
  }

  public static void demoVector1() {
    Vector<String> manNames = new Vector<>(List.of("Thắng", "Dũng", "Trung", "Đức", "Cường"));
    manNames.forEach(System.out::println);
  }
}