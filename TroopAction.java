package kapka.thedrake;

import java.util.List;

public interface TroopAction {
  public List<BoardChange> changesFrom(TilePosition origin, PlayingSide side, Board board);
}
