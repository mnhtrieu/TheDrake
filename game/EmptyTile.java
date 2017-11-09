package kapka.thedrake.game;

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

}
