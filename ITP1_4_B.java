import java.util.Scanner;

public class ITP1_4_B {
  private static double r;
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    r = stdIn.nextDouble();
    double Pi = Math.PI;
    System.out.printf("%.6f %.6f\n", (r * r * Pi), (2 * Pi * r));
  }
}
