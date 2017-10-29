package kapka.thedrake;

import java.util.ArrayList;
import java.util.List;

public class SlideAction implements TroopAction {

    private Offset2D direction;

    public SlideAction(int dirX, int dirY) {
        this.direction = new Offset2D(dirX, dirY);
    }

    @Override
    public List<BoardChange> changesFrom(TilePosition origin, PlayingSide side, Board board) {
        List<BoardChange> result = new ArrayList<>();
        TilePosition target = origin.stepByPlayingSide(direction, side);

        while (board.canStepOnly(origin, target)) {
            result.add(new StepOnly(board, origin, target));
            target = target.stepByPlayingSide(direction, side);
        }

        if (board.canStepAndCapture(origin, target))
            result.add(new StepAndCapture(board, origin, target));

        return result;
    }
}
