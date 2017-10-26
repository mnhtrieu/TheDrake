package kapka.thedrake;

import java.util.Collections;
import java.util.List;

public class CapturedTroops {

    private List<TroopInfo> capturedOrange;
    private List<TroopInfo> capturedBlue;

    // Konstruktor vytvářející prázdné seznamy
    public CapturedTroops(){
        capturedOrange = Collections.emptyList();
        capturedBlue = Collections.emptyList();
    }

    // Vrací seznam zajatých jednotek pro daného hráče
    public List<TroopInfo> troops(PlayingSide side){
        if(side == PlayingSide.BLUE) return Collections.unmodifiableList(capturedBlue);
        return Collections.unmodifiableList(capturedOrange);
    }

    // Přidává nově zajatou jednotku na začátek seznamu zajatých jednotek daného hráče.
    public CapturedTroops withTroop(PlayingSide side, TroopInfo info){
        CapturedTroops tmp = new CapturedTroops();
        if(side == PlayingSide.BLUE){
            //Collections.copy(tmp.capturedBlue,this.capturedBlue);
            tmp.capturedBlue.add(info);
            tmp.capturedBlue.addAll(this.capturedBlue);
        }
        else{
            tmp.capturedOrange.add(info);
            tmp.capturedOrange.addAll(this.capturedBlue);
        }
        return tmp;
    }
}
