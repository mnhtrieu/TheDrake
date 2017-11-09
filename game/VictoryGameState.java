package kapka.thedrake.game;

import java.util.Collections;
import java.util.List;

import cudlici.thedrake.media.GameStateMedia;

public class VictoryGameState extends BaseGameState {
	
	public VictoryGameState(
			Board board,  
			TroopStacks troopStacks,
			OneLeaderPlaced leaders,
			PlayingSide sideOnTurn) { 
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
	
	@Override
	public <T> T putToMedia(GameStateMedia<T> media) {
		return media.putFinishedGameState(this);
	}
}

