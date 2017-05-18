import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Operand {

  // 起点メソッド
  private static void tenPaz(int[] input_nums) {
    String answer = "";
    List<Integer> rem = new ArrayList<Integer>();
    for(int i = 0;i < input_nums.length;i++) {
      // 残り使える数をリストにする。
      rem = frArrtoList(input_nums, i);
      for(int j = 0;j < rem.size();j++){
        // 足す側の起点。
        answer = tenPaz(input_nums[i], rmList(rem, j), "+", rem.get(j));
        // 答えが求まったら出力して終わる。
        if(!answer.equals("none")) {
          System.out.println(String.valueOf(input_nums[i]) + "+" + String.valueOf(rem.get(j)) + answer);
          return;
        }
        // 引く側の起点
        answer = tenPaz(input_nums[i], rmList(rem, j), "-", rem.get(j));
        // 答えが出たら出力して終了
        if(!answer.equals("none")) {
          System.out.println(String.valueOf(input_nums[i]) + "-" + String.valueOf(rem.get(j)) + answer);
          return;
        }
      }
    }
    // なかったらnoneを出力
    if(answer.equals("none")) {
      System.out.println(answer);
    }
  }

  // 再帰メソッド：残り使える数（rem）がなくなるまで再帰し続ける。
  // 深さ優先探索（10になったら打ち切るから必ず全通りやるとは限らない）
  private static String tenPaz(int ans, List<Integer> rem, String formula, int input) {
    // 紛らわしい名前だけど、formulaは演算子（＋ or -）のこと。
    // それに応じた演算を行う。
    if(formula.equals("+")){
      ans += input;
    } else {
      ans -= input;
    }
    // 再帰の終了条件
    // 答えが１０になったら空文字、それ以外はnoneを返す。
    if(rem.size() == 0) {
      if(ans == 10) {
        return "";
      } else {
        return "none";
      }
    }
    String answer = "none";
    // 残り使える数分回す
    // インデックスで回しているのは、rmListで使う数を消した新しいリストを返すため。
    for(int i = 0;i < rem.size();i++) {
      // 残りの使える数を減らして再帰（足す側）
      answer = tenPaz(ans, rmList(rem, i), "+", rem.get(i));
      // noneじゃない（解が求まったら）戻す
      if(!answer.equals("none")) {
        return "+" + String.valueOf(rem.get(i)) + answer;
      }
      // 残りの使える数を減らして再帰（引く側）
      answer = tenPaz(ans, rmList(rem, i), "-", rem.get(i));
      // noneじゃない（解が求まったら）戻す
      if(!answer.equals("none")) {
        return "-" + String.valueOf(rem.get(i)) + answer;
      }
    }
    // このノード以下の全通りを試したが、答えが出なかったのでnoneを返す
    return "none";
  }

  //　intの配列の指定したindexの要素を取り除いたlistを返す。
  // 今回の場合固定長の配列よりか、リストの方が扱いやすいので使用
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
  // listの指定したindexの要素を取り除いた新しいlistを返す。
  // 再帰の状態において、異なったlistを生成しておくと状態管理が非常に楽なので作成
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

  //　4桁の数字を配列に１つずつ格納していく(初期化)
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
