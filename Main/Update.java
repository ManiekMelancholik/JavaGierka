package Main;

import Main.MainWindow.*;
//import Rendering.Animator;

public class Update {
    public static void UPDATE() {

        Cursor.updateRelativeCursorPosition();
        ScreenSpace.UpdateScreenSpace();
        UpdateObjectsSpaces.UpdateObjectsPositions();
        //Zoom.UpdateZoom();
        Camera._instance.update();
        MainWindow._instance._update();
        //Animator.getInstance()._update();

    }

}
