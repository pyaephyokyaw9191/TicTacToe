import java.util.Random;

public class MediumAi extends AiPlayer{
    private Random random = new Random();

    public MediumAi(char symbol){
        super(symbol);
    }

    // Method for Scanning a Move
    public int[] scanForMove(TicTacToeBoard table){
        int tempRow;
        int tempColumn;
        char opponent;

        for(int i = 0; i< 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(table.isCellEmpty(i+1, j+1)){
                    tempRow = i+1;
                    tempColumn = j+1;
                    table.forcePlaceMove(tempRow, tempColumn, this.symbol);
                    if(table.checkWinner(this.symbol)){
                        table.forcePlaceMove(tempRow, tempColumn, ' '); // 💥 make sure it's here too
                        return new int[] {tempRow, tempColumn};
                    }
                    // Reset the cell
                    table.forcePlaceMove(tempRow, tempColumn, ' ');
                }
            }
        }

        // Change symbol
        opponent = (symbol == 'X') ? 'O' : 'X';

        for(int i = 0; i< 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table.isCellEmpty(i + 1, j + 1)) {
                    tempRow = i + 1;
                    tempColumn = j + 1;

                    // Checking for opponent winning move
                    table.forcePlaceMove(tempRow, tempColumn, opponent);
                    if(table.checkWinner(opponent)){
                        table.forcePlaceMove(tempRow, tempColumn, ' '); // 💥 this line can create bug if not placed
                        return new int[] {tempRow, tempColumn};
                    }
                    table.forcePlaceMove(tempRow, tempColumn, ' ');
                }
            }
        }
        return null;
    }

    public void makeMove(TicTacToeBoard table){
        System.out.println("Making move level \"medium\"");

        // checking the empty cell in board and simulate or place
        int[] move = scanForMove(table);
        // If the move is not null, we put the coordinates in the board
        if(move != null){
            table.placeMove(move[0], move[1], this.symbol);
        }
        else{
            // Make random Move
            int randomRow = random.nextInt(3 ) + 1;
            int randomColumn = random.nextInt(3 ) + 1;

            while(true){
                if(table.isCellEmpty(randomRow, randomColumn)){
                    table.placeMove(randomRow, randomColumn, symbol);
                    break;
                }
                else{
                    randomRow = random.nextInt(3 ) + 1;
                    randomColumn = random.nextInt(3 ) + 1;
                }
            }
        }

    }
}