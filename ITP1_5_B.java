import java.util.Scanner;

public class ITP1_5_B {
  private static int height, width;
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    while (true) {
      height = stdIn.nextInt();
      width = stdIn.nextInt();
      if (height == 0 && width == 0) {
        break;
      }
      for (int i = 0;i < height; i++) {
        for (int j =0;j < width; j++) {
          if (i == 0 || i == height - 1) {
            System.out.print("#");
          } else {
            if (j == 0 || j == width - 1) {
              System.out.print("#");
            } else {
              System.out.print(".");
            }
          }
        }
        System.out.println("");
      }
      System.out.println("");
    }
  }
}
