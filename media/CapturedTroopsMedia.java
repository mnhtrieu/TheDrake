package kapka.thedrake.media;

import kapka.thedrake.game.CapturedTroops;

public interface CapturedTroopsMedia<T> {
	public T putCapturedTroops(CapturedTroops captured);
}
