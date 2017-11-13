package kapka.thedrake.game;

import kapka.thedrake.media.TileMedia;

public abstract class Tile {

    private final TilePosition position;

    // Konstruktor, který očekává pozici dlaždice na hracím plánu
    protected Tile(TilePosition position) {
        this.position = position;
    }

    // Pozice dlaždice na hracím plánu
    public TilePosition position() {
        return position;
    }

    /* Je možné na dlaždici postavit zadanou jednotku?
     * Parametr troop teď vlastně nepotřebujeme, ale může se hodit
     * nějakým dalším potomkům třídy Tile
     */
    public abstract boolean acceptsTroop(Troop troop);

    // Stojí na dlaždici nějaká jednotka?
    public abstract boolean hasTroop();

    // Jednotka, která na dlaždici zrovna stojí. Pokud tam žádná není, vyhazuje UnsupportedOperationException
    public abstract Troop troop();

    public abstract <T> T putToMedia(TileMedia<T> media);
}
