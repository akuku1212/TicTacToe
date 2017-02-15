package MWO;

import JavaStart_kurs_1.Odczyt;
import java.util.Scanner;

public class TicTacToe {

    public static String[][] board;
    public static String playerX;
    public static String playerO;

    public TicTacToe(int a, int b) {
        this.board = new String[a][b];
    }

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println("");
            if (i < 2) {
                System.out.println("-----------");
            }
        }

    }

    public public boolean move(int x, int y) {
        if (board[x][y] == " X " || board[x][y] == " O ") {
            return false;
        }
        return true;
    }

    public static String checkWhoWon() {
        if ((board[0][0] == " X " && board[0][1] == " X " && board[0][2] == " X ")
                || (board[1][0] == " X " && board[1][1] == " X " && board[1][2] == " X ")
                || (board[0][0] == " X " && board[0][1] == " X " && board[0][2] == " X ")
                || (board[1][0] == " X " && board[1][1] == " X " && board[1][2] == " X ")
                || (board[2][0] == " X " && board[2][1] == " X " && board[2][2] == " X ")
                || (board[0][0] == " X " && board[1][0] == " X " && board[2][0] == " X ")
                || (board[0][1] == " X " && board[1][1] == " X " && board[2][1] == " X ")
                || (board[0][2] == " X " && board[1][2] == " X " && board[2][2] == " X ")
                || (board[0][0] == " X " && board[1][1] == " X " && board[2][2] == " X ")
                || (board[2][0] == " X " && board[1][1] == " X " && board[0][2] == " X ")) {
            return playerX;
        } else if ((board[0][0] == " X " && board[0][1] == " X " && board[0][2] == " X ")
                || (board[1][0] == " O " && board[1][1] == " O " && board[1][2] == " O ")
                || (board[0][0] == " O " && board[0][1] == " O " && board[0][2] == " O ")
                || (board[1][0] == " O " && board[1][1] == " O " && board[1][2] == " O ")
                || (board[2][0] == " O " && board[2][1] == " O " && board[2][2] == " O ")
                || (board[0][0] == " O " && board[1][0] == " O " && board[2][0] == " O ")
                || (board[0][1] == " O " && board[1][1] == " O " && board[2][1] == " O ")
                || (board[0][2] == " O " && board[1][2] == " O " && board[2][2] == " O ")
                || (board[0][0] == " O " && board[1][1] == " O " && board[2][2] == " O ")
                || (board[2][0] == " O " && board[1][1] == " O " && board[0][2] == " O ")) {
            return playerO;
        } else {
            return null;
        }
    }

    public static String insert() {
        Scanner odczyt = new Scanner(System.in);
        String wsp = odczyt.nextLine();
        return wsp;
    }

    public static boolean verify(String X) {
        if (X.equals("0,0") || X.equals("0,1") || X.equals("0,2")
                || X.equals("1,0") || X.equals("1,1") || X.equals("1,2")
                || X.equals("2,0") || X.equals("2,1") || X.equals("2,2")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3, 3);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "   ";
            }
        }

        System.out.println("WELCOME TO THE GAME");
        System.out.println("Enter your name player X: ");
        game.playerX = game.insert();
        System.out.println("Enter your name player O: ");
        game.playerO = game.insert();

        while (game.checkWhoWon() == null) {

            game.printBoard();
            System.out.println("your move " + playerX);
            String xy = "no";
            while (xy == "no") {
                String moveX = game.insert();
                if (game.verify(moveX) == true) {
                    int xX = Integer.parseInt(moveX.substring(0, 1));
                    int yY = Integer.parseInt(moveX.substring(2));
                    if (game.move(xX, yY) == true) {
                        board[xX][yY] = " X ";
                        break;
                    } 
                    else {
                        System.out.println("Move is not allowed, repeat your move.");
                    }

                } 
                else {
                    System.out.println("Wrong input.");
                }

            }

            game.printBoard();
            if (game.checkWhoWon() != null) {
                System.out.println("Thank you for the game! \n Palyer " + game.checkWhoWon() + " won!");
                break;
            }
            System.out.println("your move " + playerO);
            String ab = "no";
            while (ab == "no") {
                String moveO = game.insert();
                if (game.verify(moveO) == true) {
                    int xX = Integer.parseInt(moveO.substring(0, 1));
                    int yY = Integer.parseInt(moveO.substring(2));
                    if (game.move(xX, yY) == true) {
                        board[xX][yY] = " O ";
                        break;
                    } else {
                        System.out.println("Move is not allowed, repeat your move.");
                    }
                } 
                else {
                    System.out.println("Wrong input.");
                }
            }
            game.printBoard();
            if (game.checkWhoWon() != null) {
                System.out.println("Thank you for the game! \n Palyer " + game.checkWhoWon() + " won!");
                break;
            }
        }
    }
}

