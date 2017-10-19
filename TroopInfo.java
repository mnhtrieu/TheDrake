package kapka.thedrake;

public class TroopInfo {
    
    private String name;
    private Offset2D frontPivot;
    private Offset2D backPivot;
    
    // Konstruktor
    public TroopInfo(String name, Offset2D frontPivot, Offset2D backPivot){
        this.name = name;
        this.backPivot = backPivot;
        this.frontPivot = frontPivot;
    }
    
    public TroopInfo(String name, Offset2D pivot){
        this(name, pivot, pivot);
    }

    public TroopInfo(String name){
        
        this(name,new Offset2D(1,1), new Offset2D(1,1));        
        
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
}

