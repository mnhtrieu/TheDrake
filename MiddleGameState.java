package kapka.thedrake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MiddleGameState extends BaseGameState {

    public MiddleGameState(
            Board board,
            TroopStacks troopStacks,
            BothLeadersPlaced leaders,
            PlayingSide sideOnTurn) {
        super(
                board,
                troopStacks,
                leaders,
                sideOnTurn);
    }

    @Override
    public BothLeadersPlaced leaders() {
        return (BothLeadersPlaced) super.leaders();
    }

    @Override
    public List<Move> allMoves() {
        // Zde doplňte vlastní implementaci
    }

    @Override
    public List<Move> boardMoves(TilePosition position) {
        // Zde doplňte vlastní implementaci
    }

    @Override
    public List<Move> stackMoves() {
        // Zde doplňte vlastní implementaci
    }

    @Override
    public boolean isVictory() {
        return false;
    }

    public boolean canPlaceFromStack(TilePosition target) {
        // Zde doplňte vlastní implementaci
    }

    public MiddleGameState placeFromStack(TilePosition target) {
        Troop troop = troopStacks().peek(sideOnTurn());
        return new MiddleGameState(
                board().withTiles(
                        new TroopTile(target, troop)),
                troopStacks().pop(sideOnTurn()),
                leaders(),
                sideOnTurn().opposite());
    }
}
