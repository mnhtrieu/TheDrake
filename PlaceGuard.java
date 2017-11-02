package kapka.thedrake;

public class PlaceGuard extends Move {

    public PlaceGuard(PlacingGuardsGameState initialState, TilePosition target) {
        super(initialState, target);
    }

    @Override
    public PlacingGuardsGameState initialState() {
        return (PlacingGuardsGameState) super.initialState();
    }

    @Override
    public GameState resultState() {
        return initialState().placeGuard(target());
    }

    @Override
    public boolean isWinning() {
        return false;
    }
}
