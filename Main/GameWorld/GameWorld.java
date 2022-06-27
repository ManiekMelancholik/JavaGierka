package Main.GameWorld;

import Rendering.IDrawable;
import Rendering.RenderingComponent;
import Rendering.Scene;

public class GameWorld{
    public static GameWorld _instance;

    public final int sizeX;
    public final int sizeY;
    private final Map gameMap;

    public static GameWorld _CREATE(int sizeX, int sizeY,Generator gen){
        _instance = new GameWorld(sizeX,sizeY, gen);
        return _instance;
    }



    private GameWorld(int sizeX, int sizeY, Generator gen){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        gameMap = new Map(sizeX,sizeY, gen);
    }
    public void genScene(){
        gameMap.genView();
    }

}
