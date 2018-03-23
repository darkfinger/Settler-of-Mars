package som.assets;
import som.HexVertex;
import som.Player;

public class Settlement extends Asset {

    private HexVertex hexVertex;
    //hexVertex holds the 2dPoint position
        
    public Settlement(Player player, HexVertex hexVertex ) {
        super (player, hexVertex.getHex());
        this.player = player;      
        this.hex = hexVertex.getHex();
        this.hexVertex= hexVertex;
        

    }
    @Override
    public int getType(){
        return 1;
    }
        

        
        
        
        
        
        
        
        
        
        
        
                
        
        
        
        
        
        
        
        
        
        
        
        
        
}
