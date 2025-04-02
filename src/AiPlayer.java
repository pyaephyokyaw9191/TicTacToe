abstract class AiPlayer {
    protected char symbol;

    public AiPlayer(char symbol){
        this.symbol = symbol;
    }

    abstract void makeMove(TicTacToeBoard table);

}
