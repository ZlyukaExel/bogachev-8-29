package org.example;

public class Main {

    public static void main(String[] args) {
        PrintBoardAndWinner(new int[][]{
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 0},
        });

        PrintBoardAndWinner(new int[][]{
                {0, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 0},
        });

        PrintBoardAndWinner(new int[][]{
                {0, 1, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 0},
        });

        PrintBoardAndWinner(new int[][]{
                {0, 1, 1, 0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 1, 1},
        });

        PrintBoardAndWinner(new int[][]{
                {0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 1},
        });
    }

    public static void PrintBoardAndWinner(int[][] brd) {
        for (int[] ints : brd) {
            for (int j = 0; j < brd[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n" + FindWinner(brd) + "\n\n");
    }

    public static int FindWinner(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean frstWin = false;
        boolean zrWin = false;

        for (int i = 0; i < rows; i++) {
            colLoop:
            for (int j = 0; j < cols; j++) {
                int val = board[i][j];

                if (val == 1 && !frstWin || val == 0 && !zrWin) //if winner already exist, no use in check
                {
                    if (j + 4 < cols) { //checking if there`s enough space
                        if (i + 4 < rows) {
                            for (int k = 1; k < 5; k++) { //checking diagonal
                                if (board[i + k][j + k] != val)
                                    break;
                                if (k == 4) {
                                    if (val == 1)
                                        frstWin = true;
                                    else
                                        zrWin = true;
                                }
                            }
                        }

                        for (int k = j; k < j + 5; k++) { //horizontal check
                            if (board[i][k] != val)
                                continue colLoop;
                        }
                        if (val == 1)
                            frstWin = true;
                        else
                            zrWin = true;

                        continue;
                    }

                    if (i + 4 < rows) { //checking if there`s enough space
                        for (int k = i; k < i + 5; k++) { //vertical check
                            if (board[k][j] != val)
                                continue colLoop;
                        }
                        if (val == 1)
                            frstWin = true;
                        else
                            zrWin = true;
                    }
                }
            }
        }

        if (frstWin) {
            if (zrWin)
                return 0;
            return 1;
        }
        if (zrWin)
            return -1;
        else
            return 0;
    }
}