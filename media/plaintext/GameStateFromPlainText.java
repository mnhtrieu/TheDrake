package kapka.thedrake.media.plaintext;

import java.io.BufferedReader;
import java.io.IOException;

import kapka.thedrake.game.Board;
import kapka.thedrake.game.BothLeadersPlaced;
import kapka.thedrake.game.GameState;
import kapka.thedrake.game.Leaders;
import kapka.thedrake.game.MiddleGameState;
import kapka.thedrake.game.OneLeaderPlaced;
import kapka.thedrake.game.PlacingGuardsGameState;
import kapka.thedrake.game.PlacingLeadersGameState;
import kapka.thedrake.game.PlayingSide;
import kapka.thedrake.game.TheDrakeSetup;
import kapka.thedrake.game.TroopStacks;
import kapka.thedrake.game.VictoryGameState;

public class GameStateFromPlainText {
	private final BufferedReader reader;
	private final TroopStacksFromPlainText stacksFromPlainText;
	private final LeadersFromPlainText leadersFromPlainText;
	private final BoardFromPlainText boardFromPlainText;
	
	public GameStateFromPlainText(TheDrakeSetup setup, BufferedReader reader) {
		this.reader = reader;
		this.stacksFromPlainText = new TroopStacksFromPlainText(setup, reader);
		this.leadersFromPlainText = new LeadersFromPlainText(setup, reader);
		this.boardFromPlainText = new BoardFromPlainText(setup, reader);
	}
	
	public GameState readGameState() throws IOException {
		String type = reader.readLine();
		int guards = Integer.parseInt(reader.readLine());
		PlayingSide sideOnTurn = PlayingSide.valueOf(reader.readLine());		 
		
		TroopStacks stacks = stacksFromPlainText.readTroopStacks();
		Leaders leaders = leadersFromPlainText.readLeaders();
		Board board = boardFromPlainText.readBoard();
		
		if("LEADERS".equals(type)) {
			return new PlacingLeadersGameState(board, stacks, leaders, sideOnTurn);
		} else if("GUARDS".equals(type)) {
			return new PlacingGuardsGameState(board, stacks, (BothLeadersPlaced)leaders, sideOnTurn, guards);
		} else if("MIDDLE".equals(type)) {
			return new MiddleGameState(board, stacks, (BothLeadersPlaced)leaders, sideOnTurn);
		} else if("VICTORY".equals(type)) {
			return new VictoryGameState(board, stacks, (OneLeaderPlaced)leaders, sideOnTurn);
		}
		
		throw new IOException("Invalid file format");
	}
}
