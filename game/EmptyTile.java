package kapka.thedrake.game;

import kapka.thedrake.media.TileMedia;

public class EmptyTile extends Tile {

    public EmptyTile(TilePosition position) {
        super(position);
    }

    @Override
    public boolean acceptsTroop(Troop troop) {
        return true;
    }

    @Override
    public boolean hasTroop() {
        return false;
    }

    @Override
    public Troop troop() {
        throw new IllegalArgumentException();
    }

    @Override
    public <T> T putToMedia(TileMedia<T> media) {
        return media.putEmptyTile(this);
    }

}
