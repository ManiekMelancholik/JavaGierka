package Game;

import Game.GameWorld.Scenes.SceneManager;
//import Game.GameWorld.Scenes.TestScene;
import Main.GameWorld.GameWorld;
import Main.GameWorld.Generator;
import Main.MainWindow.MainWindow;
import Main.Player.Player;
import Main.TurnLogic;
import Rendering.RenderingComponent;
import Rendering.Scene;

import java.awt.*;

public class Game {
    public static Game _instance = new Game();
    private GameWorld logicWorld;
    private Game(){
        //TestScene.INIT();
        logicWorld = GameWorld._CREATE(30,10,new Generator());

        //SceneManager.setCurrentScene(TestScene.scene);
        TurnLogic.getInstance();

    }

    public void updateScene(){
        logicWorld.genScene();
    }
}
