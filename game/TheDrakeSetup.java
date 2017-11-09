package kapka.thedrake.game;

import java.util.List;

public interface TheDrakeSetup {

    public List<TroopInfo> troops();

    // Vrátí info jednotky podle jména jednotky
    public TroopInfo infoByName(String name);
}
