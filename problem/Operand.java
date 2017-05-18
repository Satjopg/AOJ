import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Operand {

  private static void tenPaz(int[] input_nums) {
    String answer = "";
    List<Integer> rem = new ArrayList<Integer>();
    for(int i = 0;i < input_nums.length;i++) {
      rem = frArrtoList(input_nums, i);
      for(int j = 0;j < rem.size();j++){
        answer = tenPaz(input_nums[i], rmList(rem, j), "+", rem.get(j));
        if(!answer.equals("none")) {
          System.out.println(String.valueOf(input_nums[i]) + "+" + String.valueOf(rem.get(j)) + answer);
          return;
        }
        answer = tenPaz(input_nums[i], rmList(rem, j), "-", rem.get(j));
        if(!answer.equals("none")) {
          System.out.println(String.valueOf(input_nums[i]) + "-" + String.valueOf(rem.get(j)) + answer);
          return;
        }
      }
    }
    if(answer.equals("none")) {
      System.out.println(answer);
    }
  }

  private static String tenPaz(int ans, List<Integer> rem, String formula, int input) {
    if(formula.equals("+")){
      ans += input;
    } else {
      ans -= input;
    }
    if(rem.size() == 0) {
      if(ans == 10) {
        return "";
      } else {
        return "none";
      }
    }
    String answer = "none";
    for(int i = 0;i < rem.size();i++) {
      answer = tenPaz(ans, rmList(rem, i), "+", rem.get(i));
      if(!answer.equals("none")) {
        return "+" + String.valueOf(rem.get(i)) + answer;
      }
      answer = tenPaz(ans, rmList(rem, i), "-", rem.get(i));
      if(!answer.equals("none")) {
        return "-" + String.valueOf(rem.get(i)) + answer;
      }
    }
    return "none";
  }

  private static List<Integer> frArrtoList(int[] input_nums, int index) {
    List<Integer> list = new ArrayList<Integer>();
    for(int i = 0;i < input_nums.length;i++) {
      if(i == index){
        continue;
      }
      list.add(input_nums[i]);
    }
    return list;
  }

  private static List<Integer> rmList(List<Integer> list, int index) {
    List<Integer> rmlist = new ArrayList<Integer>();
    for(int i = 0;i < list.size(); i++) {
      if(i == index) {
        continue;
      }
      rmlist.add(list.get(i));
    }
    return rmlist;
  }

  private static void initArray(int[] input_nums, int input) {
    int tmp = input;
    for(int i = 3;i >= 0;i--) {
      input_nums[i] = tmp % 10;
      tmp /= 10;
    }
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int input = stdIn.nextInt();
    stdIn.close();
    int[] input_nums = new int[4];
    initArray(input_nums, input);
    tenPaz(input_nums);
  }
}
