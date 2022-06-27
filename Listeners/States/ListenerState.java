package Listeners.States;

import Main.GameWorld.IConnectable;
import Main.GameWorld.IWorldComponent;
import Main.MainWindow.Zoom;
import Main.MouseActions.FindIDrawable;
import Main.MouseActions.Highlight;
import Rendering.Point;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public abstract class ListenerState {

    //protected static IConnectable IC;

    protected static Highlight H;
    protected static final int defRange = 1;
    protected static IWorldComponent iwcSuper;
    protected static Rendering.Point pSuper;
    public static void zoom(MouseWheelEvent e) {
        Zoom.UpdateZoom(e.getWheelRotation());
    }

    public static IWorldComponent click(MouseEvent e){
        if(H != null){
            H.highlightBack();
        }

        pSuper = new Point(e.getX(),e.getY()-130);
        iwcSuper = FindIDrawable.get_instance().action(pSuper);
        H = new Highlight(
                ((IConnectable ic)->{ic.highlightDirect(defRange,Color.MAGENTA);}),
                ((IConnectable ic)->{ic.highlightDirectBack(defRange);}),
                (IConnectable) iwcSuper);
        H.highlight();

        return iwcSuper;

    }
    public abstract void click1(IWorldComponent iwc);
    public abstract void click2(MouseEvent e);
    public abstract String getName();
}
