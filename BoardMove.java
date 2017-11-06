package kapka.thedrake;

public class BoardMove extends Move {

	private final BoardChange boardChange;
	
	public BoardMove(MiddleGameState initialState, BoardChange boardChange) {
		super(initialState, boardChange.target());
		this.boardChange = boardChange;
	}
	
	@Override
	public MiddleGameState initialState() {
		return (MiddleGameState)super.initialState();
	}
	
	public GameState resultState() {
		PlayingSide onTurn = initialState().sideOnTurn();
		PlayingSide opponent = onTurn.opposite();
		
		if(isWinning()) {
			OneLeaderPlaced leaders = new OneLeaderPlaced(
					onTurn, initialState().leaders().position(onTurn));
					
			return new VictoryGameState(
					boardChange.resultBoard(), 
					initialState().troopStacks(),
					opponent, 
					leaders);
		}
		
		return new MiddleGameState(
				boardChange.resultBoard(),
				initialState().troopStacks(), 
				initialState().leaders(),
				opponent);
	}
	
	public BoardChange boardChange() {
		return boardChange;
	}
	
	public boolean isWinning() {
		PlayingSide opponent = initialState().sideOnTurn().opposite();
		return initialState().leaders().leaderOn(opponent, target());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((boardChange == null) ? 0 : boardChange.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardMove other = (BoardMove) obj;
		if (boardChange == null) {
			if (other.boardChange != null)
				return false;
		} else if (!boardChange.equals(other.boardChange))
			return false;
		return true;
	}	
}
