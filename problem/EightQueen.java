public class EightQueen {

	private static boolean[][] board = new boolean[8][8];

	private static void createBoard(boolean[][] board) {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board.length; x++) {
				board[y][x] = false;
			}
		}
	}

	private static int solveEightQueen(boolean[][] board, int queen) {
		if (queen == 8) {
			return queen;
		}
		int return_num = 0;
		for(int y = 0;y < 8; y++) {
			if(isPut(board, queen, y)) {
				board[y][queen] = true;
				return_num = solveEightQueen(board, queen+1);
				if (return_num == 8) {
					return return_num;
				} else {
					board[y][queen] = false;
				}
			}
		}
		return return_num;
	}

	private static boolean isPut(boolean[][] board, int now_x, int now_y) {

		int move_x = 0;
		int move_y = 0;

		// 左斜め上方向チェック
		while (--move_x + now_x >= 0 && --move_y + now_y >= 0) {
			if (board[now_y + move_y][now_x + move_x]) {
				return false;
			}
		}
		move_x = 0;
		move_y = 0;
		// 左方向チェック
		while (--move_x + now_x >= 0) {
			if (board[now_y][now_x + move_x]) {
				return false;
			}
		}
		move_x = 0;
		move_y = 0;
		while (--move_x + now_x >= 0 && ++move_y + now_y < 8) {
			if (board[now_y + move_y][now_x + move_x]) {
				return false;
			}
		}
		return true;
	}

	private static void displayBoard(boolean[][] board) {
		System.out.println("+- - - - - - - - +");
		for(int y = 0;y < board.length;y++){
			System.out.print("|");
			for(int x = 0;x < board.length;x++){
        System.out.print(board[x][y] ? "Q " : ". ");
			}
			System.out.println("|");
		}
		System.out.println("+- - - - - - - - +");
	}

	public static void main(String[] args) {
		createBoard(board);
		solveEightQueen(board, 0);
		displayBoard(board);
	}
}
