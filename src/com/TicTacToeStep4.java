package com;
import java.util.Scanner;

public class TicTacToeStep4 {

    private char[][] board;
    private int x;
    private int y;
    private char userX;
    private char userY;

    private String coordinate;


    public void play() {
        buildBoard();
        displayBoard();
        userInput();
        displayBoard();
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


    private void userInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        coordinate = scanner.nextLine();
        userX = coordinate.charAt(0);
        userY = coordinate.charAt(2);

        if (numberOrNot()) {
            checkCoordinate();
        } else {
            System.out.println("You should enter numbers!");
            userInput();
        }
    }

    private boolean numberOrNot() {
        return Character.isDigit(coordinate.charAt(0)) && Character.isDigit(coordinate.charAt(2));
    }

    private void checkCoordinate() {
        int nbX = Character.getNumericValue(userX);
        int nbY = Character.getNumericValue(userY);
        if (nbX > 3 || nbY > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            userInput();
        } else {
            x = Math.abs(nbY - 3);
            y = nbX - 1;
            checkFree();
        }
    }

    private void checkFree() {
        if (board[x][y] == ' ' || board[x][y] == '_' ) {
            board[x][y] = 'X';
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            userInput();
        }
    }

    public static void main(String[] args) {
        TicTacToeStep4 ticTac4 = new TicTacToeStep4();
        ticTac4.play();
    }


// 00 01 02
// 10 11 12
// 20 21 22

}
