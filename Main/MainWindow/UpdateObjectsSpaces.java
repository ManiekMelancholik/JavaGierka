package Main.MainWindow;

import Rendering.IDrawable;

public class UpdateObjectsSpaces {

    public static float cameraSpeed = 5;
    private static float X;
    private static  float Y;
    public static void UpdateObjectsPositions() {

        X = (cameraSpeed * ScreenSpace.RIGHT_LEFT + Zoom.SHIFT*ScreenSpace.RIGHT_LEFT);
        Y = (cameraSpeed * ScreenSpace.UP_DOWN + Zoom.SHIFT * ScreenSpace.UP_DOWN);

        if(Camera._instance.checkBounds(X,Y));
            MainWindow._instance.scene.UpdateScreenPosition(X,Y);

    }
}
