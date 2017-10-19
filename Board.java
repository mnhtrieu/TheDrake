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
    }
    
    // Rozměr hrací desky
    public int dimension(){
        return this.dimension;
    }
    
    // Vrací dlaždici na zvolené pozici. Pokud je pozice mimo desku, vyhazuje IllegalArgumentException
    public Tile tileAt(TilePosition position){

        if((position.i < 0 || position.i > this.dimension) && (position.j < 0 || position.j > this.dimension))
            throw new IllegalArgumentException();

        for(int i = 0; i < dimension; i++){
            for(Tile t: tiles[i]){
                if(t.position().equalsTo(position.i,position.j)) return t;
            }
        }
        return null;
    }
    
    // Ověřuje, že pozice se nachází na hrací desce
    public boolean contains(TilePosition... positions){
        for(TilePosition p: positions){
            try{
                if(tileAt(p) == null) return false;
            }catch(IllegalArgumentException e){
                return false;
            }
        }
        return true;
    }
    
    // Vytváří novou hrací desku s novými dlaždicemi z pole tiles. Všechny ostatní dlaždice zůstávají stejné
    public Board withTiles(Tile... tiles){

        Board tmp = new Board(dimension);

        for(int i = 0; i < dimension; i++){
            tmp.tiles[i] = this.tiles[i].clone();
        }
        for(Tile t: tiles){
            tmp.tiles[t.position().i][t.position().j] = t;
        }

        return tmp;

    }
    
}
