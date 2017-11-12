package kapka.thedrake.media.plaintext;

import java.io.OutputStream;
import java.io.PrintWriter;
import kapka.thedrake.game.MiddleGameState;
import kapka.thedrake.game.PlacingGuardsGameState;
import kapka.thedrake.game.PlacingLeadersGameState;
import kapka.thedrake.game.VictoryGameState;
import kapka.thedrake.media.GameStateMedia;
import kapka.thedrake.media.PrintMedia;


public class GameStatePlainTextMedia extends PrintMedia implements GameStateMedia<Void>{

    public GameStatePlainTextMedia(OutputStream stream){
        super(stream);
    }
    
    @Override
    public Void putPlacingLeadersGameState(PlacingLeadersGameState state) {
        PrintWriter w = writer();
        w.println("LEADERS");
        
        return null;
    }

    @Override
    public Void putPlacingGuardsGameState(PlacingGuardsGameState state) {
        PrintWriter w = writer();
        w.println("GUARDS");
        
        return null;
    }

    @Override
    public Void putMiddleGameState(MiddleGameState state) {
        PrintWriter w = writer();
        w.println("MIDDLE");
        
        return null;
    }

    @Override
    public Void putFinishedGameState(VictoryGameState state) {
        PrintWriter w = writer();
        w.println("VICTORY");
        
        return null;
    }
    
    
}
