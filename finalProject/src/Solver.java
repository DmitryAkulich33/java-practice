class Solver {
    static void solveSudoku(int[][] board) {
        helper(board);
    }

    private static boolean helper(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    continue;
                }

                for (int k = 1; k <= 9; k++) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (helper(board)) {
                            MousePress.mouseMoveAndClick(i, j);
//                            Sudoku.robot.delay(100);
                            KeyBoardPress.pressNumber(k);
                            return true;
                        }
                        board[i][j] = 0;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col, int c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != 0 && board[i][col] == c) {
                return false;
            }

            if (board[row][i] != 0 && board[row][i] == c) {
                return false;
            }

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != 0
                    &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
