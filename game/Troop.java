package kapka.thedrake.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Troop {

    private final TroopInfo info;
    private final PlayingSide side;
    private final TroopFace face;

    public Troop(TroopInfo info, PlayingSide side, TroopFace face) {
        this.info = info;
        this.side = side;
        this.face = face;
    }

    // Vytvoří jednotku lícem nahoru
    public Troop(TroopInfo info, PlayingSide side) {
        this(info, side, TroopFace.FRONT);
    }

    // Všechny změny desky, které může jednotka provést na desce board, pokud stojí na pozici pos.
    public List<BoardChange> changesFrom(TilePosition pos, Board board) {
        List<BoardChange> actions = new ArrayList<>();

        for(TroopAction a: info.actions(face)){
            actions.addAll(a.changesFrom(pos,side,board));
        }

        return Collections.unmodifiableList(actions);
    }

    // Info o jednotce
    public TroopInfo info() {
        return this.info;
    }

    // Barva, za kterou jednotka hraje
    public PlayingSide side() {
        return this.side;
    }

    // Kterou stranou je jednotka otočena nahoru
    public TroopFace face() {
        return this.face;
    }

    // Pivot té strany, kterou je zrovna jednotka otočena nahoru
    public Offset2D pivot() {

        return this.info.pivot(this.face);
    }

    // Vytvoří jednotku, která má stejné vlastnosti jako tato, jen je otočena druhou stranou nahoru.
    public Troop flipped() {
        Troop tmp = new Troop(this.info, this.side, this.face == TroopFace.BACK ? TroopFace.FRONT : TroopFace.BACK);
        return tmp;
    }

}
