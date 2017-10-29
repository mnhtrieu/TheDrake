package kapka.thedrake;

public class StepAndCapture extends BoardChange {

    public StepAndCapture(Board initialBoard, TilePosition origin, TilePosition target) {
        super(initialBoard, origin, target);
    }

    @Override
    public Board resultBoard() {
        return initialBoard.stepAndCapture(origin,target);
    }
}
