# Sudoku Solver in Java

A simple Sudoku Solver built using **Java** and the **Backtracking Algorithm**.

## Features

- Solves a standard 9×9 Sudoku puzzle
- Uses recursion and backtracking
- Checks rows, columns, and 3×3 boxes
- Displays the original Sudoku
- Displays the solved Sudoku
- Beginner-friendly Java implementation

## How It Works

The program uses the **Backtracking Algorithm** to solve the Sudoku.

### Steps

1. Find an empty cell (`0`).
2. Try numbers from `1` to `9`.
3. Check whether the number is valid.
4. If valid, place the number.
5. Recursively solve the remaining cells.
6. If the solution fails, remove the number.
7. Try the next number.
8. Continue until the Sudoku is solved.

## Algorithm

The main solving method is `solve()`:

```java
if (isValid(board, row, col, num)) {
    board[row][col] = num;

    if (solve(board)) {
        return true;
    }

    board[row][col] = 0;
}
````

The following line performs **backtracking**:

```java
board[row][col] = 0;
```

## Validation

The `isValid()` method checks three conditions:

* The number does not already exist in the row.
* The number does not already exist in the column.
* The number does not already exist in the 3×3 box.

## Requirements

* Java JDK 8 or higher

Check your Java version:

```bash
java -version
```

## How to Run

### Compile

```bash
javac Sudoku_solver.java
```

### Run

```bash
java Sudoku_solver
```

## Sample Sudoku

```text
Original Sudoku:
8 0 1 | 0 0 0 | 0 0 4 
4 5 0 | 3 0 2 | 6 0 7 
3 0 0 | 0 0 0 | 5 9 1 
---------------------
0 3 0 | 0 0 0 | 0 0 8 
6 1 2 | 9 8 0 | 0 0 0 
0 0 5 | 1 6 0 | 0 2 3 
---------------------
0 4 0 | 5 0 0 | 8 7 0 
0 6 0 | 2 4 0 | 0 5 0 
0 9 0 | 8 0 0 | 0 1 2 
```

`0` represents an empty cell.

## Sample Output

```text
Solved Sudoku:
8 7 1 | 6 5 9 | 2 3 4 
4 5 9 | 3 1 2 | 6 8 7 
3 2 6 | 4 7 8 | 5 9 1 
---------------------
9 3 4 | 7 2 5 | 1 6 8 
6 1 2 | 9 8 3 | 7 4 5 
7 8 5 | 1 6 4 | 9 2 3 
---------------------
2 4 3 | 5 9 1 | 8 7 6 
1 6 8 | 2 4 7 | 3 5 9 
5 9 7 | 8 3 6 | 4 1 2 
```

## Time Complexity

The worst-case time complexity is approximately:

```text
O(9^N)
```

where `N` is the number of empty cells.

## Space Complexity

The recursive call stack uses approximately:

```text
O(N)
```

space.

## Technologies Used

* Java
* Recursion
* Backtracking
* 2D Arrays

## Author

*Rishav Raj*