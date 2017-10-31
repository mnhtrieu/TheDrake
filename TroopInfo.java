package kapka.thedrake;

import java.util.Collections;
import java.util.List;

public class TroopInfo {
    
    private String name;
    private Offset2D frontPivot;
    private Offset2D backPivot;


    private List<TroopAction> frontActions;
    private List<TroopAction> backActions;
    
    // Konstruktor
    public TroopInfo(String name, Offset2D frontPivot, Offset2D backPivot,List<TroopAction> frontActions, List<TroopAction> backActions){
        this.name = name;
        this.backPivot = backPivot;
        this.frontPivot = frontPivot;
        this.frontActions = frontActions;
        this.backActions = backActions;
    }
    
    public TroopInfo(String name, Offset2D pivot,List<TroopAction> frontActions, List<TroopAction> backActions){
        this(name, pivot, pivot,frontActions,backActions);
    }

    public TroopInfo(String name,List<TroopAction> frontActions, List<TroopAction> backActions){
        
        this(name,new Offset2D(1,1), new Offset2D(1,1),frontActions,backActions);
        
    }
    
    // Vrací jméno
    public String name(){
        return this.name;
    }
    
    // Vrací pivot na zadané straně jednotky
    public Offset2D pivot(TroopFace face){
        if(face == TroopFace.BACK)
            return backPivot;
        return frontPivot;
    }
    public List<TroopAction> actions(TroopFace face){
        return face == TroopFace.FRONT ? Collections.unmodifiableList(frontActions) : Collections.unmodifiableList(backActions);
    }
}

