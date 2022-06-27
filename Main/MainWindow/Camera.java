package Main.MainWindow;

import Main.GameWorld.GameWorld;
import Rendering.Point;

public class Camera {
    public static Camera _instance = new Camera();

    public Point cameraPosition;

    public final Point SPACING;


    public float heightY;
    public float widthX;
    private final int boundX;
    private final int boundY;



    private Camera(){
        cameraPosition = new Point(0,0);
        boundX = GameWorld._instance.sizeX;
        boundY = GameWorld._instance.sizeY;
        SPACING = new Point(10,10);
    }

    public void update(){
        heightY = MainWindow._instance.getHeight();
        widthX = MainWindow._instance.getWidth();
    }
    public boolean checkBounds(float X, float Y) {

        if (X > boundX || X < 0) return false;
        if (Y > boundY || Y < 0) return false;

        return true;
    }





}
