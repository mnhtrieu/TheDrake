package kapka.thedrake.media;

import kapka.thedrake.game.BothLeadersPlaced;
import kapka.thedrake.game.NoLeadersPlaced;
import kapka.thedrake.game.OneLeaderPlaced;

public interface LeadersMedia<T> {
	public T putNoLeadersPlaced(NoLeadersPlaced leaders);
	public T putOneLeaderPlaced(OneLeaderPlaced leaders);
	public T putBothLeadersPlaced(BothLeadersPlaced leaders);
}
