import java.util.Scanner;

public class ITP1_3_C {

  private static int x;
  private static int y;

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    for (int i = 0; i < 3000 ; i++ ) {
      x = stdIn.nextInt();
      y = stdIn.nextInt();
      if (x == 0 && y == 0) {
        break;
      } else {
        if (x <= y) {
          System.out.println(x + " " + y);
        } else {
          System.out.println(y + " " + x);
        }
      }
    }
  }
}
