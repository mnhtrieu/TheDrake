package kapka.thedrake.media.plaintext;

import java.io.OutputStream;
import java.io.PrintWriter;
import kapka.thedrake.game.BothLeadersPlaced;
import kapka.thedrake.game.NoLeadersPlaced;
import kapka.thedrake.game.OneLeaderPlaced;
import kapka.thedrake.game.PlayingSide;
import kapka.thedrake.media.LeadersMedia;
import kapka.thedrake.media.PrintMedia;

public class LeadersPlainTextMedia extends PrintMedia implements LeadersMedia<Void>{
    
    public LeadersPlainTextMedia(OutputStream stream){
        super(stream);
    }
    
    @Override
    public Void putNoLeadersPlaced(NoLeadersPlaced leaders) {
        PrintWriter w = writer();
        w.println("NL");
        
        return null;
    }

    @Override
    public Void putOneLeaderPlaced(OneLeaderPlaced leaders) {
        PrintWriter w = writer();
        w.print("OL ");
        if(leaders.isPlaced(PlayingSide.BLUE))
            w.printf("%s", leaders.position(PlayingSide.BLUE).toString());
        else
            w.printf("%s", leaders.position(PlayingSide.ORANGE).toString());
        w.println();
        return null;
    }

    @Override
    public Void putBothLeadersPlaced(BothLeadersPlaced leaders) {
        PrintWriter w = writer();
        w.printf("BL %s %s%n",
                leaders.position(PlayingSide.BLUE).toString(), 
                leaders.position(PlayingSide.ORANGE).toString());
        
        return null;
    }
    
}