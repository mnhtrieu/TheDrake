package kapka.thedrake;

import java.util.List;

public interface TroopStacks {

    public Troop peek(PlayingSide side);

    public TroopStacks pop(PlayingSide side);

    public List<TroopInfo> troops(PlayingSide side);
}
