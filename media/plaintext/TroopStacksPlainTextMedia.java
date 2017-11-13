package kapka.thedrake.media.plaintext;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import kapka.thedrake.game.BasicTroopStacks;
import kapka.thedrake.game.PlayingSide;
import kapka.thedrake.game.TroopInfo;

import kapka.thedrake.media.PrintMedia;
import kapka.thedrake.media.TroopStacksMedia;

public class TroopStacksPlainTextMedia extends PrintMedia implements TroopStacksMedia<Void>{
    
    public TroopStacksPlainTextMedia(OutputStream stream){
        super(stream);
    }

    @Override
    public Void putBasicTroopStacks(BasicTroopStacks stacks) {
        PrintWriter w = writer();
        List<TroopInfo> blueStack = stacks.troops(PlayingSide.BLUE);
        List<TroopInfo> orangeStack = stacks.troops(PlayingSide.ORANGE);
        
        w.print("BLUE stack:");
        for(TroopInfo blueTroop: blueStack){
            w.printf(" %s",blueTroop.name());
        }
        w.println();
        
        w.print("ORANGE stack:");
        for(TroopInfo orangeTroop: orangeStack){
            w.printf(" %s", orangeTroop.name());
        }
        w.println();
        
        
        return null;
    }
    
}