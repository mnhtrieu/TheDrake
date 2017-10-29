package kapka.thedrake;

public class Board {

    private final int dimension;
    private final Tile[][] tiles;
    private CapturedTroops captured;

    // Konstruktor. Vytvoří čtvercovou hrací desku zadaného rozměru se specefikovanými dlaždicemi.
    // Všechny ostatní dlažice se berou jako prázdné.
    public Board(int dimension, Tile... tiles) {
        this.dimension = dimension;
        this.tiles = new Tile[dimension][dimension];
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                this.tiles[i][j] = new EmptyTile(new TilePosition(i, j));

        for (Tile t : tiles) {
            this.tiles[t.position().i][t.position().j] = t;
        }
    }


    // Rozměr hrací desky
    public int dimension() {
        return this.dimension;
    }

    // Vrací dlaždici na zvolené pozici. Pokud je pozice mimo desku, vyhazuje IllegalArgumentException
    public Tile tileAt(TilePosition position) {

        if ((position.i < 0 || position.i > this.dimension) && (position.j < 0 || position.j > this.dimension))
            throw new IllegalArgumentException();

        for (int i = 0; i < dimension; i++) {
            for (Tile t : tiles[i]) {
                if (t.position().equalsTo(position.i, position.j)) return t;
            }
        }
        return null;
    }

    // Ověřuje, že pozice se nachází na hrací desce
    public boolean contains(TilePosition... positions) {
        for (TilePosition p : positions) {
            try {
                if (tileAt(p) == null) return false;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return true;
    }

    // Vytváří novou hrací desku s novými dlaždicemi z pole tiles. Všechny ostatní dlaždice zůstávají stejné
    public Board withTiles(Tile... tiles) {
        Board tmp = new Board(dimension);
        for (int i = 0; i < dimension; i++) {
            tmp.tiles[i] = this.tiles[i].clone();
        }
        for (Tile t : tiles) {
            tmp.tiles[t.position().i][t.position().j] = t;
        }
        return tmp;

    }

    public Board withCaptureAndTiles(TroopInfo info, PlayingSide side, Tile... tiles) {
        Board newBoard = new Board(dimension);
        CapturedTroops newCaptured = new CapturedTroops();
        newCaptured.withTroop(side, info);
        newBoard.captured = newCaptured;
        newBoard.withTiles(tiles);
        return newBoard;
    }

    // Stojí na pozici origin jednotka?
    public boolean canTakeFrom(TilePosition origin) {
        return tileAt(origin).hasTroop();
    }

    /*
     * Lze na danou pozici postavit zadanou jednotku? Zde se řeší pouze
     * jednotky na hrací ploše, tedy není potřeba kontrolovat, jestli
     * sem jednotka může vstoupit pokud ji hráč bere ze zásobníku.
     */
    public boolean canPlaceTo(Troop troop, TilePosition target) {
            return tileAt(target).acceptsTroop(troop);
    }

    // Může zadaná jednotka zajmout na pozici target soupeřovu jednotku?
    public boolean canCaptureOn(Troop troop, TilePosition target) {
        return tileAt(target).hasTroop();
    }

    /*
     * Stojí na políčku origin jednotka, která může udělat krok na pozici target
     * bez toho, aby tam zajala soupeřovu jednotku?
     */
    public boolean canStepOnly(TilePosition origin, TilePosition target) {
        Troop troop = tileAt(origin).troop();
        return (canTakeFrom(origin) && canPlaceTo(troop,target));
    }

    /*
     * Stojí na políčku origin jednotka, která může zůstat na pozici origin
     * a zajmout soupeřovu jednotku na pozici target?
     */

    public boolean canCaptureOnly(TilePosition origin, TilePosition target) {
        Troop attacker = tileAt(origin).troop();
        return canPlaceTo(attacker,origin) && tileAt(target).hasTroop();
    }

    /*
     * Stojí na pozici origin jednotka, která může udělat krok na pozici target
     * a zajmout tam soupeřovu jednotku?
     */
    public boolean canStepAndCapture(TilePosition origin, TilePosition target) {
        return tileAt(origin).hasTroop() && tileAt(target).hasTroop();
    }

    /*
     * Nová hrací deska, ve které jednotka na pozici origin se přesunula
     * na pozici target bez toho, aby zajala soupeřovu jednotku.
     */
    public Board stepOnly(TilePosition origin, TilePosition target) {

        Troop attacker = tileAt(origin).troop();
        return withTiles(
                new TroopTile(target,attacker.flipped()),
                new EmptyTile(origin));
    }

    /*
     * Nová hrací deska, ve které jednotka na pozici origin se přesunula
     * na pozici target, kde zajala soupeřovu jednotku.
     */
    public Board stepAndCapture(TilePosition origin, TilePosition target) {
        Troop attacker = tileAt(origin).troop();
        Troop targetTroop = tileAt(target).troop();

        return withCaptureAndTiles(
                targetTroop.info(),
                targetTroop.side(),
                new EmptyTile(origin),
                new TroopTile(target, attacker.flipped()));
    }

    /*
     * Nová hrací deska, ve které jednotka zůstává stát na pozici origin
     * a zajme soupeřovu jednotku na pozici target.
     */
    public Board captureOnly(TilePosition origin, TilePosition target) {
        Troop targetTroop = tileAt(target).troop();
        return withCaptureAndTiles(
                targetTroop.info(),
                targetTroop.side(),
                new EmptyTile(target));
    }
}
