package kapka.thedrake.media;

import kapka.thedrake.game.Board;

public interface BoardMedia<T> {
	public T putBoard(Board board);
}
