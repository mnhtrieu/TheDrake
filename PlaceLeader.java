package kapka.thedrake;

public class PlaceLeader extends Move {

    public PlaceLeader(PlacingLeadersGameState initialState, TilePosition target) {
        super(initialState, target);
    }

    @Override
    public GameState resultState() {
        PlacingLeadersGameState state = (PlacingLeadersGameState) initialState();

        if (state.sideOnTurn() == PlayingSide.BLUE) {
            return state.placeBlueLeader(target());
        }

        return state.placeOrangeLeader(target());
    }

    @Override
    public boolean isWinning() {
        return false;
    }
}
