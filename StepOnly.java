package kapka.thedrake;

public class StepOnly extends BoardChange {


    protected StepOnly(Board initialBoard, TilePosition origin, TilePosition target) {
        super(initialBoard, origin, target);
    }

    @Override
    public Board resultBoard() {
        return initialBoard.stepOnly(origin,target);
    }
}
