package kapka.thedrake;

public class PlaceFromStack extends Move {

    public PlaceFromStack(MiddleGameState initialState, TilePosition target) {
        super(initialState, target);
    }

    @Override
    public MiddleGameState initialState() {
        return (MiddleGameState) super.initialState();
    }

    @Override
    public GameState resultState() {
        return initialState().placeFromStack(target());
    }

    @Override
    public boolean isWinning() {
        return false;
    }
}
