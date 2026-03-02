package com.tictactoe.view;

import com.tictactoe.controller.Game;
import com.tictactoe.model.Player;

import javax.swing.*;
import java.awt.*;

public class TicTacToe {
    private JFrame frame;
    private JButton[][] buttons;
    private JLabel statusLabel;
    private Game game;

    public TicTacToe() {
        Player p1 = new Player("Player X", 'X');
        Player p2 = new Player("Player O", 'O');
        game = new Game(p1, p2);

        frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(600, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        statusLabel = new JLabel(p1.getName() + "'s Turn (" + p1.getSymbol() + ")", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Times New Roman", Font.ITALIC, 50));
        statusLabel.setOpaque(true);
        statusLabel.setBackground(Color.DARK_GRAY);
        statusLabel.setForeground(Color.WHITE);
        frame.add(statusLabel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        Font buttonFont = new Font("Times New Roman", Font.ITALIC, 120);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton btn = new JButton("");
                btn.setFont(buttonFont);
                btn.setBackground(Color.DARK_GRAY);
                btn.setForeground(Color.WHITE);
                btn.setFocusable(false);
                final int row = r, col = c;
                btn.addActionListener(e -> handleMove(row, col));
                buttons[r][c] = btn;
                boardPanel.add(btn);
            }
        }

        frame.add(boardPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void handleMove(int row, int col) {
        if (game.isGameOver()) return;

        if (game.makeMove(row, col)) {
            char symbol = game.getCurrentPlayer().getSymbol();
            buttons[row][col].setText(String.valueOf(symbol));

            if (game.getBoard().checkWin(symbol)) {
                statusLabel.setText(game.getCurrentPlayer().getName() + " wins!");
                game.setGameOver(true);
            } else if (game.getBoard().isFull()) {
                statusLabel.setText("It's a tie!");
                game.setGameOver(true);
            } else {
                game.switchPlayer();
                Player current = game.getCurrentPlayer();
                statusLabel.setText(current.getName() + "'s Turn (" + current.getSymbol() + ")");
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}