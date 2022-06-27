package Main.MouseActions;

import Main.GameWorld.IWorldComponent;
import Main.MainWindow.MainWindow;
import PrimitiveRenderingObjects.Hexagon;
import Rendering.Point;
import Rendering.Scene;

public class FindIDrawable {

    private static FindIDrawable _instance;
    public static FindIDrawable get_instance(){
        if(_instance == null) _instance = new FindIDrawable();
        return  _instance;
    }


    IWorldComponent selected;

    public IWorldComponent action(Point screenPoint){

        Scene s = (Scene)MainWindow._instance.scene;
        s.search(screenPoint,(objects -> {
            //((Field)((Hexagon)objects[0]).parent).highlightConnected(3);
            //((Field)((Hexagon)objects[0]).parent).setGameObject(new Unit(TexturesHolder.get_instance().TEXTURE_meh_idle, "walk","shoot"));
            //((Field)((Hexagon)objects[0]).parent).setGameObject(new Base(TexturesHolder.NAME_base_idle));
            selected =((Hexagon) objects[0]).parent;

            return null;
        }));
        return selected;
    }
}
