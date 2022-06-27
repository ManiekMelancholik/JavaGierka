package Main.MainWindow;

import java.awt.*;

public class Cursor {
    public static  float cursorRelativeX;
    public static float cursorRelativeY;
    public static int cursorOutOfBounds;

    static public void updateRelativeCursorPosition(){
        java.awt.Point p = MouseInfo.getPointerInfo().getLocation();

        java.awt.Point pos = MainWindow._instance.getLocation();

        cursorRelativeX=(float)(p.x-pos.x) /(float)(MainWindow._instance.getWidth() - (MainWindow._instance.getWidth()-MainWindow.mapContainer.getWidth()));

        cursorRelativeY=(float)(p.y-pos.y-130) /(float)(MainWindow._instance.getHeight()-130);

        if(cursorRelativeX > 1 || cursorRelativeX <0||cursorRelativeY > 1 || cursorRelativeY <0) cursorOutOfBounds=0;
        else cursorOutOfBounds = 1;
    }

}
