import java.util.Scanner;

public class ITP1_2_D {

  static boolean isInOut_Circle(int[] pos) {
    int[] sq_pos = {pos[0], pos[1]};
    int[] ci_pos = {pos[2], pos[3]};
    int rad = pos[4];

    if (((ci_pos[0] - rad) < 0) || ((ci_pos[0] + rad) > sq_pos[0])) {
      return false;
    } else if (((ci_pos[1] - rad) < 0) || ((ci_pos[1] + rad) > sq_pos[1])) {
      return false;
    } else {
      return true;
    }
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int inNum[] = new int[5];
    for (int i = 0;i < inNum.length ;i++ ) {
      inNum[i] = stdIn.nextInt();
    }

    if (isInOut_Circle(inNum)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
