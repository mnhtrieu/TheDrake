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
    protected BoardChange(Board initialBoard, TilePosition origin, TilePosition target) {
        this.initialBoard = initialBoard;
        this.origin = origin;
        this.target = target;
    }

    // Gettry
    public Board initialBoard() {
        return this.initialBoard;
    }

    public TilePosition origin() {
        return this.origin;
    }

    public TilePosition target() {
        return this.target;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((initialBoard == null) ? 0 : initialBoard.hashCode());
        result = prime * result + ((origin == null) ? 0 : origin.hashCode());
        result = prime * result + ((target == null) ? 0 : target.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BoardChange other = (BoardChange) obj;
        if (!(initialBoard == other.initialBoard)) {
            return false;
        }
        if (origin == null) {
            if (other.origin != null) {
                return false;
            }
        } else if (!origin.equals(other.origin)) {
            return false;
        }

        if (target == null) {

            if (other.target != null) {
                return false;
            }
        } else if (!target.equals(other.target)) {
            return false;
        }

        return true;
    }

    /*
     * Metoda, která vrací novou hrací desku vyrobenou podle toho,
     * jaký tah zrovna provádíme.
     */
    public abstract Board resultBoard();
}
