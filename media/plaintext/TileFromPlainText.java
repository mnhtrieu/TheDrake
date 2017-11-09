package kapka.thedrake.media.plaintext;

import java.io.BufferedReader;
import java.io.IOException;

import kapka.thedrake.game.EmptyTile;
import kapka.thedrake.game.PlayingSide;
import kapka.thedrake.game.TheDrakeSetup;
import kapka.thedrake.game.Tile;
import kapka.thedrake.game.TilePosition;
import kapka.thedrake.game.Troop;
import kapka.thedrake.game.TroopFace;
import kapka.thedrake.game.TroopInfo;
import kapka.thedrake.game.TroopTile;

public class TileFromPlainText {
	private final TheDrakeSetup setup;
	private final BufferedReader reader;
	
	public TileFromPlainText(TheDrakeSetup setup, BufferedReader reader) {
		this.setup = setup;
		this.reader = reader;
	}
	
	public Tile readTile(TilePosition position) throws IOException {
		String line = reader.readLine();
		
		if("empty".equals(line)) {
			return new EmptyTile(position);
		}
		
		String[] fields = line.split(" ");
		TroopInfo info = setup.infoByName(fields[0]);
		PlayingSide side = PlayingSide.valueOf(fields[1]); 
		TroopFace face = TroopFace.valueOf(fields[2]);
		Troop troop = new Troop(info, side, face);		
		return new TroopTile(position, troop);
	}
}
