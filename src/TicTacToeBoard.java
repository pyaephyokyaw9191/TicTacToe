import java.util.Arrays;

public class TicTacToeBoard {

    // Making char 2D array and filling with empty chars ' '
    private char[][] table = new char[3][3];

    // Constructor to initialize the board
    public TicTacToeBoard(){
        for(char[] chars : table) {
            Arrays.fill(chars, ' ');
        }
    }

    // Method to print the table
    public void printTable() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j]);
                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    // Method to force place move for mediumAi
    public void forcePlaceMove(int row, int col, char symbol) {
        table[row - 1][col - 1] = symbol;
    }

    // Method to check Winner
    public boolean checkWinner(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (table[i][0] != ' ' && table[i][0] == player && table[i][1] == player && table[i][2] == player) {
                return true; // Row win
            }
            if (table[0][i] != ' ' && table[0][i] == player && table[1][i] == player && table[2][i] == player) {
                return true; // Column win
            }
        }
        // Check diagonals
        if (table[0][0] != ' ' && table[0][0] == player && table[1][1] == player && table[2][2] == player) {
            return true; // Main diagonal win
        }
        if(table[0][2] != ' ' && table[0][2] == player && table[1][1] == player && table[2][0] == player) {
            return true; // Anti-diagonal win
        }
        return false;
    }

    // Method to check if the game is a draw
    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == ' ') {
                    return false; // Found an empty cell, game is not a draw
                }
            }
        }
        return true; // No empty cells, it's a draw
    }

    // Is the cell empty?
    public boolean isCellEmpty(int row, int column){
        return table[row-1][column-1] == ' ';
    }

    // Method to make a move
    public void placeMove(int row, int column, char symbol){
        if(isCellEmpty(row, column)){
            table[row-1][column-1] = symbol;
        }
    }

}