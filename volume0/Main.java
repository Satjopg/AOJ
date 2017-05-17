import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {

  private static double a, b, c, d, e, f;

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    List<double> results = new ArrayList<double>();
    double[] result = new double[2];

    while (stdIn.hasNextDouble()) {
      a = stdIn.nextDouble();
      b = stdIn.nextDouble();
      c = stdIn.nextDouble();
      d = stdIn.nextDouble();
      e = stdIn.nextDouble();
      f = stdIn.nextDouble();
    }
  }
}
