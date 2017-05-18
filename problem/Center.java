import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Center {
  //　使える演算子と優先度を予め用意しておく
  private static final Map<String, Integer> opPriority = new HashMap<String, Integer>() {
    {
      put("+", 2);
      put("-", 2);
      put("*", 3);
      put("/", 3);
    }
  };
  // 数字を抜き出すためのパターン
  private static final Pattern digit_pattern = Pattern.compile("^[0-9]+$");

  // 計算をしていくメソッド
  // 式は１つの記号・数字が空白区切りであることが前提
  // 変な式のエラー処理は未実装
  private static int calculate(String formula) {
    // 記号格納
    Stack<String> ops = new Stack<>();
    // 値格納
    Stack<Integer> vals = new Stack<>();
    // 式を分解
    String[] tokens = formula.split(" ");

    for(String token: tokens) {
      // 数値だったらvalsに入れ込む
      if (digit_pattern.matcher(token).find()) {
        vals.push(Integer.parseInt(token));
      // 演算子の時
      } else if(isOperator(token)){
        // opsの演算子がなくなるまでつづける。
        while (ops.size() > 0) {
          // その前に取り込んだ演算子を読み込む
          String last_op = ops.pop();
          // （括弧の可能性があるので）演算子かつ優先度が読み込んだ演算子より高かったら、その演算を行い結果をvalsにpushする
          if (isOperator(last_op) && getOpPriority(token) <= getOpPriority(last_op)) {
            int first = vals.pop();
            int second = vals.pop();
            vals.push(applyOperator(last_op, first, second));
          // 違ったら戻す
          } else {
            ops.push(last_op);
            break;
          }
        }
        // 読み込んだ演算子をopsに入れ込む
        ops.push(token);
      //　括弧の始まりは入れておき次に移る
      } else if(token.equals("(")){
        ops.push(token);
      // 閉じ括弧がきたら、始まりの括弧がくるまで演算し続ける。
      } else if(token.equals(")")) {
        while(ops.size() > 0) {
          String op = ops.pop();
          if (op.equals("(")) {
            break;
          } else {
            int first = vals.pop();
            int second = vals.pop();
            vals.push(applyOperator(op, first, second));
          }
        }
      }
    }
    // 残った値を計算していく(2値取り出して結果を入れ込むを、演算子がなくなるまで繰り返す)
    while(ops.size() > 0) {
      String op = ops.pop();
      if(isOperator(op)) {
        int first = vals.pop();
        int second = vals.pop();
        vals.push(applyOperator(op, first, second));
      }
    }
    // 最後に残った値が答え
    return vals.pop();
  }

  //　演算子による、２値の計算
  private static int applyOperator(String op, int first, int second) {
    switch (op) {
      case "+":
        return first + second;
      case "-":
        return first - second;
      case "*":
        return first * second;
      case "/":
        return first / second;
    }
//  謎の記号ということで、例外処理
    throw new RuntimeException("Unexpected operator: " + op);
  }

// 演算子の優先度を取得
  private static int getOpPriority(String token) {
    return opPriority.getOrDefault(token, 0);
  }

// 演算子かどうかの確認
  private static boolean isOperator(String token) {
    return opPriority.containsKey(token);
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    String formula = stdIn.nextLine();
    stdIn.close();
    System.out.println(calculate(formula));
  }
}
