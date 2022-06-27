package Main.MainWindow;

 public class ScreenSpace {
    static int UP_DOWN;
    static int RIGHT_LEFT;

    public static float screenXBound = 0.05F;
    public static float screenYBound = 0.05F;


    private static boolean _movedLastFrame = false;

    public static void UpdateScreenSpace(){
        if(Cursor.cursorRelativeY - screenYBound<0) UP_DOWN = 1 * Cursor.cursorOutOfBounds;
        else if((Cursor.cursorRelativeY + screenYBound)>1) UP_DOWN = -1 * Cursor.cursorOutOfBounds;
        else UP_DOWN = 0;

        if(Cursor.cursorRelativeX - screenXBound<0) RIGHT_LEFT = 1 * Cursor.cursorOutOfBounds;
        else if((Cursor.cursorRelativeX + screenXBound)>1) RIGHT_LEFT= -1 * Cursor.cursorOutOfBounds;
        else RIGHT_LEFT = 0;
        if(UP_DOWN!=0 || RIGHT_LEFT!=0){
            _movedLastFrame = true;
        }
        if(UP_DOWN==0 && RIGHT_LEFT==0 && _movedLastFrame) {
            _movedLastFrame = false;
            //MainWindow._instance.updateSuper = true;
        }

    }
}
