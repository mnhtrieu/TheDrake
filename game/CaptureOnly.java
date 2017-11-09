package kapka.thedrake.game;

public class CaptureOnly extends BoardChange {

    public CaptureOnly(Board initialBoard, TilePosition origin, TilePosition target) {
        super(initialBoard, origin, target);
    }

    @Override
    public Board resultBoard() {
        return initialBoard.captureOnly(origin, target);
    }
}
