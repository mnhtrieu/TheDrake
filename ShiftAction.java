package kapka.thedrake;

import java.util.Collections;
import java.util.List;

public class ShiftAction implements TroopAction {
	private final Offset2D direction;
	private final Offset2D position;
  
	public ShiftAction(int stepX, int stepY) {
    this(new Offset2D(stepX, stepY), new Offset2D(stepX, stepY));
  }
	
  public ShiftAction(Offset2D direction, Offset2D position) {
    this.direction = direction;
    this.position = position;
  }
  
  @Override
  public List<BoardChange> changesFrom(TilePosition origin, PlayingSide side, Board board) {
  	TilePosition target = origin.stepByPlayingSide(position, side);
  	TilePosition pos = origin.stepByPlayingSide(direction, side);
  	
  	// Check whether the path to the target is free
  	while(!target.equals(pos)) {
    	if(!board.canStepOnly(origin, pos))
    		return Collections.emptyList();
    	pos.stepByPlayingSide(direction, side);
    }

  	// if can step on the target tile 
  	if(board.canStepOnly(origin, pos))
  		return Collections.singletonList(new StepOnly(board, origin, pos));
  	
  	// if can capture on the target tile 
  	if(board.canStepAndCapture(origin, pos))
  		return Collections.singletonList(new StepAndCapture(board, origin, pos));
  	
  	return Collections.emptyList();
  }
}