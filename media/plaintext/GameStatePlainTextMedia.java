package kapka.thedrake.media.plaintext;

import java.io.OutputStream;
import java.io.PrintWriter;

import kapka.thedrake.game.*;
import kapka.thedrake.media.GameStateMedia;
import kapka.thedrake.media.PrintMedia;


public class GameStatePlainTextMedia extends PrintMedia implements GameStateMedia<Void>{
    
    private final TroopStacksPlainTextMedia troopStackMedia;
    private final LeadersPlainTextMedia leaderMedia;
    private final BoardPlainTextMedia boardMedia;
    
    
    public GameStatePlainTextMedia(OutputStream stream){
        super(stream);
        this.troopStackMedia = new TroopStacksPlainTextMedia(stream);
        this.leaderMedia = new LeadersPlainTextMedia(stream);
        this.boardMedia = new BoardPlainTextMedia(stream);
        
        
    }
    
    @Override
    public Void putPlacingLeadersGameState(PlacingLeadersGameState state) {
        PrintWriter w = writer();
        w.println("LEADERS");
        w.println("0");
        w.println(state.sideOnTurn());
        state.troopStacks().putToMedia(troopStackMedia);
        state.leaders().putToMedia(leaderMedia);
        state.board().putToMedia(boardMedia);
        //TODO
        return null;
    }

    @Override
    public Void putPlacingGuardsGameState(PlacingGuardsGameState state) {
        PrintWriter w = writer();
        w.println("GUARDS");
        w.println(state.guardsCount());
        w.println(state.sideOnTurn());
        state.troopStacks().putToMedia(troopStackMedia);
        state.leaders().putToMedia(leaderMedia);
        state.board().putToMedia(boardMedia);
        //TODO
        return null;
    }

    @Override
    public Void putMiddleGameState(MiddleGameState state) {
        PrintWriter w = writer();
        w.println("MIDDLE");
        w.println("4");
        w.println(state.sideOnTurn());
        state.troopStacks().putToMedia(troopStackMedia);
        state.leaders().putToMedia(leaderMedia);
        state.board().putToMedia(boardMedia);
        //TODO
        
        return null;
    }

    @Override
    public Void putFinishedGameState(VictoryGameState state) {
        PrintWriter w = writer();
        w.println("VICTORY");
        w.println("4");
        w.println(state.sideOnTurn());
        state.troopStacks().putToMedia(troopStackMedia);
        state.leaders().putToMedia(leaderMedia);
        state.board().putToMedia(boardMedia);
        //TODO
        
        return null;
    }
    
    
}
