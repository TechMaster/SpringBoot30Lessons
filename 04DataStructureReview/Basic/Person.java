public class Person {
  @Override
  public String toString() {
    return "Person [name=" + name + ", nationality=" + nationality + "]";
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
  private String name;
  private String nationality;
  public Person(String name, String nationality){
    this.name = name;
    this.nationality = nationality;
  }
}