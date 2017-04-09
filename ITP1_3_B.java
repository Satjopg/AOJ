import java.util.Scanner;

public class ITP1_3_B {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int in_num = 1;
    int scan_num = 0;

    while(true) {
      scan_num = stdIn.nextInt();
      if (scan_num == 0) {
        break;
      }
      System.out.println("Case "+ in_num + ": " + scan_num);
      in_num++;
    }
  }
}
