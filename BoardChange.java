package kapka.thedrake;

public abstract class BoardChange {

    protected final Board initialBoard;
    protected final TilePosition origin;
    protected final TilePosition target;

    /*
     * Konstruktor, který bere hrací desku, ze které vycházíme a poté
     * dvě souřadnice, jedna, ze které tah vychází a druhá, na kterou
     * tah směřuje.
     */
    protected BoardChange(Board initialBoard, TilePosition origin, TilePosition target){
        this.initialBoard = initialBoard;
        this.origin = origin;
        this.target = target;
    }

    // Gettry
    public Board initialBoard(){
        return this.initialBoard;
    }
    public TilePosition origin(){
        return this.origin;
    }
    public TilePosition target(){
        return this.target;
    }

    /*
     * Metoda, která vrací novou hrací desku vyrobenou podle toho,
     * jaký tah zrovna provádíme.
     */
    public abstract Board resultBoard();
}
