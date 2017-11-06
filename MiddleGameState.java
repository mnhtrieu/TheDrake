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
        
        /**
         * Finds all the tiles with the troops of playing side
         * @return List<Tile>
         */
	private List<Tile> hasTroop(){
            List<Tile> tileWithTroop = new ArrayList<Tile>();
            for(Tile tile: super.board()){
                if(     tile.hasTroop() && 
                        tile.troop().side() == super.sideOnTurn())
                    tileWithTroop.add(tile);
                
            }
            return tileWithTroop;
            
        }
	@Override
	public BothLeadersPlaced leaders() {
		return (BothLeadersPlaced)super.leaders();
	}
	
	@Override
	public List<Move> allMoves() {
            // Zde doplňte vlastní implementaci
            List<Move> moves = new ArrayList<Move>();
            List<BoardChange> changes;
            for(Tile tile: hasTroop()){
                changes = tile.troop().changesFrom(tile.position(), super.board());
                for(BoardChange change: changes){
                    moves.add(new BoardMove(this, change));
                }
            }
            moves.addAll(stackMoves());
            
            return moves;
	}	
	
	@Override
	public List<Move> boardMoves(TilePosition position) {		
		// Zde doplňte vlastní implementaci
            
	}
        
	/* Všechny tahy, které může hráč, jenž je zrovna a tahu, provést
        * ze zásobníku.
        */
	@Override
	public List<Move> stackMoves() {
            // Zde doplňte vlastní implementaci
            List<Move> moves = new ArrayList<Move>();
            /*
            for(Tile tile: hasTroop()){
                for(Tile nextTile: super.board()){
                    if(     !nextTile.hasTroop() && 
                            nextTile.position().isNextTo(tile.position()))
                        moves.add(new PlaceFromStack(this, nextTile.position()));
                }
            }
            */
            for(Tile tile: super.board()){
                if(!tile.hasTroop() && canPlaceFromStack(tile.position()))
                    moves.add(new PlaceFromStack(this, tile.position()));
            }
            return moves;
	}
	
	@Override
	public boolean isVictory() {
		return false;
	}
		
	public boolean canPlaceFromStack(TilePosition target) {
            // Zde doplňte vlastní implementaci
            
            for(Tile tileWithTroop: hasTroop()){
                if(target.isNextTo(tileWithTroop.position()))
                    return true;
            }
            
            return false;
            
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

