package kapka.thedrake;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StandardDrakeSetup implements TheDrakeSetup {
	
    @Override
    public List<TroopInfo> troops() {
            return Arrays.asList(DRAKE, CLUBMAN, MONK, SPEARMAN, SWORDSMAN, ARCHER);
    }


    public final TroopInfo DRAKE = new TroopInfo(
                    "Drake",
                    Arrays.asList(
                                    new SlideAction(1, 0),    
                                    new SlideAction(-1, 0)), 		      
                    Arrays.asList(
                                    new SlideAction(0, 1),
                            new SlideAction(0, -1)));

    public final TroopInfo CLUBMAN = new TroopInfo(
                    "Clubman",
                    Arrays.asList(
                  new ShiftAction(1, 0),    
                  new ShiftAction(0, 1),
                  new ShiftAction(-1, 0),
                  new ShiftAction(0, -1)), 		      
                    Arrays.asList(
                            new ShiftAction(1, 1),    
                  new ShiftAction(-1, 1),
                  new ShiftAction(1, -1),
                  new ShiftAction(-1, -1))); 

    public final TroopInfo MONK = new TroopInfo(
                    "Monk",
                    Arrays.asList(
                                    new SlideAction(1, 1),    
                  new SlideAction(-1, 1),
                  new SlideAction(1, -1),
                  new SlideAction(-1, -1)), 		      
                    Arrays.asList(
                                    new ShiftAction(1, 0),    
                  new ShiftAction(0, 1),
                  new ShiftAction(-1, 0),
                  new ShiftAction(0, -1)));

    public final TroopInfo SPEARMAN = new TroopInfo(
                    "Spearman",
                    Arrays.asList(
                                    new ShiftAction(0, 1),
                                    new StrikeAction(1, 2),    
                  new StrikeAction(-1, 2)), 		      
                    Arrays.asList(
                                    new ShiftAction(1, 1),    
                  new ShiftAction(-1, 1),
                  new ShiftAction(0, -1)));

    public final TroopInfo SWORDSMAN = new TroopInfo(
                    "Swordsman",
                    Arrays.asList(
                                    new StrikeAction(1, 0),    
                  new StrikeAction(0, 1),
                  new StrikeAction(-1, 0),
                  new StrikeAction(0, -1)), 		      
                    Arrays.asList(
                                    new ShiftAction(1, 0),    
                  new ShiftAction(0, 1),
                  new ShiftAction(-1, 0),
                  new ShiftAction(0, -1)));

    public final TroopInfo ARCHER = new TroopInfo(
                    "Archer",
                    new Offset2D(1, 1), 
                    new Offset2D(1, 0),
                    Arrays.asList(
                                    new ShiftAction(1, 0),    
                  new ShiftAction(-1, 0),
                  new ShiftAction(0, -1)), 		      
                    Arrays.asList(    
                  new ShiftAction(0, 1),
                  new StrikeAction(-1, 1),
                  new StrikeAction(1, 1),
                  new StrikeAction(0, 2)));

    private static final HashMap<String, TroopInfo> hMap;
    static{
        hMap = new HashMap<String, TroopInfo>();
        //hMap.put("Drake", DRAKE);
    }
    
    @Override
    public TroopInfo infoByName(String name) {
        //TODO hashmap
        
        throw new IllegalArgumentException();
    }
}
