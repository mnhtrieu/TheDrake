package kapka.thedrake;

public class NoLeadersPlaced implements Leaders {
	
	@Override
	public boolean isPlaced(PlayingSide side) {
		return false;
	}
	
	@Override
	public TilePosition position(PlayingSide side) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean leaderOn(PlayingSide side, TilePosition position) {
		return false;
	}
}
