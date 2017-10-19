package kapka.thedrake;

public class Offset2D {
    
    public final int x,y;
    
    
    // Konstruktor
    public Offset2D(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    // Zjištuje, zda se tento offset rovná jinému offsetu
    public boolean equalsTo(int x, int y){
        if(this.x == x && this.y == y)
            return true;
        return false;
    }
    
    // Vrací nový offset s obrácenou y souřadnicí
    public Offset2D yFlipped(){
        Offset2D tmp = new Offset2D(this.x, -(this.y) );
        return tmp;
    }
    
    
}

