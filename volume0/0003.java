import java.util.Scanner;

public class Main {

  private static int loop_num;

  static String rightTriangle(int a, int b, int c){
    String judge = "NO";
    if ((a*a)+(b*b) == (c*c) || (c*c) + (a*a) == (b*b) || (c*c) + (b*b) == (a*a)) {
      judge = "YES";
    }
    return judge;
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    loop_num = stdIn.nextInt();
    String[] result_triangle = new String[loop_num];

    for (int i = 0;i < loop_num; i++) {
      result_triangle[i] = rightTriangle(stdIn.nextInt(), stdIn.nextInt(), stdIn.nextInt());
    }

    for (String result: result_triangle) {
      System.out.println(result);
    }

  }
}
