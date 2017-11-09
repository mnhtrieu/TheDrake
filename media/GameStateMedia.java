
package kapka.thedrake.media;

import kapka.thedrake.game.MiddleGameState;
import kapka.thedrake.game.PlacingGuardsGameState;
import kapka.thedrake.game.PlacingLeadersGameState;
import kapka.thedrake.game.VictoryGameState;

public interface GameStateMedia<T> {
	public T putPlacingLeadersGameState(PlacingLeadersGameState state);
	public T putPlacingGuardsGameState(PlacingGuardsGameState state);
	public T putMiddleGameState(MiddleGameState state);
	public T putFinishedGameState(VictoryGameState state);
}

