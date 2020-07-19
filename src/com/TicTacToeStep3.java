package com;

import java.util.Scanner;

public class TicTacToeStep3 {

    private char[][] board;
    private int numberX;
    private int numberO;
    private char winner;

    public String play() {
        buildBoard();
        boolean success = analyzeBoard();
        displayBoard();

        int wins = getWins();

        if (!success || Math.abs(numberX - numberO) >= 2 || wins > 1) {
            return "Impossible";
        }

        if (wins == 1) {
            return winner + " wins";
        }

        if (numberX + numberO == 9) {
            return "Draw";
        }

        return "Game not finished";
    }

    private void buildBoard() {
        Scanner scanner = new Scanner(System.in);
        String moves = scanner.nextLine();
        System.out.println("Enter cells: " + moves);
        board = new char[3][3];
        board[0][0] = moves.charAt(0);
        board[0][1] = moves.charAt(1);
        board[0][2] = moves.charAt(2);
        board[1][0] = moves.charAt(3);
        board[1][1] = moves.charAt(4);
        board[1][2] = moves.charAt(5);
        board[2][0] = moves.charAt(6);
        board[2][1] = moves.charAt(7);
        board[2][2] = moves.charAt(8);
    }

    private boolean analyzeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O' && board[i][j] != ' ' && board[i][j] != '_') {
                    return false;
                }

                if (board[i][j] == 'X') {
                    numberX++;
                } else if (board[i][j] == 'O') {
                    numberO++;
                }
            }
        }
        return true;
    }

    private void displayBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    private int getWins() {
        return checkWin(board[0][0], board[1][0], board[2][0])
                + checkWin(board[0][1], board[1][1], board[2][1])
                + checkWin(board[0][2], board[1][2], board[2][2])
                + checkWin(board[0][0], board[0][1], board[0][2])
                + checkWin(board[1][0], board[1][1], board[1][2])
                + checkWin(board[2][0], board[2][1], board[2][2])
                + checkWin(board[0][0], board[1][1], board[2][2])
                + checkWin(board[0][2], board[1][1], board[2][0]);
    }

    private int checkWin(char a, char b, char c) {
        if (a == b && b == c) {
            winner = a;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        TicTacToeStep3 ticTac3 = new TicTacToeStep3();
        System.out.println(ticTac3.play());
    }


// 00 01 02
// 10 11 12
// 20 21 22

}



