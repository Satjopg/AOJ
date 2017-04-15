import java.util.Scanner;

public class ITP1_4_A {
  private static int a, b;
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    a = stdIn.nextInt();
    b = stdIn.nextInt();

    System.out.printf("%d %d %.5f\n", (a/b), (a%b), ((double)a/b));
  }
}
