package dec;

public class SolveSudoku {

	static int[][] block;
	static int[][] row;
	static int[][] col;

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		solve(board);
		System.out.println("");
	}

	private static void solve(char[][] board) {
		block = new int[9][9];
		row = new int[9][9];
		col = new int[9][9];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int val = Character.getNumericValue(board[i][j]);
				if (val != -1) {
					row[i][val - 1]++;
					col[j][val - 1]++;
					if (i < 3) {
						if (j < 3) {
							block[0][val - 1]++;
						} else if (j >= 3 && j < 6) {
							block[1][val - 1]++;
						} else if (j >= 6 && j < 9) {
							block[2][val - 1]++;
						}
					} else if (i >= 3 && i < 6) {
						if (j < 3) {
							block[3][val - 1]++;
						} else if (j >= 3 && j < 6) {
							block[4][val - 1]++;
						} else if (j >= 6 && j < 9) {
							block[5][val - 1]++;
						}
					} else if (i >= 6 && i < 9) {
						if (j < 3) {
							block[6][val - 1]++;
						} else if (j >= 3 && j < 6) {
							block[7][val - 1]++;
						} else if (j >= 6 && j < 9) {
							block[8][val - 1]++;
						}
					}
				}

			}
		}

		recurse(board, 0, 0);

	}

	private static void recurse(char[][] board, int rowtemp, int coltemp) {
		if (rowtemp == board.length - 1 && coltemp == board[0].length - 1) {
			return;
		}
		if (board[rowtemp][coltemp] != '.') {
			if (coltemp + 1 < board[0].length) {
				recurse(board, rowtemp, coltemp + 1);
			} else if (rowtemp + 1 < board.length) {
				recurse(board, rowtemp + 1, 0);
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (row[rowtemp][i - 1] == 0 && col[coltemp][i - 1] == 0) {
				if (rowtemp >= 0 && rowtemp < 3 && coltemp >= 0 && coltemp < 3) {
					if (block[0][i - 1] == 0) {
						board[rowtemp][coltemp] = (char) (i + 48);
						block[0][i - 1]++;
						row[rowtemp][i - 1]++;
						col[coltemp][i - 1]++;
						if (coltemp + 1 < board[0].length) {
							recurse(board, rowtemp, coltemp + 1);
						} else if (rowtemp + 1 < board.length) {
							recurse(board, rowtemp + 1, 0);
						}
					}
				} else if (rowtemp >= 0 && rowtemp < 3 && coltemp >= 3 && coltemp < 6) {
					if (block[1][i - 1] == 0) {
						board[rowtemp][coltemp] = (char) (i + 48);
						block[1][i - 1]++;
						row[rowtemp][i - 1]++;
						col[coltemp][i - 1]++;
						if (coltemp + 1 < board[0].length) {
							recurse(board, rowtemp, coltemp + 1);
						} else if (rowtemp + 1 < board.length) {
							recurse(board, rowtemp + 1, 0);
						}
					}
				} else if (rowtemp >= 0 && rowtemp < 3 && coltemp >= 6 && coltemp < 9) {
					if (block[2][i - 1] == 0) {
						board[rowtemp][coltemp] = (char) (i + 48);
						block[2][i - 1]++;
						row[rowtemp][i - 1]++;
						col[coltemp][i - 1]++;
						if (coltemp + 1 < board[0].length) {
							recurse(board, rowtemp, coltemp + 1);
						} else if (rowtemp + 1 < board.length) {
							recurse(board, rowtemp + 1, 0);
						}
					}
				} else if (rowtemp >= 3 && rowtemp < 6 && coltemp >= 0 && coltemp < 3) {
					if (block[3][i - 1] == 0) {
						board[rowtemp][coltemp] = (char) (i + 48);
						block[3][i - 1]++;
						row[rowtemp][i - 1]++;
						col[coltemp][i - 1]++;
						if (coltemp + 1 < board[0].length) {
							recurse(board, rowtemp, coltemp + 1);
						} else if (rowtemp + 1 < board.length) {
							recurse(board, rowtemp + 1, 0);
						}
					}
				} else if (rowtemp >= 3 && rowtemp < 6 && coltemp >= 3 && coltemp < 6) {
					if (block[4][i - 1] == 0) {
						board[rowtemp][coltemp] = (char) (i + 48);
						block[4][i - 1]++;
						row[rowtemp][i - 1]++;
						col[coltemp][i - 1]++;
						if (coltemp + 1 < board[0].length) {
							recurse(board, rowtemp, coltemp + 1);
						} else if (rowtemp + 1 < board.length) {
							recurse(board, rowtemp + 1, 0);
						}
					}
				} else if (rowtemp >= 3 && rowtemp < 6 && coltemp >= 6 && coltemp < 9) {
					if (block[5][i - 1] == 0) {
						board[rowtemp][coltemp] = (char) (i + 48);
						block[5][i - 1]++;
						row[rowtemp][i - 1]++;
						col[coltemp][i - 1]++;
						if (coltemp + 1 < board[0].length) {
							recurse(board, rowtemp, coltemp + 1);
						} else if (rowtemp + 1 < board.length) {
							recurse(board, rowtemp + 1, 0);
						}
					}
				} else if (rowtemp >= 6 && rowtemp < 9 && coltemp >= 0 && coltemp < 3) {
					if (block[6][i - 1] == 0) {
						board[rowtemp][coltemp] = (char) (i + 48);
						block[6][i - 1]++;
						row[rowtemp][i - 1]++;
						col[coltemp][i - 1]++;
						if (coltemp + 1 < board[0].length) {
							recurse(board, rowtemp, coltemp + 1);
						} else if (rowtemp + 1 < board.length) {
							recurse(board, rowtemp + 1, 0);
						}
					}
				} else if (rowtemp >= 6 && rowtemp < 9 && coltemp >= 3 && coltemp < 6) {
					if (block[7][i - 1] == 0) {
						board[rowtemp][coltemp] = (char) (i + 48);
						block[7][i - 1]++;
						row[rowtemp][i - 1]++;
						col[coltemp][i - 1]++;
						if (coltemp + 1 < board[0].length) {
							recurse(board, rowtemp, coltemp + 1);
						} else if (rowtemp + 1 < board.length) {
							recurse(board, rowtemp + 1, 0);
						}
					}
				} else if (rowtemp >= 6 && rowtemp < 9 && coltemp >= 6 && coltemp < 9) {
					if (block[8][i - 1] == 0) {
						board[rowtemp][coltemp] = (char) (i + 48);
						block[8][i - 1]++;
						row[rowtemp][i - 1]++;
						col[coltemp][i - 1]++;
						if (coltemp + 1 < board[0].length) {
							recurse(board, rowtemp, coltemp + 1);
						} else if (rowtemp + 1 < board.length) {
							recurse(board, rowtemp + 1, 0);
						}
					}
				}
			}
		}
	}

}
