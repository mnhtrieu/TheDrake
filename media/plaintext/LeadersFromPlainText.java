package kapka.thedrake.media.plaintext;

import java.io.BufferedReader;
import java.io.IOException;

import kapka.thedrake.game.BothLeadersPlaced;
import kapka.thedrake.game.Leaders;
import kapka.thedrake.game.NoLeadersPlaced;
import kapka.thedrake.game.OneLeaderPlaced;
import kapka.thedrake.game.PlayingSide;
import kapka.thedrake.game.TheDrakeSetup;
import kapka.thedrake.game.TilePosition;

public class LeadersFromPlainText {
	private final BufferedReader reader;
	
	public LeadersFromPlainText(TheDrakeSetup setup, BufferedReader reader) {
		this.reader = reader;
	}
	
	public Leaders readLeaders() throws IOException {
		String line = reader.readLine();
		String[] parts = line.split(" ");
		
		if("NL".equals(parts[0]))
			return new NoLeadersPlaced();
		
		if("OL".equals(parts[0])) {
			if("X".equals(parts[1])) {
				return new OneLeaderPlaced(PlayingSide.ORANGE, new TilePosition(parts[2]));
			}
			
			return new OneLeaderPlaced(PlayingSide.BLUE, new TilePosition(parts[1]));
		}
		
		return new BothLeadersPlaced(
				new TilePosition(parts[1]), 
				new TilePosition(parts[2]));
	}
}

