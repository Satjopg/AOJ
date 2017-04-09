import java.util.Scanner;

public class ITP1_1_D {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int seconds = stdIn.nextInt();
    System.out.println(seconds/60/60 + ":" + seconds/60%60 + ":" + seconds%60);
  }
}
