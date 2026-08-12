public class Sudoku_solver {

    public static void main(String[] args) {
        int[][] board = {
                { 8, 0, 1, 0, 0, 0, 0, 0, 4 },
                { 4, 5, 0, 3, 0, 2, 6, 0, 7 },
                { 3, 0, 0, 0, 0, 0, 5, 9, 1 },
                { 0, 3, 0, 0, 0, 0, 0, 0, 8 },
                { 6, 1, 2, 9, 8, 0, 0, 0, 0 },
                { 0, 0, 5, 1, 6, 0, 0, 2, 3 },
                { 0, 4, 0, 5, 0, 0, 8, 7, 0 },
                { 0, 6, 0, 2, 4, 0, 0, 5, 0 },
                { 0, 9, 0, 8, 0, 0, 0, 1, 2 }
        };
        System.out.println("Original Sudoku:");

        printBoard(board);

        if (solve(board)) {
            System.out.println("\nSolved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    public static boolean solve(int[][] board) {
        // find an empty cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    // checking number form 1 to 9
                    for (int num = 1; num <= 9; num++) {
                        // check number is valid of not
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursion
                            if (solve(board)) {
                                return true;
                            }

                            // backtrack
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;  // no empty cell means sudoku is solved 
    }

    public static boolean isValid(int[][] board, int row, int col, int num) {
        // check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        // for column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // check 3 by 3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");

                if (col == 2 || col == 5) {
                    System.out.print("| ");
                }
            }
            System.out.println();

            if (row == 2 || row == 5) {
                System.out.println("---------------------");
            }
        }
    }
}