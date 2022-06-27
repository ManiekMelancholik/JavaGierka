package Main;

import Game.Game;
import Main.GameWorld.GameWorld;
import Main.MainWindow.MainWindow;

public class Core {
    public static final long _SECOND = 1000;

    public static boolean APP_RUNNING = true;

    public static long FPS = 0;
    public static void main(String... args) {
        long frameStart;
        long frameEnd;
//        MainWindow.getInstance();
        //GameWorld._CREATE(10,10);
//        MainWindow._instance.
        Game g = Game._instance;
        g.updateScene();


        MainWindow._instance.setVisible(true);

        while (APP_RUNNING) {
            frameStart = System.currentTimeMillis();


            Update.UPDATE();
            frameEnd = System.currentTimeMillis();






            if ((frameEnd - frameStart) < _SECOND / 60) {
                try {
                    Thread.sleep(_SECOND/60 - (frameEnd-frameStart));
                    FPS= (1000/(frameEnd-frameStart+(_SECOND/60 - (frameEnd-frameStart))));

                } catch (InterruptedException interruptedException) {

                }
            }else{
                FPS = (1000/(frameEnd-frameStart));
            }

//
            //MainWindow.frameCount.setText("FPS: " + Core.FPS);
        }
    }

}
