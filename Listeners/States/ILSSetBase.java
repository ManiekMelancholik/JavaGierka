package Listeners.States;

import Game.Textures.TexturesHolder;
import Listeners.InGameInputListeners;
import Main.GameWorld.Base.Base;
import Main.GameWorld.IWorldComponent;
import Main.MouseActions.FindIDrawable;
import Rendering.Point;

import java.awt.event.MouseEvent;

public class ILSSetBase extends ListenerState {

    public static final String name = "SB";
//    @Override
//    public void click(MouseEvent e) {
//        Rendering.Point p1 = new Point(e.getX(),e.getY()-130);
//        IWorldComponent IWC = FindIDrawable.get_instance().action(p1);
//        if(IWC.getGameObject() == null){
//
//            IWC.setGameObject(new Base(TexturesHolder.NAME_base_idle));
//
//            InGameInputListeners.getInstance().setState(new ILSDefault());
//        }
//
//    }
    public void click1(IWorldComponent iwc){}
    public void click2(MouseEvent e){
//        click(e);

        Rendering.Point p1 = new Point(e.getX(),e.getY()-130);
        IWorldComponent IWC = FindIDrawable.get_instance().action(p1);
        if(IWC.getGameObject() == null) {

            IWC.setGameObject(new Base(TexturesHolder.NAME_base_idle));

            InGameInputListeners.getInstance().setState(new ILSDefault());

        }
    }

    @Override
    public String getName() {
        return name;
    }
}
