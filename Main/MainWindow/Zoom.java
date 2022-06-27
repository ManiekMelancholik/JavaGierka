package Main.MainWindow;

import PrimitiveRenderingObjects.Hexagon;

public class Zoom {

    public static float zoomValue = 0.2F;

    public static float ZOOM_MAX = 1.4F;

    public static float currentZoom = 1;

    public static float ZOOM_MIN = 0.4F;

    public static int SHIFT=0;

    public static int temp =(int) ((ZOOM_MAX-ZOOM_MIN)/zoomValue)+2;
    public static int temp2 = 0;
    public static float[] ZOOM_LEVELS = {1f/16f, 1F/8F, 1F/4F, 1F/2F,
                                         1F,
                                         2F,4F, 8F, 16F };

    public static int zoomIndexer = 2; // position of 1F


    public static void UpdateZoom(int wheelAction) {
        if(temp2<=0)
            temp2 = Hexagon.DEF_SIZE;

        if(wheelAction>1)wheelAction=1;
        if(wheelAction<-1)wheelAction=-1;

        currentZoom += zoomValue * wheelAction;

        currentZoom = (currentZoom > ZOOM_MAX) ? ZOOM_MAX : currentZoom;

        currentZoom = (currentZoom < ZOOM_MIN) ? ZOOM_MIN : currentZoom;

        SHIFT = (int) ((currentZoom+1) * 10);

        zoomIndexer = ((int)((currentZoom-zoomValue)/zoomValue));

        if(currentZoom<=ZOOM_MAX && currentZoom>=ZOOM_MIN) {
            MainWindow._instance.scene.Scale(ZOOM_LEVELS[zoomIndexer]);
//            temp2 += wheelAction  * 20;
//            MainWindow._instance.scene.Scale(temp2);
//            temp += wheelAction;
        }


//            Hexagon.offset = -wheelAction*SHIFT/5;


        if(currentZoom >= 1F) SHIFT=0;

        MainWindow.UpdateScale(currentZoom);


    }
}
