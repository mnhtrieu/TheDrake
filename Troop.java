package kapka.thedrake;

import java.util.ArrayList;
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
        StrikeAction strikes = new StrikeAction(pos.i, pos.j);
        ShiftAction shifts = new ShiftAction(pos.i, pos.j);
        SlideAction slides = new SlideAction(pos.i, pos.j);

        actions.addAll(strikes.changesFrom(pos, side, board));
        actions.addAll(shifts.changesFrom(pos, side, board));
        actions.addAll(slides.changesFrom(pos, side, board));

        return actions;
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
