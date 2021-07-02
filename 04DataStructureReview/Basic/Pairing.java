public class Pairing {
  private Pairing(){}

  public static void sapXepCapDau() {
    String a = "Thụy Sĩ,Tây Ban Nha,Bỉ,Italy";
    String[] b = a.split(",");
    for (int i = 0; i < b.length - 1; i++) {
      for (int j = 1; j < b.length; j++) {
        if (!b[i].equals(b[j])) {
          System.out.println("[" + b[i] + "--" + b[j] + "]");
        }
      }
    }
  }
}
