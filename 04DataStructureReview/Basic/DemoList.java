import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class DemoList {
  private DemoList() {}

  public static void demoArray() {
    String[] array = new String[] {"Thắng", "Dũng", "Trung", "Đức", "Cường"};
    System.out.println(array[1]);
    Object[] arrObj = new Object[5];
    arrObj[0] = "Hello";
    arrObj[1] = new Person("John", "France");
  }
  public static void demoArrayList1() {
    ArrayList<String> manNames = new ArrayList<>(List.of("Thắng", "Dũng", "Trung", "Đức", "Cường"));
    //Dùng vòng lặp for duyệt collection
    /*for (String manName : manNames) {
      System.out.println(manName);
    }*/

    for (int i = manNames.size() - 1; i > 0; i--) {
      System.out.println(manNames.get(i));
    }
  }
  public static void demoArrayList2() {
    ArrayList<String> manNames = new ArrayList<>(List.of("Thắng", "Dũng", "Trung", "Đức", "Cường"));
    //dùng stream().forEach(System.out::println);
    //System.out::println gọi là function reference
    //(name -> System.out.println(name) gọi là Lambda function
    manNames.stream().forEach(name -> System.out.println(name));
  }
  public static void demoArrayList3() {
    ArrayList<String> manNames = new ArrayList<>(List.of("Thắng", "Dũng", "Trung", "Đức", "Cường"));
    manNames.stream().forEach(System.out::println);
  }

  public static void demoArrayList4() {
    //ArrayList<String> manNames = new ArrayList<>(List.of("Thắng", "Dũng", "Trung", "Đức", "Cường"));

    List<String> manNames = List.of("Thắng", "Dũng", "Trung", "Đức", "Cường");
    //Bổ xung phần tử 
    manNames.add("Phong");
    manNames.add("Hoà");

    if (manNames.contains("Phong")) {
      System.out.println("manName contains `Phong`");
    }
  }

  public static void demoArrayList5() {
    //
    ArrayList<String> manNames = new ArrayList<>(Arrays.asList("Thắng", "Dũng", "Trung", "Đức", "Cường"));
    manNames.add("Phong");
    manNames.add("Hoà");

    if (manNames.contains("Phong")) {
      System.out.println("manName contains `Phong`");
    }
  }

  public static void demoArrayList6() {
    List<String> manNames = Arrays.asList("Thắng", "Dũng", "Trung", "Đức", "Cường");
    //java.lang.UnsupportedOperationException
    manNames.add("Phong");
    manNames.add("Hoà");

    if (manNames.contains("Phong")) {
      System.out.println("manName contains `Phong`");
    }
  }

  public static void demoArrayList7() {
    String[] names = {"Thắng", "Dũng", "Trung", "Đức", "Cường"};  //Tạo ra một mảng
    List<String> manNames = new ArrayList<>();

    //Bổ xung một Array vào List
    Collections.addAll(manNames, names);
    manNames.stream().forEach(System.out::println);
  }

  public static void demoArrayList8() {
    ArrayList<String> manNames = new ArrayList<>(List.of("Thắng", "Dũng", "Trung", "Đức", "Cường"));

    Iterator<String> iter = manNames.iterator();
    while (iter.hasNext()) {
      var name = iter.next();
      if (name.equals("Đức") || name.equals("Trung") || name.equals("Cường")){
        iter.remove();
      }
    }
    manNames.forEach(System.out::println);
  }

  public static void demoArrayList8A() {
    ArrayList<String> manNames = new ArrayList<>(List.of("Thắng", "Dũng", "Trung", "Đức", "Cường"));

    for (var i = 0; i < manNames.size(); i++) {
      var name = manNames.get(i);
      if (name.equals("Đức") || name.equals("Trung") || name.equals("Cường")) {
        manNames.remove(name);  //Kết quả có thể sai
      }
    }
    manNames.forEach(System.out::println);
   
  }

  public static void demoArrayList9() {
    ArrayList<String> manNames = new ArrayList<>(List.of("Thắng", "Dũng", "Trung", "Đức", "Cường"));
    var namesShouldRemove  = new ArrayList<>(List.of("Cường", "Dũng"));
    Iterator<String> iter = manNames.iterator();
    while (iter.hasNext()) {
      if (namesShouldRemove.contains(iter.next())){
        iter.remove();
      }
    }
    manNames.forEach(System.out::println);
  }

  public static void demoArrayList10() {
    ArrayList<String> manNames = new ArrayList<>(List.of("John", "Arron", "Peter", "James", "Janes", "Jimy", "Carter", "Cat", "Peron"));
    Collections.sort(manNames);
    manNames.forEach(System.out::println);
    System.out.println("----");
    Collections.sort(manNames, Collections.reverseOrder());
    manNames.forEach(System.out::println);
  }

  public static void demoArrayList11() {
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
    /*var result = people.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
    result.stream().forEach(System.out::println);*/
    people.stream().sorted(Comparator.comparing(Person::getNationality)).forEach(System.out::println);
  }


}
