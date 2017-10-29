package kapka.thedrake;

public class CaptureOnly extends BoardChange {


    protected CaptureOnly(Board initialBoard, TilePosition origin, TilePosition target) {
        super(initialBoard, origin, target);
    }

    @Override
    public Board resultBoard() {
        return initialBoard.captureOnly(origin,target);
    }
}
