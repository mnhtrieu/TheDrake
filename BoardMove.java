package kapka.thedrake;

public class BoardMove extends Move {

    private final BoardChange boardChange;

    public BoardMove(MiddleGameState initialState, BoardChange boardChange) {
        super(initialState, boardChange.target());
        this.boardChange = boardChange;
    }

    @Override
    public MiddleGameState initialState() {
        return (MiddleGameState) super.initialState();
    }

    public GameState resultState() {
        PlayingSide onTurn = initialState().sideOnTurn();
        PlayingSide opponent = onTurn.opposite();

        if (isWinning()) {
            OneLeaderPlaced leaders = new OneLeaderPlaced(
                    onTurn, initialState().leaders().position(onTurn));

            return new VictoryGameState(
                    boardChange.resultBoard(),
                    initialState().troopStacks(),
                    opponent,
                    leaders);
        }

        return new MiddleGameState(
                boardChange.resultBoard(),
                initialState().troopStacks(),
                initialState().leaders(),
                opponent);
    }

    public BoardChange boardChange() {
        return boardChange;
    }

    public boolean isWinning() {
        PlayingSide opponent = initialState().sideOnTurn().opposite();
        return initialState().leaders().leaderOn(opponent, target());
    }
}
