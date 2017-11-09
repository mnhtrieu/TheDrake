package kapka.thedrake.game;

import kapka.thedrake.media.LeadersMedia;

public interface Leaders {

    public boolean isPlaced(PlayingSide side);

    public boolean leaderOn(PlayingSide side, TilePosition position);

    public TilePosition position(PlayingSide side);

    public <T> T putToMedia(LeadersMedia<T> media);
}
