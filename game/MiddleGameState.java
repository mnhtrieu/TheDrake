package kapka.thedrake.game;

import java.util.*;

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
        

	private List<Tile> hasTroop(){
            List<Tile> tileWithTroop = new ArrayList<Tile>();
            for(Tile tile: super.board()){
                if(     tile.hasTroop() && 
                        tile.troop().side() == super.sideOnTurn())
                    tileWithTroop.add(tile);
                
            }
            return Collections.unmodifiableList(tileWithTroop);
            
        }
	@Override
	public BothLeadersPlaced leaders() {
		return (BothLeadersPlaced)super.leaders();
	}
	
	@Override
	public List<Move> allMoves() {
        List<Move> moves = new ArrayList<Move>();
        List<BoardChange> changes;
        moves.addAll(stackMoves());
        for(Tile tile: hasTroop()){
            changes = tile.troop().changesFrom(tile.position(), super.board());
            for(BoardChange change: changes){
                //System.out.println("adding " + change.getClass().getName() + " - from " + change.origin() + " to " + change.target());
                moves.add(new BoardMove(this, change));
            }
        }
        return Collections.unmodifiableList(moves);
	}
	/* Všechny tahy, které může hráč, jenž je zrovna na tahu, provést
 	* z políčka na pozici position.
 	*/
	@Override
	public List<Move> boardMoves(TilePosition position) {
	    if(!board().tileAt(position).hasTroop()) return Collections.emptyList();
		Troop troop = board().tileAt(position).troop();
		if(troop.side() != sideOnTurn()) return Collections.emptyList();
		List<Move> res = new ArrayList<>();
		List<BoardChange> changes = troop.changesFrom(position,board());
        for(BoardChange change: changes){
            res.add(new BoardMove(this, change));
        }

        return Collections.unmodifiableList(res);
	}
        
	/* Všechny tahy, které může hráč, jenž je zrovna a tahu, provést
        * ze zásobníku.
        */
	@Override
	public List<Move> stackMoves() {
            // Zde doplňte vlastní implementaci
            List<Move> moves = new ArrayList<Move>();
            for(Tile tile: super.board()){
                if(!tile.hasTroop() && canPlaceFromStack(tile.position()))
                    moves.add(new PlaceFromStack(this, tile.position()));
            }
            return Collections.unmodifiableList(moves);
	}
	
	@Override
	public boolean isVictory() {
		return false;
	}
		
	public boolean canPlaceFromStack(TilePosition target) {
            // Zde doplňte vlastní implementaci

            for(Tile tileWithTroop: hasTroop()){
                if(target.isNextTo(tileWithTroop.position()) && !board().tileAt(target).hasTroop())
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

