package kapka.thedrake;

import java.util.Collections;
import java.util.List;

public class VictoryGameState extends BaseGameState {

    public VictoryGameState(
            Board board,
            TroopStacks troopStacks,
            PlayingSide sideOnTurn,
            OneLeaderPlaced leaders) {
        super(
                board,
                troopStacks,
                leaders,
                sideOnTurn);
    }

    @Override
    public List<Move> allMoves() {
        return Collections.emptyList();
    }

    @Override
    public List<Move> boardMoves(TilePosition position) {
        return Collections.emptyList();
    }

    @Override
    public List<Move> stackMoves() {
        return Collections.emptyList();
    }

    @Override
    public boolean isVictory() {
        return true;
    }
}
