package com.tictactoe.model;

public class Board {
    private char[][] grid;

    public Board() {
        grid = new char[3][3];
        reset();
    }

    public boolean mark(int row, int col, char player) {
        if (grid[row][col] == ' ') {
            grid[row][col] = player;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (grid[r][c] == ' ')
                    return false;
        return true;
    }

    public boolean checkWin(char player) {
        for (int r = 0; r < 3; r++)
            if (grid[r][0] == player && grid[r][1] == player && grid[r][2] == player)
                return true;

        for (int c = 0; c < 3; c++)
            if (grid[0][c] == player && grid[1][c] == player && grid[2][c] == player)
                return true;

        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player)
            return true;

        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player)
            return true;

        return false;
    }

    public void reset() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                grid[r][c] = ' ';
    }
}