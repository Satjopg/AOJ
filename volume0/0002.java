import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
  private static int a, b;
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    List<String> num_st = new ArrayList<String>();
    while (stdIn.hasNextInt()) {
      a = stdIn.nextInt();
      b = stdIn.nextInt();
      num_st.add(String.valueOf(a+b));
    }
    for (String  sum: num_st) {
      System.out.println(sum.length());
    }
  }
}
