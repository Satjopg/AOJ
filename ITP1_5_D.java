import java.util.Scanner;

public class ITP1_5_D {
  private static int input_num, x;
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    input_num = stdIn.nextInt();
    for (int i = 1;i <= input_num; i++) {
      x = i;
      if (x % 3 == 0) {
        System.out.print(" "+ x);
        continue;
      }
      while (x > 0) {
        if (x % 10 == 3) {
          System.out.print(" "+ i);
          break;
        }
        x /= 10;
      }
    }
    System.out.println("");
  }
}
