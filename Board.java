package kapka.thedrake;

public class Board {
    
    private final int dimension;
    private final Tile[][] tiles;
    
    
    // Konstruktor. Vytvoří čtvercovou hrací desku zadaného rozměru se specefikovanými dlaždicemi.
    // Všechny ostatní dlažice se berou jako prázdné.
    public Board(int dimension, Tile... tiles){
        this.dimension = dimension;
        this.tiles = new Tile[dimension][dimension];
        for(int i = 0; i < dimension; i++)
            for(int j = 0; j < dimension; j++)
                this.tiles[i][j] = new EmptyTile(new TilePosition(i,j));
           
        for(Tile t: tiles){
            this.tiles[t.position().i][t.position().j] = t; 
        }
        //TODO
    }
    
    // Rozměr hrací desky
    public int dimension(){
        return this.dimension;
    }
    
    // Vrací dlaždici na zvolené pozici. Pokud je pozice mimo desku, vyhazuje IllegalArgumentException
    public Tile tileAt(TilePosition position){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // Ověřuje, že pozice se nachází na hrací desce
    public boolean contains(TilePosition... positions){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // Vytváří novou hrací desku s novými dlaždicemi z pole tiles. Všechny ostatní dlaždice zůstávají stejné
    public Board withTiles(Tile... tiles){
        
        Board tmp = new Board(this.dimension,tiles);
        for(int i = 0; i < dimension; i++){
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
