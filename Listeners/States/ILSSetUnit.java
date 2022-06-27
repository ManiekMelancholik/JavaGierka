package Listeners.States;

import Game.Textures.TexturesHolder;
import Listeners.InGameInputListeners;
import Main.GameWorld.Base.Base;
import Main.GameWorld.Field;
import Main.GameWorld.IWorldComponent;
import Main.MouseActions.FindIDrawable;
import Rendering.Point;

import java.awt.event.MouseEvent;

public class ILSSetUnit extends ListenerState {

    private static final String name = "SU";
    Base selectedBase;
   // IWorldComponent IWC;
    public ILSSetUnit(Base b){selectedBase = b;}
//    @Override
//    public void click(MouseEvent e) {
//        Rendering.Point p1 = new Point(e.getX(),e.getY()-130);
//         IWC = FindIDrawable.get_instance().action(p1);
//
//        ((IConnectable)IWC).highlightDirect(1);
//
//        if (IWC.getGameObject().getClassName().equals(Base.className)){
//
//            selectedBase = (Base)IWC.getGameObject();
//            return;
//
//        }
//        if(IWC.getGameObject().getClassName().equals(Unit.className)){
//            return;
//        }
//
//
//    }

    @Override
    public void click1(IWorldComponent iwc) {

    }

    public void click2(MouseEvent e) {
        Rendering.Point p1 = new Point(e.getX(),e.getY()-130);
        IWorldComponent IWC = FindIDrawable.get_instance().action(p1);
        if(IWC.getGameObject() == null) {
            if (selectedBase.readyForAction) {
                if (IWC.getState() == Field._SPAWN_POINT_STATE) {
                    selectedBase.spawnUnit(IWC);
                    selectedBase.readyForAction = false;
                    InGameInputListeners.getInstance().setState(new ILSDefault());
                }
            } else {
                InGameInputListeners.getInstance().setState(new ILSDefault());
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
