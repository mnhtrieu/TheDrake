package kapka.thedrake;

public class BothLeadersPlaced implements Leaders {

    private final TilePosition blueLeaderPosition;
    private final TilePosition orangeLeaderPosition;

    public BothLeadersPlaced(TilePosition blueLeaderPosition,
            TilePosition orangeLeaderPosition) {
        this.blueLeaderPosition = blueLeaderPosition;
        this.orangeLeaderPosition = orangeLeaderPosition;
    }

    @Override
    public boolean isPlaced(PlayingSide side) {
        return true;
    }

    @Override
    public TilePosition position(PlayingSide side) {
        if (side == PlayingSide.BLUE) {
            return blueLeaderPosition;
        }

        return orangeLeaderPosition;
    }

    @Override
    public boolean leaderOn(PlayingSide side, TilePosition position) {
        return position(side).equals(position);
    }
}
