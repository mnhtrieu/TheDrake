package kapka.thedrake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlacingGuardsGameState extends BaseGameState {
    private final int guardsCount;

    public PlacingGuardsGameState(
                Board board, 
                TroopStacks troopStacks,
                BothLeadersPlaced leaders, 			
                PlayingSide sideOnTurn, 
                int guardsCount) {
        super(board, troopStacks, leaders, sideOnTurn);
        this.guardsCount = guardsCount;
    }

    public int guardsCount() {
        return guardsCount;
    }

    @Override
    public BothLeadersPlaced leaders() {
        return (BothLeadersPlaced)super.leaders();
    }

    public boolean canPlaceGuard(Troop troop, TilePosition position) {
            if(!board().canPlaceTo(troop, position))
                return false;

            if(troop.side() != sideOnTurn())
                return false;

            boolean hasLeaderAsNeigbour = false;
            hasLeaderAsNeigbour |= tryNeighbour(position, 0, 1);
            hasLeaderAsNeigbour |= tryNeighbour(position, 0, -1);
            hasLeaderAsNeigbour |= tryNeighbour(position, 1, 0);
            hasLeaderAsNeigbour |= tryNeighbour(position, -1, 0);

            return hasLeaderAsNeigbour;
    }

    public GameState placeGuard(TilePosition position) {
            if(guardsCount == 3) {
                return new MiddleGameState(
                    board().withTiles(
                        new TroopTile(
                            position, 
                            troopStacks().peek(sideOnTurn()))
                        ),
                        troopStacks().pop(sideOnTurn()),
                        leaders(),
                        sideOnTurn().opposite());			 				
            }

            return new PlacingGuardsGameState(
                board().withTiles(
                    new TroopTile(
                        position, 
                        troopStacks().peek(sideOnTurn()))
                    ),
                    troopStacks().pop(sideOnTurn()),
                    leaders(),
                    sideOnTurn().opposite(),
                    guardsCount+1);	
    }

    @Override
    public List<Move> allMoves() {
        return stackMoves();
    }

    @Override
    public List<Move> boardMoves(TilePosition position) {
        return Collections.emptyList();
    }

    @Override
    public List<Move> stackMoves() {
        List<Move> result = new ArrayList<>();
        Troop troop = troopStacks().peek(sideOnTurn());
        for(Tile tile : board()) {
            if(canPlaceGuard(troop, tile.position())) {				
                result.add(new PlaceGuard(this, tile.position()));
            }
        }

        return result;
    }

    @Override
    public boolean isVictory() {
        return false;
    }

    private boolean tryNeighbour(TilePosition origin, int xStep, int yStep) {
        return origin.step(xStep, yStep).equals(leaders().position(sideOnTurn()));		
    }
}
