import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;
import java.awt.Point;
import java.util.Arrays;

/**
 *
 * @author Satoru
 * @param board
 *            オセロの盤.盤面の状態をもっている. Stringの2次元配列
 * @param turn
 *            どっちのプレイヤーの番かを保持する。
 */
class Othero {

	private String[][] board;
	private String turn;
	private String next;
	private final Point[] search_points = { new Point(-1, -1), new Point(0, -1), new Point(1, -1), new Point(-1, 0),
			new Point(1, 0), new Point(-1, 1), new Point(0, 1), new Point(1, 1) };

	public Othero() {
		createBoard();
		setTurn("o");
		setNext("x");
	}

	private void createBoard() {
		this.board = new String[10][10];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i == 0 || i == 9) {
					if (j == 0 || j == 9) {
						this.board[i][j] = "+";
					} else {
						this.board[i][j] = "-";
					}
				} else {
					if (j == 0 || j == 9) {
						this.board[i][j] = "|";
					} else {
						this.board[i][j] = ".";
					}
				}
			}
		}
		this.board[4][4] = this.board[5][5] = "o";
		this.board[4][5] = this.board[5][4] = "x";
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public void displayBoard() {
		for (String[] wid : this.board) {
			System.out.println(Arrays.toString(wid));
		}
	}

	public void displayTurn() {
		System.out.println(this.turn + "のターンです。");
	}

	// 置けるところがあるか確認する。
	public boolean checkBoard() {
		Point put_point = new Point();
		for (int y = 1; y <= 8; y++) {
			for (int x = 1; x <= 8; x++) {
				// 空き場所に駒を置いた時に、相手の駒が取れるかをチェックする。
				if (this.board[y][x].equals(".")) {
					put_point.setLocation(x, y);
					if (checkPiece(put_point, false)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// 指定した場所においたときに、相手の駒が取れるかを確認する(起点メソッド)
	// updateは駒を返すか、返さないかの判定。
	public boolean checkPiece(Point put_point, boolean update) {
		Stack<Point> update_points = new Stack<Point>();
		update_points.clear();
		for (Point search : this.search_points) {
			if (this.board[put_point.y + search.y][put_point.x + search.x].equals(this.next)) {
				existReturnPiece(put_point, search, update_points);
			}
		}
		if (update_points.empty()) {
			return false;
		}
		if (update) {
			updateBoard(update_points);
			this.board[put_point.y][put_point.x] = this.turn;
		}
		return true;
	}

	// ８方向のチェック関数. 返せる駒は、その位置をスタックに積んでいく.
	private void existReturnPiece(Point put_point, Point move_point, Stack<Point> update_points) {
		Point check_point = new Point(put_point.x + move_point.x, put_point.y + move_point.y);
		Stack<Point> candidate_points = new Stack<Point>();
		candidate_points.clear();
		while (this.board[check_point.y][check_point.x].equals(this.next)) {
			candidate_points.push(new Point(check_point.x, check_point.y));
			check_point.x += move_point.x;
			check_point.y += move_point.y;
			if ((check_point.x >= 1 && check_point.x <= 8) && (check_point.y >= 1 && check_point.y <= 8)) {
				continue;
			} else {
				candidate_points.clear();
				return;
			}
		}
		if (this.board[check_point.y][check_point.x].equals(this.turn)) {
			while (candidate_points.size() > 0) {
				update_points.push(candidate_points.pop());
			}
			return;
		} else {
			candidate_points.clear();
			return;
		}
	}

	// 駒を返す。
	private void updateBoard(Stack<Point> update_points) {
		for (Point return_point : update_points) {
			this.board[return_point.y][return_point.x] = this.turn;
		}
	}

	// ターンを変更する。
	public void changeTurn() {
		if (this.turn.equals("o")) {
			this.turn = "x";
			this.next = "o";
		} else {
			this.turn = "o";
			this.next = "x";
		}
	}

	// 終わったか確認する
	public boolean finishGame() {
		int[] results = calcPieces();
		int result_x = results[0];
		int result_o = results[1];
		if (result_x + result_o == 64 || result_x == 0 || result_o == 0) {
			displayResult(result_x, result_o);
			return true;
		}
		System.out.println("xの枚数: " + result_x);
		System.out.println("oの枚数: " + result_o);
		return false;
	}

	// 各プレイヤーのコマ数を数えるよ
	private int[] calcPieces() {
		int[] results = { 0, 0 };
		for (int y = 1; y <= 8; y++) {
			for (int x = 1; x <= 8; x++) {
				if (this.board[y][x].equals("x")) {
					results[0] += 1;
				} else if (this.board[y][x].equals("o")) {
					results[1] += 1;
				} else {
					continue;
				}
			}
		}
		return results;
	}

	// 結果確認と表示
	private void displayResult(int result_x, int result_o) {
		String winner = "";
		System.out.println("oの数: " + result_o);
		System.out.println("xの数: " + result_x);
		if (result_x == result_o) {
			System.out.println("引き分け！！");
		} else {
			winner = result_x > result_o ? "x" : "o";
			System.out.println(winner + "の勝ち！！");
		}
	}
}

public class Game {

	private static Scanner stdIn = new Scanner(System.in);
	private static String inputx_str = "";
	private static String inputy_str = "";
	private static Pattern num_pattern = Pattern.compile("[1-8]");

	public static void main(String[] args) {
		Point put_point = new Point();
		Othero othero = new Othero();
		othero.displayBoard();
		othero.displayTurn();
		while (true) {
			System.out.print("置く場所を入力(横) > ");
			inputx_str = stdIn.next();
			System.out.print("置く場所を入力(縦) > ");
			inputy_str = stdIn.next();
			if (num_pattern.matcher(inputx_str).find() && num_pattern.matcher(inputy_str).find()) {
				put_point.setLocation(Integer.parseInt(inputx_str), Integer.parseInt(inputy_str));
				if (othero.checkPiece(put_point, false)) {
					othero.checkPiece(put_point, true);
					othero.changeTurn();
				} else {
					System.out.println("そのマスには置けません");
					continue;
				}
			} else {
				System.out.println("無効な入力です。");
				continue;
			}
			if (othero.finishGame()) {
				break;
			} else {
				System.out.println("まだ続く");
				othero.displayBoard();
				othero.displayTurn();
				continue;
			}
		}
	}
}
