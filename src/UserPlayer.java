import java.util.Scanner;

public class UserPlayer {
    private char symbol;
    private Scanner scanner;

    public UserPlayer(char symbol, Scanner scanner){
        this.symbol = symbol;
        this.scanner = scanner;
    }

    public void makeMove(TicTacToeBoard table){
//        Accepts the board (TicTacToeBoard).
//        Keeps prompting until a valid move is entered.
//        Validates that the input is 2 numbers between 1 and 3.
//        Checks if the cell is empty.
//        Places the move.
        boolean gameRunning = true;
        while(gameRunning){
            System.out.print("Enter the coordinates: ");
            String userPrompt = scanner.nextLine();
            String[] rowColumn = userPrompt.split(" ");

            if (rowColumn.length == 2 && rowColumn[0].matches("\\d+") && rowColumn[1].matches("\\d+")) {
                int row = Integer.parseInt(rowColumn[0]);
                int column = Integer.parseInt(rowColumn[1]);

                if (row >= 1 && row <= 3 && column >= 1 && column <= 3) {
                    if (!table.isCellEmpty( row,  column)) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        table.placeMove(row, column, symbol);
                        gameRunning = false;
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
    }
}
