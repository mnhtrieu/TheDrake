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

        List<TroopInfo> tmpCaptured = captured.troops(PlayingSide.BLUE);
        w.printf("Captured %s: %d%n",PlayingSide.BLUE, tmpCaptured.size());

        for (TroopInfo blueTroop: tmpCaptured){
            w.printf("%s%n", blueTroop.name());
        }

        boolean first = true;
        tmpCaptured = captured.troops(PlayingSide.ORANGE);
        w.printf("Captured %s: %d",PlayingSide.ORANGE, tmpCaptured.size());
        if(tmpCaptured.size() > 0) w.println();
        for (TroopInfo orangeTroop: tmpCaptured){
            if(!first) w.println();
            w.printf("%s", orangeTroop.name());
            first = false;
        }

        return null;
    }

}
