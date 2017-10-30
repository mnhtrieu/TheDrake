package kapka.thedrake;

import java.util.List;

public class StrikeAction implements TroopAction{

    private final Offset2D position;
    private final Offset2D direction;
           
    public StrikeAction(int strikeX, int strikeY) {
        this(new Offset2D(strikeX, strikeY), new Offset2D(strikeX, strikeY));
    }
    
    public StrikeAction(Offset2D position, Offset2D direction){
        this.position = position;
        this.direction = direction;
    }
    
    @Override
    public List<BoardChange> changesFrom(TilePosition origin, PlayingSide side, Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
