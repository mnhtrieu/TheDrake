package kapka.thedrake.game;

public interface Leaders {

    public boolean isPlaced(PlayingSide side);

    public boolean leaderOn(PlayingSide side, TilePosition position);

    public TilePosition position(PlayingSide side);
}
