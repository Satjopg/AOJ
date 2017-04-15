import java.util.Scanner;

public class ITP1_3_D {

  private static int a, b, c, divisior_count;

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    a = stdIn.nextInt();
    b = stdIn.nextInt();
    c = stdIn.nextInt();
    divisior_count = 0;

    for (int i = a; i <= b ; i++ ) {
      if (c % i == 0) {
        divisior_count++;
      }
    }
    System.out.println(divisior_count);
  }
}
