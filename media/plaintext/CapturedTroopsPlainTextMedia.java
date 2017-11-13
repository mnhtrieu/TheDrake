package kapka.thedrake.media.plaintext;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import kapka.thedrake.game.CapturedTroops;
import kapka.thedrake.game.PlayingSide;
import kapka.thedrake.game.TroopInfo;
import kapka.thedrake.media.CapturedTroopsMedia;
import kapka.thedrake.media.PrintMedia;

public class CapturedTroopsPlainTextMedia extends PrintMedia implements CapturedTroopsMedia<Void> {

    public CapturedTroopsPlainTextMedia(OutputStream stream) {
		super(stream);
    }
    @Override
    public Void putCapturedTroops(CapturedTroops captured) {
        PrintWriter w = writer();
        
                
        if(captured.troops(PlayingSide.BLUE) == null){
            w.printf("Captured %s: %d\n",PlayingSide.BLUE, 0);
        }
        else{
            List<TroopInfo> capturedBlue = captured.troops(PlayingSide.BLUE);
            w.printf("Captured %s: %d\n",PlayingSide.BLUE, capturedBlue.size());
            for (TroopInfo blueTroop: capturedBlue)
                w.printf("%s\n", blueTroop.name());
            
        }
        
        if(captured.troops(PlayingSide.ORANGE) == null)
            w.printf("Captured %s: %d\n",PlayingSide.ORANGE, 0);
        
        else{
            List<TroopInfo> capturedOrange = captured.troops(PlayingSide.ORANGE);
            
            w.printf("Captured %s: %d\n",PlayingSide.ORANGE, capturedOrange.size()); 
            for (TroopInfo orangeTroop: capturedOrange)
                w.printf("%s\n", orangeTroop.name());
                   
        }
        
        
        
        return null;
 
    }

}
