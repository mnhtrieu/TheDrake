package kapka.thedrake.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CapturedTroops {

    private List<TroopInfo> capturedOrange;
    private List<TroopInfo> capturedBlue;

    // Konstruktor vytvářející prázdné seznamy
    public CapturedTroops() {
        capturedOrange = new ArrayList<>();
        capturedBlue = new ArrayList<>();
    }
    
    public CapturedTroops(List<TroopInfo> blueTroops, List<TroopInfo> orangeTroops){
        capturedBlue = blueTroops;
        capturedOrange = orangeTroops;
    }

    // Vrací seznam zajatých jednotek pro daného hráče
    public List<TroopInfo> troops(PlayingSide side) {
        if (side == PlayingSide.BLUE) {
            return Collections.unmodifiableList(capturedBlue);
        }
        return Collections.unmodifiableList(capturedOrange);
    }

    // Přidává nově zajatou jednotku na začátek seznamu zajatých jednotek daného hráče.
    public CapturedTroops withTroop(PlayingSide side, TroopInfo info) {
        CapturedTroops tmp = new CapturedTroops();
        if (side == PlayingSide.BLUE) {
            tmp.capturedBlue.add(info);
        } else {
            tmp.capturedOrange.add(info);
        }

        tmp.capturedBlue.addAll(this.capturedBlue);
        tmp.capturedOrange.addAll(this.capturedOrange);
        return tmp;
    }
}
