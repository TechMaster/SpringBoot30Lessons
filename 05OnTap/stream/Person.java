public class Person {

  @Override
  public String toString() {
    return "[name=" + name + ", nationality=" + nationality +  ", age=" + age + "]";
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public Person(String name, String nationality, int age) {
    this.name = name;
    this.nationality = nationality;
    this.age = age;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getNationality() {
    return nationality;
  }
  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public void increaseAge() {
    this.age = this.age + 1;
  }
  private String name;
  private String nationality;
  private int age;
}
