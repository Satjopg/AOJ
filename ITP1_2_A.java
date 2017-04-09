import java.util.Scanner;

public class ITP1_2_A {

  static String compare(int a, int b) {
    String operator = "";
    if (a < b) {
      operator = " < ";
    } else if (a > b) {
      operator = " > ";
    } else {
      operator = " == ";
    }
    return operator;
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int a = stdIn.nextInt();
    int b = stdIn.nextInt();
    String operator = compare(a,b);
    System.out.println("a"+operator+"b");
  }
}
