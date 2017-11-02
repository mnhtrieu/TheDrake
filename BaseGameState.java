package kapka.thedrake;

public abstract class BaseGameState implements GameState {
    private final Board board;
    private final TroopStacks troopStacks;
    private final Leaders leaders;
    private final PlayingSide sideOnTurn;

    protected BaseGameState(
                    Board board, 
                    TroopStacks troopStacks,
                    Leaders leaders,
                    PlayingSide sideOnTurn) {

            this.board = board;
            this.troopStacks = troopStacks;
            this.leaders = leaders;
            this.sideOnTurn = sideOnTurn;
    }

    public Board board() {
        return board;
    }

    @Override
    public TroopStacks troopStacks() {
        return troopStacks;
    }

    @Override
    public Leaders leaders() {
        return leaders;
    }

    @Override
    public PlayingSide sideOnTurn() {
        return sideOnTurn;
    }
}
