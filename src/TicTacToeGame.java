import java.util.Scanner;

public class TicTacToeGame {
    private TicTacToeBoard table;
    private UserPlayer playerX;
    private UserPlayer playerO;
    private AiPlayer aiX;
    private AiPlayer aiO;
    private String typeX ;
    private String typeO ;

    // Initialize the board
    public TicTacToeGame(String typeX, String typeO, Scanner scanner){
        this.table = new TicTacToeBoard();

//        if(typeX.equals("user")){
//            this.playerX = new UserPlayer('X', scanner);
//        }
//        else{
//            this.aiX = new EasyAi('X');
//        }
//        if(typeO.equals("easy")){
//            this.aiO = new EasyAi('O');
//        }
//        else{
//            this.playerO = new UserPlayer('O', scanner);
//        }

        if(typeX.equals("user")){
            this.playerX = new UserPlayer('X', scanner);
        }
        else{
            if(typeX.equals("easy"))
            {
                this.aiX = new EasyAi('X');
            }
            else{
                this.aiX = new MediumAi('X');
            }
        }

        if(typeO.equals("easy")){
            this.aiO = new EasyAi('O');
        }
        else if(typeO.equals("medium")){
            this.aiO = new MediumAi('O');
        }
        else{
            this.playerO = new UserPlayer('O', scanner);
        }
    }

    // Play game method
    public void play(){
        table.printTable();
        char current = 'X';

        while(true){

            // If the turn is X
            if(current == 'X'){
                // Check the turn of player and ai
                if(playerX != null){
                    playerX.makeMove(table);
                }
                else{
                    aiX.makeMove(table);
                }
            }

            // If the turn is O
            if(current == 'O'){
                // Check the turn of player and ai
                if(playerO != null){
                    playerO.makeMove(table);
                }
                else{
                    aiO.makeMove(table);
                }
            }

            // Print the board
            table.printTable();

            // Check the winner
            if(table.checkWinner(current)){
                System.out.println("" + current+ " wins");
                break;
            }

            // Check for draw
            if(table.isDraw()){
                System.out.println("Draw");
                break;
            }

            // Switch turns
            current = (current == 'X') ? 'O' : 'X';

        }
    }
}
