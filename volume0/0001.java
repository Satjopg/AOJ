import java.util.Scanner;

public class Main {
  private static int input_num , temp;
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int[] best3_height = {0, 0, 0};
    while (stdIn.hasNextInt()) {
      input_num = stdIn.nextInt();
      if (best3_height[0] < input_num) {
        temp = best3_height[0];
        best3_height[0] = input_num;
        best3_height[2] = best3_height[1];
        best3_height[1] = temp;
        temp = 0;
      } else if (best3_height[1] < input_num) {
        temp = best3_height[1];
        best3_height[1] = input_num;
        best3_height[2] = temp;
        temp = 0;
      } else if (best3_height[2] < input_num) {
        best3_height[2] = input_num;
      } else {
        continue;
      }
    }
    for (int height : best3_height) {
      System.out.println(height);
    }
  }
}
