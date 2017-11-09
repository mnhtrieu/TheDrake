package kapka.thedrake.media.plaintext;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kapka.thedrake.game.CapturedTroops;
import kapka.thedrake.game.PlayingSide;
import kapka.thedrake.game.TheDrakeSetup;
import kapka.thedrake.game.TroopInfo;

public class CapturedTroopsFromPlainText {
	private final TheDrakeSetup setup;
	private final BufferedReader reader;
	
	public CapturedTroopsFromPlainText(TheDrakeSetup setup, BufferedReader reader) {
		this.setup = setup;
		this.reader = reader;
	}
	
	public CapturedTroops readTroops() throws IOException {
		return new CapturedTroops(readList(PlayingSide.BLUE), readList(PlayingSide.ORANGE));
	}
	
	private List<TroopInfo> readList(PlayingSide side) throws IOException {
		String line = reader.readLine();
		if(!line.startsWith("Captured " + side.toString() + ":"))
			throw new IOException("Invalid file format");
		
		String[] fields = line.split(":");
		
		int count = Integer.parseInt(fields[1].trim());
		List<TroopInfo> captured = new ArrayList<>();
		for(int i = 0; i < count; i++) {
			line = reader.readLine();
			captured.add(setup.infoByName(line));
		}
		
		return captured;
	}
}
