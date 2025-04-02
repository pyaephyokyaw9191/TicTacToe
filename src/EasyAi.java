import java.util.Random;

public class EasyAi extends AiPlayer{
    private Random random = new Random();

    // Constructor
    public EasyAi(char symbol) {
        super(symbol);
    }

    @Override
    public void makeMove(TicTacToeBoard table) {
        int randomRow = random.nextInt(3 ) + 1;
        int randomColumn = random.nextInt(3 ) + 1;
        System.out.println("Making move level \"easy\"");

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
