import java.util.Scanner;
import java.util.Arrays;

class Q061 {

  private static int num = 0;
  private static int digit = 0;

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    String num_str = stdIn.next();
    stdIn.close();
    digit = num_str.length();
    num = Integer.parseInt(num_str);

    int[] nums = new int[digit];
    int tmp = num;
    for(int i = digit-1;i >= 0;i--) {
      nums[i] = tmp % 10;
      tmp = tmp / 10;
    }

    int index = 0;
    int cp_idx = 0;
    System.out.println();
    for(int i = 0;i < digit;i++) {
      int[] copy = new int[digit - (i+1)];
      index = 0;
      cp_idx = 0;
      for(int j = 0;j < nums.length;j++){
        if(j == 0){ for(int k = 0;k < i;k++) { System.out.print(" "); } }
        System.out.print(nums[index]);
        if(index == nums.length - 1){ continue; }
        System.out.print(" ");
        copy[cp_idx++] = (nums[index] + nums[index+1]) % 10;
      }
      nums = Arrays.copyOf(copy, copy.length);
      System.out.println();
    }
  }
}
