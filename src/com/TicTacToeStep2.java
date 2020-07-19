package com;

import java.util.Scanner;

public class TicTacToeStep2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String move = scanner.nextLine();
        String ligne1 = move.substring(0,3);
        String ligne2 = move.substring(3,6);
        String ligne3 = move.substring(6,9);


        System.out.println("Enter cells: "+ move);
        System.out.println("---------");
        System.out.print("| ");
        System.out.print(ligne1.charAt(0) + " " + ligne1.charAt(1) + " " + ligne1.charAt(2));
        System.out.println(" |");
        System.out.print("| ");
        System.out.print(ligne2.charAt(0) + " " + ligne2.charAt(1) + " " + ligne2.charAt(2));
        System.out.println(" |");
        System.out.print("| ");
        System.out.print(ligne3.charAt(0) + " " + ligne3.charAt(1) + " " + ligne3.charAt(2));
        System.out.println(" |");
        System.out.println("---------");
    }
}
