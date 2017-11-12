package kapka.thedrake.media.plaintext;

import java.io.OutputStream;
import java.io.PrintWriter;
import kapka.thedrake.game.EmptyTile;
import kapka.thedrake.game.Troop;
import kapka.thedrake.game.TroopTile;
import kapka.thedrake.media.PrintMedia;
import kapka.thedrake.media.TileMedia;

public class TilePlainTextMedia extends PrintMedia implements TileMedia<Void>{
    
    public TilePlainTextMedia(OutputStream stream) {
		super(stream);
    }
    
    @Override
    public Void putTroopTile(TroopTile tile) {
        PrintWriter w = writer();
        Troop troop = tile.troop();
        w.printf("%s %s %s\n", troop.info().name(), troop.side(), troop.face());
        
        return null;
    }

    @Override
    public Void putEmptyTile(EmptyTile tile) {
        PrintWriter w = writer();
        
        w.printf("empty\n");
        
        
        return null;
    }

    
}
