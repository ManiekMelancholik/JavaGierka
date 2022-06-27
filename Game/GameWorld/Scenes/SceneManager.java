package Game.GameWorld.Scenes;

import Main.MainWindow.MainWindow;
import Rendering.Scene;

public class SceneManager {

    public static Scene currentScene = new Rendering.Scene();

    public static void setCurrentScene(Scene newScene){
        currentScene = newScene;
        MainWindow.UpdateScene(currentScene);
        //MainWindow._instance.scene.Reg();
    }
}
