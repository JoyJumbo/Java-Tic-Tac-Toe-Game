package com.tictactoe.controller;

import com.tictactoe.model.*;

public class Game {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private boolean gameOver;

    public Game(Player x, Player o) {
        this.board = new Board();
        this.playerX = x;
        this.playerO = o;
        this.currentPlayer = x;
        this.gameOver = false;
    }

    public boolean makeMove(int row, int col) {
        if (gameOver) return false;
        return board.mark(row, col, currentPlayer.getSymbol());
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void resetGame() {
        board.reset();
        currentPlayer = playerX;
        gameOver = false;
    }

    public Board getBoard() {
        return board;
    }

    public void setGameOver(boolean status) {
        this.gameOver = status;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}