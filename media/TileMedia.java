package kapka.thedrake.media;

import kapka.thedrake.game.EmptyTile;
import kapka.thedrake.game.TroopTile;

public interface TileMedia<T> {
	public T putTroopTile(TroopTile tile);	
	public T putEmptyTile(EmptyTile tile);
}
